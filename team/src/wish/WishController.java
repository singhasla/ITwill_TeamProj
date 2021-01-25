
package wish;

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

@WebServlet("/wishsvlt/*")
public class WishController extends HttpServlet {
	WishService wishService;
	WishDAO wishDAO;
	WishVO wishVO;
	MovieVO movieVO;
	/* private static String PRO_IMG_REPO = "C:\\product\\product_img"; */

	@Override
	public void init() throws ServletException {
		wishVO = new WishVO();
		wishService = new WishService();
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
			
			if (action == null || action.equals("/myWishList.do")) {	//로그인한 회원의 찜 목록
				  
				int userNo = Integer.parseInt((String)session.getAttribute("userNo"));
				
				List<MovieVO> list = wishService.myWishList(userNo);
				
				if (!list.isEmpty()) {
					request.setAttribute("myWishList", list);
				}
	
				nextPage = "/wish/wishlist.jsp";
				
			}else if (action.equals("/addWish.do")) {	//회원의 찜목록에 추가

				int userNo = Integer.parseInt(request.getParameter("userNo"));
				int movieNo = Integer.parseInt(request.getParameter("movieNo"));

				wishVO = new WishVO(userNo, movieNo);
				wishService.addItemWish(wishVO);
				
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + " alert('나의 찜 목록에 추가되었습니다.');" 
						+ " location.href='" + request.getContextPath()
						+ "/detailServlet/detail.do?movieNo="+movieNo+"';" + "</script>");
				
				return;

			} else if (action.equals("/allDelWish.do")) {	//로그인한 회원의 찜 목록 전체삭제

				int userNo = Integer.parseInt(request.getParameter("userNo"));
				
				wishService.allDelItem(userNo);

				PrintWriter pw = response.getWriter();
				pw.print("<script>" + " alert('삭제완료');" 
									+ " location.href='" + request.getContextPath()
									+ "/wishsvlt/myWishList.do';" 
						+ "</script>");
				
				return;

			} else if (action.equals("/delWish.do")) {	//찜 목록의 개별 목록 삭제

				int userNo = Integer.parseInt(request.getParameter("userNo"));
				int movieNo = Integer.parseInt(request.getParameter("movieNo"));
				
				wishService.delSelectedItem1(userNo, movieNo);
				
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + " alert('삭제완료');" 
									+ " location.href='" + request.getContextPath()
									+ "/wishsvlt/myWishList.do';" 
						+ "</script>");
				
				return;
			}
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 

}