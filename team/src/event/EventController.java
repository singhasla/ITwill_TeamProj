package event;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

@WebServlet("/eventServlet/*")
public class EventController extends HttpServlet {

	EventService eventService; 
	EventVO eventVO;
	
	@Override
	public void init() throws ServletException {
		eventService = new EventService();
		eventVO = new EventVO();
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
		HttpSession session;
		
		String action = request.getPathInfo();
		
		System.out.println("action: "+action);
		
		try {
			List<EventVO> eventList = new ArrayList<EventVO>();
			if(action == null || action.equals("/listEvent.do")){
				String _section = request.getParameter("section");
				String _pageNum = request.getParameter("pageNum");
				
				int section = Integer.parseInt(((_section == null)? "1":_section));
				int pageNum = Integer.parseInt(((_pageNum == null)? "1":_pageNum));
				
				Map<String, Integer> pagingMap = new HashMap<String, Integer>();
				pagingMap.put("section", section);
				pagingMap.put("pageNum", pageNum);
				
				Map eventsMap = eventService.listEvents(pagingMap);
				eventsMap.put("section", section);
				eventsMap.put("pageNum", pageNum);
				request.setAttribute("eventsMap", eventsMap);
				nextPage = "/event/event.jsp";
				
			} else if (action.equals("/eventForm.do")) {
				nextPage = "/event/eventForm.jsp";
			} else if (action.equals("/addEvent")) {
				
			} else {
				nextPage = "/event/event.jsp";
			} 
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
