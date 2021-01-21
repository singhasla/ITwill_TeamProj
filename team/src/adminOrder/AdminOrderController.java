package adminOrder;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.beans.decoder.ValueObject;

import order.MovieVO;
import order.OrderVO;

@WebServlet("/adminOrdersvlt/*")
public class AdminOrderController extends HttpServlet {
	AdminOrderService adminOrderService;
	AdminOrderDAO adminOrderDAO;
	AdminOrderVO adminOrderVO;
	/* private static String PRO_IMG_REPO = "C:\\product\\product_img"; */

	@Override
	public void init() throws ServletException {
		adminOrderService = new AdminOrderService();
		adminOrderDAO = new AdminOrderDAO();
		adminOrderVO = new AdminOrderVO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "";

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession();
		// realPath = request.getServletContext().getRealPath("/files/product");

		String action = request.getPathInfo();
		System.out.println("action:" + action);

		try {

			if (action == null || action.equals("/orderList.do")) {	//전체 주문 목록

				List<AdminOrderVO> list = adminOrderService.orderList();
				
				int totalSales = adminOrderService.totalSales();
				request.setAttribute("totalSales", totalSales);
				
				if (!list.isEmpty()) {
					request.setAttribute("orderList", list);
					request.setAttribute("action", action);
				}

				nextPage = "/admin/dist/order/adminOrder.jsp";

			} else if (action.equals("/delOrder.do")) { //관리자페이지 주문내역 일부 주문만 삭제

				int orderNo = Integer.parseInt(request.getParameter("orderNo"));

				adminOrderService.delSelectedItem(orderNo);

				PrintWriter pw = response.getWriter();
				pw.print("<script>" + " alert('삭제완료');" 
						+ " location.href='" + request.getContextPath()
						+ "/adminOrdersvlt/orderList.do';" + "</script>");

				return;
				
			} else if (action.equals("/sales.do")) { //기간내 매출리스트 및 매출액 출력

				String startDate = request.getParameter("start");
				Date start = Date.valueOf(startDate);
				String endDate = request.getParameter("end");
				Date end = Date.valueOf(endDate);
				
				int totalSales = adminOrderService.totalSales();
				request.setAttribute("totalSales", totalSales);
				
				int periodSales = adminOrderService.periodSales(start, end);
				request.setAttribute("periodSales", periodSales);

				List<AdminOrderVO> list = adminOrderService.periodList(start, end);
				if (!list.isEmpty()) {
					request.setAttribute("periodList", list);
					request.setAttribute("action", action);
				}
				
				nextPage = "/admin/dist/order/adminOrder.jsp";
			}

			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}