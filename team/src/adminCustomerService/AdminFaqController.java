package adminCustomerService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customerService.FaqDAO;
import customerService.FaqVO;

@WebServlet("/faqAdmin/*")
public class AdminFaqController extends HttpServlet{
	FaqDAO faqDAO;
	FaqVO faqVO;
	String realPath;
	
	@Override
	public void init() throws ServletException {
		faqDAO = new FaqDAO();
		faqVO = new FaqVO();
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
		
		String action = request.getPathInfo();
		System.out.println("action: " + action);
		
		try {
			
			if(action == null || action.equals("/listFaq.do") ) {
			
			} else if (action.equals("/readFaq.do")) {
				
			} else if (action.equals("/readFaq.do")) {
				
			} else if (action.equals("/modifyFaq.do")) {
				
			} else if (action.equals("/updateFaq.do")) {
				
			} else if(action.equals("/deleteFaq.do")) {	
				
			} else {
				nextPage = "/admin/dist/customerService/faqList.jsp";
			}
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
