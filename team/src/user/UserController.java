package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/*")
public class UserController extends HttpServlet{
	
	UserDAO userDAO;
	
	@Override
	public void init() throws ServletException {
		userDAO = new UserDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet = " + request.getRequestURI());
		doHandle(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost = " + request.getRequestURI());
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		
		String action = request.getRequestURI();
		action = action.substring(action.lastIndexOf('/'));
		System.out.println("UserController action: " + action);
		
		String nextPage = null;
		nextPage = "/login/signup.jsp";
		
		if(action == null){
			nextPage ="/";
		}else if(action.equals("/signup.do")){
			System.out.println("회원가입");
			String userID = request.getParameter("userID");
			String userPW = request.getParameter("userPW");
			String userName = request.getParameter("userName");
			String userNickname = request.getParameter("userNickname");
			String userTel = request.getParameter("userTel");
			String userEmail = request.getParameter("userEmail");
			String userAddr1 = request.getParameter("userAddr1");
			String userAddr2 = request.getParameter("userAddr2");
			String userAddr3 = request.getParameter("userAddr3");
			String userAddr4 = request.getParameter("userAddr4");
			
			UserVO userVO = new UserVO(userID, userPW, userName, userNickname, userTel, userEmail, userAddr1, userAddr2, userAddr3, userAddr4);
			userDAO.signup(userVO); 

			nextPage = "/login/login.jsp";
		
			
		} else if (action.equals("/idCheck.do")) {
			String userID = request.getParameter("userID");
			request.setAttribute("userID", userID);
			int check = userDAO.idCheck(userID);
			System.out.println(userID);
			if (userID.length() < 4 || userID.length() > 12) {
				request.setAttribute("msg", "char");
				System.out.println("조건");
			} else if (check == 1) {
				request.setAttribute("msg", "used");
				System.out.println("사용중");
			} else {
				request.setAttribute("msg", "allow");
				System.out.println("가능");
			}
			nextPage = "/login/idCheck.jsp";
			
		} else if (action.equals("/signupForm.do")) {
			nextPage = "/login/signup.jsp";
			
		} else if (action.equals("/login.do")) {
			
				String userID = request.getParameter("userID");
				String userPW = request.getParameter("userPW");
				
				int check = userDAO.login(userID, userPW);
				
				if(check == 0){
					nextPage = "/login/login.jsp";//아이디 없음
					request.setAttribute("msg", "id");
				}else if(check == 2){
					nextPage = "/login/login.jsp";//비밀번호틀림
					request.setAttribute("msg", "pw");
				}else{
					
					session.setAttribute("userID", userID);
					nextPage = "/main/index.jsp";
				}
			
			
			} else if (action.equals("/logout.do")) {
				session.invalidate();
				nextPage = "/main/index.jsp";
				
			} else if (action.equals("/nickCheck.do")) {
				String userNickname = request.getParameter("userNickname");
				request.setAttribute("userNickname", userNickname);
				int check = userDAO.nickCheck(userNickname);
				
				System.out.println(userNickname);
				if (check == 1) {
					request.setAttribute("msg", "used");
					System.out.println("사용중");
				} else {
					request.setAttribute("msg", "allow");
					System.out.println("가능");
				}
				
				nextPage = "/login/nick.jsp";
			} else if (action.equals("/telCheck.do")) {
				String userTel = request.getParameter("userTel");
				request.setAttribute("userTel", userTel);
				int check = userDAO.telCheck(userTel);
				
				System.out.println(userTel);
				if (check == 1) {
					request.setAttribute("msg", "used");
					System.out.println("사용중");
				} else {
					request.setAttribute("msg", "allow");
					System.out.println("가능");
				}
				
				nextPage = "/login/telCheck.jsp";
			} else if (action.equals("/mailCheck.do")) {
				String userEmail = request.getParameter("userEmail");
				request.setAttribute("userEmail", userEmail);
				int check = userDAO.mailCheck(userEmail);
				
				System.out.println(userEmail);
				if (check == 1) {
					request.setAttribute("msg", "used");
					System.out.println("사용중");
				} else {
					request.setAttribute("msg", "allow");
					System.out.println("가능");
				}
				
				nextPage = "/login/mailCheck.jsp";
			}
		
			
		/*	else if (action.equals("/logo.png")) {
				
			}*/
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
