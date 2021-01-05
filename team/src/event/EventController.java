package event;

import java.io.File;
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
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

@WebServlet("/eventServlet/*")
public class EventController extends HttpServlet {
	
	String realPath;
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
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EventVO eventVO = new EventVO();
		
		realPath = request.getServletContext().getRealPath("/files/event");
		
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
				
			} else if (action.equals("/addEvent.do")) {
				
				int eventNo = 0;
				Map<String, String> eventMap = upload(request, response);
				
				String title = eventMap.get("eventTitle");
				String content = eventMap.get("eventCotent");
				String imageFileName = eventMap.get("eventImage");
				
				eventVO.setEventTitle(title);
				eventVO.setEventContent(content);
				eventVO.setEventImage(imageFileName);
				
				eventNo = eventService.addEvent(eventVO);
				
				if(imageFileName != null && imageFileName.length() != 0) {
					
					File srcFile = new File(realPath + "\\" + "temp" + "\\" + imageFileName);
					File destDir = new File(realPath + "\\" + eventNo);
					destDir.mkdir();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
		
				}
				
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("window.alert('새글을 추가했습니다.')");
				out.print("location.href='" + request.getContextPath() + "/eventServlet/event.do';");
				out.print("</script>");
				return;
				
			} else {
				nextPage = "/event/event.jsp";
			} 
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> eventMap = new HashMap<String, String>();
		
		String encoding = "utf-8";
		File currentDirPath = new File(realPath);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024*1024*1);
		factory.setRepository(currentDirPath);
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List items = upload.parseRequest(request);
			
			for(int i=0; i<items.size(); i++){
				
				DiskFileItem fileItem = (DiskFileItem)items.get(i);
				
				if(fileItem.isFormField()) {
					eventMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
					
				} else {
					
					eventMap.put(fileItem.getFieldName(), fileItem.getName());
					
					if(fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						
						if(idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						
						String fileName = fileItem.getName().substring(idx + 1);
						eventMap.put(fileItem.getFieldName(), fileName);
						String tempDirPath = realPath + "\\temp";
						File tempDir = new File(tempDirPath);
						
						if(!tempDir.exists()) {
							tempDir.mkdir();
						}
						File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
						fileItem.write(uploadFile);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eventMap;
	}
	
	
}
