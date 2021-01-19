package order;

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

@WebServlet("/ordersvlt/*")
public class OrderController extends HttpServlet {
	OrderService orderService;
	OrderDAO orderDAO;
	OrderVO cartVO;
	/* private static String PRO_IMG_REPO = "C:\\product\\product_img"; */

	@Override
	public void init() throws ServletException {
		cartVO = new OrderVO();
		orderService = new OrderService();
	}

	@Override
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response)
						 throws ServletException, IOException {

		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response)	
						  throws ServletException, IOException {

		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, 
							HttpServletResponse response)
							throws ServletException, IOException {
		String nextPage = "";
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession();
		//realPath = request.getServletContext().getRealPath("/files/product");
		
		String action = request.getPathInfo();
		System.out.println("action:" + action);


		try {
			
			if (action == null || action.equals("/cart.do")) {	//로그인한 회원의 카트목록
				  
				String userID = (String)session.getAttribute("userID");
				
				int userNo = orderService.myUserNo(userID);
				//int userNo = (int) session.getAttribute("userNo");
				session.setAttribute("userNo", Integer.toString(userNo));
				
				List<MovieVO> list = orderService.myCartList(userNo);
				
				int totalprice = orderService.cartTotalPrice(userNo);
				
				if (!list.isEmpty()) {
					request.setAttribute("myCartList", list);
				}
					request.setAttribute("TotalPrice", totalprice);
	
				nextPage = "/order/cart.jsp";
				
			} else if (action.equals("/addCart.do")) {	//회원의 장바구니에 추가

				int userNo = Integer.parseInt(request.getParameter("userNo"));
				int movieNo = Integer.parseInt(request.getParameter("movieNo"));

				cartVO = new OrderVO(userNo, movieNo);
				orderService.addItemCart(cartVO);
				
				return;

			} else if (action.equals("/allDelCart.do")) {	//로그인한 회원의 카트 목록 전체삭제

				int userNo = Integer.parseInt(request.getParameter("userNo"));
				
				orderService.allDelItem(userNo);

				PrintWriter pw = response.getWriter();
				pw.print("<script>" + " alert('삭제완료');" 
									+ " location.href='" + request.getContextPath()
									+ "/ordersvlt/cart.do';" 
						+ "</script>");
				
				return;

			} else if (action.equals("/delCart.do")) {	//카트의 개별 목록 삭제

				int userNo = Integer.parseInt(request.getParameter("userNo"));
				int movieNo = Integer.parseInt(request.getParameter("movieNo"));
				
				orderService.delSelectedItem(userNo, movieNo);
				
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + " alert('삭제완료');" 
									+ " location.href='" + request.getContextPath()
									+ "/ordersvlt/cart.do';" 
						+ "</script>");
				
				return;
				

			} else if (action.equals("/pay.do")) {	// 결제페이지

				String userID = (String)session.getAttribute("userID");
				
				int userNo = orderService.myUserNo(userID);
				//int userNo = (int) session.getAttribute("userNo");
				session.setAttribute("userNo", Integer.toString(userNo));
				
				List<MovieVO> list = orderService.myCartList(userNo);
				
				String firstMN = orderService.firstMovieName(userNo);
				int totalprice = orderService.cartTotalPrice(userNo);
				int totalcount = orderService.cartTotalCount(userNo);
				
				request.setAttribute("firstMN", firstMN);
				request.setAttribute("totalprice", totalprice);
				request.setAttribute("totalcount", totalcount);
	
				nextPage = "/order/payment.jsp";

			} else if (action.equals("/paycomplt.do")) {	// 결제완료 후 status 변경

				String userID = (String)session.getAttribute("userID");
				
				int userNo = orderService.myUserNo(userID);
				//int userNo = (int) session.getAttribute("userNo");
				session.setAttribute("userNo", Integer.toString(userNo));
				
				orderService.updateStatus(userNo);
	
				nextPage = "/order/ordercomplt.jsp";

			} else if (action.equals("/myOrderList.do")) {
				
				String userID = (String)session.getAttribute("userID");
				
				int userNo = orderService.myUserNo(userID);
				//int userNo = (int) session.getAttribute("userNo");
				session.setAttribute("userNo", Integer.toString(userNo));
				
				List<MovieVO> list = orderService.myOrderList(userNo);
				
				if (!list.isEmpty()) {
					request.setAttribute("myOrderList", list);
				}
	
				nextPage = "/order/orderlist.jsp";
				
			}
			
			
			
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 

}