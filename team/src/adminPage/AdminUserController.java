package adminPage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.UEncoder;

import user.UserDAO;
import user.UserVO;



@WebServlet("/adminPage/*")
public class AdminUserController extends HttpServlet{
	
	UserVO userVO;
	AdminUserService adminUserService;
	
	@Override
	public void init() throws ServletException {
		adminUserService = new AdminUserService();
		userVO = new UserVO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "";

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String action = request.getRequestURI();
		action = action.substring(action.lastIndexOf('/'));
		System.out.println("action: " + action);
		
		if (action.equals("/dashBoard.do")) {//회원관리
			String searchKeyword = request.getParameter("searchKeyword");
			
			List userList = adminUserService.userlist(searchKeyword);
			System.out.println(userList);
			
			int total = adminUserService.total(searchKeyword);
			
			request.setAttribute("userList", userList);
			request.setAttribute("total", total);
			
			nextPage = "/admin/dist/main/adminMain.jsp";
			
		} else if (action.equals("/mainHome.do")) {
			nextPage = "/main/index.jsp";
		}else if(action.equals("/modUser.do")) {
			String userID = request.getParameter("userID");
			
			UserVO userVO = adminUserService.getUser(userID);
			
			
			nextPage = "/admin/dist/userPage/modUser.jsp";
		}else if(action.equals("/delUser.do")) {
			
			
			nextPage = "/admin/dist/main/adminMain.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
	
}
