package adminCustomerService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customerService.QnaDAO;
import customerService.QnaVO;

@WebServlet("/qnaAdmin/*")
public class AdminQnaController extends HttpServlet{
	QnaDAO qnaDAO;
	QnaVO qnaVO;
	String realPath;
	
	@Override
	public void init() throws ServletException {
		qnaDAO = new QnaDAO();
		qnaVO = new QnaVO();
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
			
			if(action == null || action.equals("/listQna.do")) {
				
				String answerCheck = request.getParameter("answerCheck");
				List<QnaVO> qnaList = qnaDAO.qnaList(answerCheck);
				int qnaListCount = qnaDAO.qnaListCount();
				request.setAttribute("qnaList", qnaList);
				request.setAttribute("qnaListCount", qnaListCount);
				
				nextPage = "/admin/dist/customerService/qnaList.jsp";
			
			} else if(action.equals("/readQna.do")) {
				
				int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
				QnaVO qnaVO = qnaDAO.getQna(qnaNo);
				
				request.setAttribute("qnaVO", qnaVO);
				
				nextPage = "/admin/dist/customerService/qnaRead.jsp";
				
			} else if(action.equals("/answerQna.do")) {
				
				int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
				QnaVO qnaVO = qnaDAO.getQna(qnaNo);
				request.setAttribute("qnaVO", qnaVO);
				
				nextPage = "/admin/dist/customerService/qnaAnswer.jsp";
			
			} else if(action.equals("/insertAnswer.do")) {	
				
				int _qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
				String answerContent = request.getParameter("answerContent");
				
				qnaDAO.insertAnswer(_qnaNo, answerContent);
				
				PrintWriter out = response.getWriter();
				out.print("<script>"
						 + " window.alert('답변을 등록했습니다.');"
						 + " location.href='" + request.getContextPath() 
						 + "/qnaAdmin/readQna.do?qnaNo="+ _qnaNo +"';"
						 + "</script>"
						 );
				return;
				
			} else if(action.equals("/deleteQna.do")) {	
				
				int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
				qnaDAO.deleteQna(qnaNo);
				
				PrintWriter out = response.getWriter();
				out.print("<script>"
						 + " window.alert('문의내역을 삭제했습니다.');"
						 + " location.href='" + request.getContextPath()  + "/qnaAdmin/listQna.do';"
						 + "</script>"
						 );
				return;
			} else {
				nextPage = "/admin/dist/customerService/qnaList.jsp";
			}
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
