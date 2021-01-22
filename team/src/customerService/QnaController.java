package customerService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/qna/*")
public class QnaController extends HttpServlet {
	
	QnaDAO qnaDAO;
	QnaVO qnaVO;
	
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
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		
		try {
			
			if(action == null || action.equals("/addQna.do")) {
				
				nextPage = "/customerService/qnaForm.jsp";
				
			} else if(action.equals("/insertQna.do")) {		
				
				int userNo = Integer.parseInt(request.getParameter("userNo"));
				String qnaTitle = request.getParameter("qnaTitle");
				String qnaCategory = request.getParameter("qnaCategory");
				String qnaContent = request.getParameter("qnaContent");
				
				qnaVO.setUserNo(userNo);
				qnaVO.setQnaTitle(qnaTitle);
				qnaVO.setQnaContent(qnaContent);
				qnaVO.setQnaCategory(qnaCategory);
				
				int qnaNo = qnaDAO.insertQna(qnaVO);
				System.out.println(qnaNo);
				
				PrintWriter out = response.getWriter();
				out.print("<script>"
						 + " window.alert('문의가 등록되었습니다.');"
						 + " location.href='" 
						 + request.getContextPath() + "/qna/myQnaList.do';"
						 + "</script>");
				return;
				
			} else if(action.equals("/myQnaList.do")) {
				
				int userNo = Integer.parseInt((String)session.getAttribute("userNo"));
				String _section = request.getParameter("section");
				String _pageNo = request.getParameter("pageNo");			
				
				int section = Integer.parseInt(((_section == null) ? "1" : _section));
				int pageNo = Integer.parseInt(((_pageNo == null) ? "1" : _pageNo));
				
				Map<String, Object> qnaMap = new HashMap<String, Object>();
				qnaMap.put("pageNo", pageNo);
				qnaMap.put("section", section);
				qnaMap.put("userNo", userNo);
				request.setAttribute("qnaMap", qnaMap);
				
				List<QnaVO> qnaList = qnaDAO.myQnaList(qnaMap);
				int qnaListCount = qnaDAO.qnaListCount(userNo);
				request.setAttribute("qnaList", qnaList);
				request.setAttribute("qnaListCount", qnaListCount);
				
				nextPage = "/customerService/qnaList.jsp";
			
			} else if(action.equals("/viewQna.do")) {
				
				int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
				QnaVO qnaVO = qnaDAO.getQna(qnaNo);
				
				request.setAttribute("qnaVO", qnaVO);
				
				nextPage = "/customerService/qnaView.jsp";
				
			} else {
				nextPage = "/customerService/qnaForm.jsp";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
