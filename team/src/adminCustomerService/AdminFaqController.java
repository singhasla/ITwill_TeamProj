package adminCustomerService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
				
				List<FaqVO> faqList = faqDAO.getFaqList();
				int faqListCount = faqDAO.faqListCount();
				request.setAttribute("faqList", faqList);
				request.setAttribute("faqListCount", faqListCount);
				
				nextPage = "admin/dist/customerService/faqList.jsp";

			} else if (action.equals("/readFaq.do")) {
				
				int faqNo = Integer.parseInt(request.getParameter("faqNo"));
				FaqVO faqVO = faqDAO.getFaq(faqNo);
				request.setAttribute("faqVO", faqVO);
				
				nextPage = "/admin/dist/customerService/faqRead.jsp";
				
			} else if (action.equals("/addFaq.do")) {
				
				nextPage = "/admin/dist/customerService/faqAdd.jsp";
			
			} else if (action.equals("/insertFaq.do")) {	
				
				String faqTitle = request.getParameter("faqTitle");
				String faqContent = request.getParameter("faqContent");
				
				faqVO.setFaqTitle(faqTitle);
				faqVO.setFaqContent(faqContent);
				
				int faqNo = faqDAO.insertFaq(faqVO);
				
				PrintWriter out = response.getWriter();
				out.print("<script>"
						 + " window.alert('FAQ를 추가했습니다.');"
						 + " location.href='" + request.getContextPath() 
						 + "/faqAdmin/readFaq.do?faqNo="+ faqNo +"';"
						 + "</script>"
						 );
				return;
				
			} else if (action.equals("/modifyFaq.do")) {
				int faqNo = Integer.parseInt(request.getParameter("faqNo"));
				FaqVO faqVO = faqDAO.getFaq(faqNo);
				request.setAttribute("faqVO", faqVO);
				
				nextPage = "/admin/dist/customerService/faqUpdate.jsp";
			
			} else if (action.equals("/updateFaq.do")) {
				
				int faqNo = Integer.parseInt(request.getParameter("faqNo"));
				String faqTitle = request.getParameter("faqTitle");
				String faqContent = request.getParameter("faqContent");
				
				faqVO.setFaqNo(faqNo);
				faqVO.setFaqTitle(faqTitle);
				faqVO.setFaqContent(faqContent);
				
				faqDAO.updateFaq(faqVO);
				
				PrintWriter out = response.getWriter();
				out.print("<script>"
						 + " window.alert('FAQ를 수정했습니다.');"
						 + " location.href='" + request.getContextPath() 
						 + "/faqAdmin/readFaq.do?faqNo="+ faqNo +"';"
						 + "</script>"
						 );
				return;
			} else if(action.equals("/deleteFaq.do")) {	
				
				int faqNo = Integer.parseInt(request.getParameter("faqNo"));
				faqDAO.deleteFaq(faqNo);
				PrintWriter out = response.getWriter();
				out.print("<script>"
						 + " window.alert('FAQ를 삭제했습니다.');"
						 + " location.href='" + request.getContextPath()  + "/faqAdmin/listFaq.do';"
						 + "</script>"
						 );
				return;
				
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
