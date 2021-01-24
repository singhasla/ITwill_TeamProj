package adminCustomerService;

import java.io.IOException;

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
