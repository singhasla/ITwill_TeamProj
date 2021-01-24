package myInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import order.OrderDAO;
import order.OrderService;

@WebServlet("/me/*")
public class myInfoController extends HttpServlet{
	myInfoDAO userDAO;
	myInfoVO userVO;
	OrderService orderService;
	
	@Override
	public void init() throws ServletException {
		userDAO = new myInfoDAO();
		userVO = new myInfoVO();
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
		System.out.println("action: " + action);
		
		String nextPage = null;
		try{
		if(action == null || action.equals("/info.do")){//불러오기
			
			//String userID = (String)session.getAttribute("userID");
			String userID = request.getParameter("userID");
			myInfoVO vo = userDAO.myInfoList(userID);
			request.setAttribute("list", vo);
			nextPage ="/myInfo/modUserForm.jsp";
			
		}else if(action.equals("/modUser.do")){//수정하기
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
			
			myInfoVO userVO = new myInfoVO(userID, userPW, userName, userNickname, userTel, userEmail, userAddr1, userAddr2, userAddr3, userAddr4);
			userDAO.modUser(userVO); 

			nextPage = "/mainServlet/main.do";
		
			
		}else if (action.equals("/idCheck.do")) {
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
			nextPage = "../login/signup.jsp";
			
		} else if (action.equals("/login.do")) {
			
				String userID = request.getParameter("userID");
				String userPW = request.getParameter("userPW");
				
				int userNo = orderService.myUserNo(userID);
				int check = userDAO.login(userID, userPW);
				
				if(check == 0){
					nextPage = "/login/login.jsp";//아이디 없음
					request.setAttribute("msg", "id");
				}else if(check == 2){
					nextPage = "/login/login.jsp";//비밀번호틀림
					request.setAttribute("msg", "pw");
				}else{
					session.setAttribute("userNo", Integer.toString(userNo));
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
				
				nextPage = "../login/nick.jsp";
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
				
				nextPage = "../login/mailCheck.jsp";
				
			} else if (action.equals("/findId.do")) {
				
				nextPage = "../login/idFind.jsp";
			} else if (action.equals("/loginPage.do")) {
				
				nextPage = "../login/login.jsp";
				
			} else if (action.equals("/idfindAct.do")) {
				String userName = request.getParameter("userName");
				String userEmail = request.getParameter("userEmail");
				
				String userID = userDAO.idFind(userName,userEmail);
				
				if (userID == null || userID.equals("")) {
					request.setAttribute("msg", "no");
					nextPage = "../login/idFind.jsp";
				} else {
					request.setAttribute("userID", userID);
					nextPage = "../login/idFind.jsp";
				}
				
			} else if (action.equals("/pwfindAct.do")) {
				String userID = request.getParameter("userId");
				String userEmail = request.getParameter("userEmail");
				String userPW = userDAO.findPW(userID,userEmail);
				request.setAttribute("userEmail", userEmail);
				request.setAttribute("userPW", userPW);
				nextPage = "/user/sendMail.do";
				
			}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
