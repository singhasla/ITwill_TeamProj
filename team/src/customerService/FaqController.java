package customerService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import com.mysql.jdbc.ReplicationMySQLConnection;

@WebServlet("/faq/*")
public class FaqController extends HttpServlet {
	
	FaqDAO faqDAO;
	FaqVO faqVO;
	
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
		response.setContentType("text/html; charset=utf-8");
		
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		
		try {
			
			if(action == null || action.equals("/listFaq.do")) {
				
				String _search = request.getParameter("search");		
				String _section = request.getParameter("section");
				String _pageNo = request.getParameter("pageNo");			
				
				int section = Integer.parseInt(((_section == null) ? "1" : _section));
				int pageNo = Integer.parseInt(((_pageNo == null) ? "1" : _pageNo));
				String search = (_search == null) ? "" : _search;
				
				Map<String, Object> faqMap = new HashMap<String, Object>();
				faqMap.put("pageNo", pageNo);
				faqMap.put("section", section);
				faqMap.put("search", search);
				request.setAttribute("faqMap", faqMap);
				
				List<FaqVO> faqList = faqDAO.faqList(faqMap);
				int faqListCount = faqDAO.faqListCount();
				request.setAttribute("faqList", faqList);
				request.setAttribute("faqListCount", faqListCount);
				
				nextPage = "/customerService/faqList.jsp";
				
			} else {
				
				nextPage = "/customerService/faqList.jsp";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
