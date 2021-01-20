package adminOrder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


				if (!list.isEmpty()) {
					request.setAttribute("orderList", list);
				}

				nextPage = "/admin/dist/order/adminOrder.jsp";

			} else if (action.equals("/delOrder.do")) {

				int orderNo = Integer.parseInt(request.getParameter("orderNo"));

				adminOrderService.delSelectedItem(orderNo);

				PrintWriter pw = response.getWriter();
				pw.print("<script>" + " alert('삭제완료');" + " location.href='" + request.getContextPath()
						+ "/adminOrdersvlt/orderList.do';" + "</script>");

				return;
			}

			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}