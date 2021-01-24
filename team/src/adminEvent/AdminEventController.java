package adminEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.sun.javafx.event.EventHandlerManager;

import event.EventDAO;
import event.EventVO;


@WebServlet("/eventAdmin/*")
public class AdminEventController extends HttpServlet{
	
	EventVO eventVO;
	EventDAO eventDAO;
	String realPath;
	
	@Override
	public void init() throws ServletException {
		eventVO = new EventVO();
		eventDAO = new EventDAO();
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
		realPath = request.getServletContext().getRealPath("/files/event");
		
		request.setCharacterEncoding("UTF-8");		
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getPathInfo();
		System.out.println("action: " + action); 
		
		try {
			if(action == null || action.equals("/listEvent.do")){
				
				Map<String, Object> eventMap = new HashMap<String, Object>();
				List<EventVO> eventList = eventDAO.getNewEventList();
				int eventListCount = eventDAO.getEventListCount();
				eventMap.put("eventList", eventList);
				eventMap.put("eventListCount", eventListCount);
				
				request.setAttribute("eventMap", eventMap);
				
				nextPage = "/admin/dist/event/eventList.jsp";
				
			} else if(action.equals("/addEvent.do")) {
				
				nextPage = "/admin/dist/event/eventAdd.jsp";
				
			} else if(action.equals("/insertEvent.do")) {
				
				Map<String, String> multipartMap = uploadFile(request);
				String eventTitle = multipartMap.get("eventTitle");
				String eventContent = multipartMap.get("eventContent");
				String eventImage = multipartMap.get("eventImage");
				
				eventVO.setEventTitle(eventTitle);
				eventVO.setEventContent(eventContent);
				eventVO.setEventImage(eventImage);
				
				int eventNo = eventDAO.insertEvent(eventVO);
				
				if(eventImage != null && eventImage.length() != 0) {
					moveFile(eventNo, eventImage);
				}
				
				PrintWriter out = response.getWriter();
				out.print("<script>"
						 + " window.alert('새글을 추가했습니다.');"
						 + " location.href='" + request.getContextPath() 
						 + "/eventAdmin/readEvent.do?eventNo=" + eventNo + "';"
						 + "</script>"
						 );
				return;
				
			} else if(action.equals("/readEvent.do")) {
				
				int eventNo = Integer.parseInt(request.getParameter("eventNo"));
				Map<String, Object> eventMap = new HashMap<String, Object>();
				EventVO eventVO = eventDAO.getEvent(eventNo);
				eventMap.put("eventVO", eventVO);
				request.setAttribute("eventMap", eventMap);
				
				nextPage = "/admin/dist/event/eventRead.jsp";
			
			} else if(action.equals("/modifyEvent.do")) {		
				
				int eventNo = Integer.parseInt(request.getParameter("eventNo"));
				Map<String, Object> eventMap = new HashMap<>();
				EventVO eventVO = eventDAO.getEvent(eventNo);
				eventMap.put("eventVO", eventVO);
				
				request.setAttribute("eventMap", eventMap);
				
				nextPage = "/admin/dist/event/eventUpdate.jsp";
				
			} else if(action.equals("/updateEvent.do")) {		
				
				Map<String, String> multipartMap = uploadFile(request);
				
				int eventNo = Integer.parseInt(multipartMap.get("eventNo"));
				String eventTitle = multipartMap.get("eventTitle");
				String eventContent = multipartMap.get("eventContent");
				String eventImage = multipartMap.get("eventImage");
				String deleteFile = multipartMap.get("deleteFile");
				String originalFile = multipartMap.get("originalFile");
				
				eventVO.setEventNo(eventNo);
				eventVO.setEventTitle(eventTitle);
				eventVO.setEventContent(eventContent);
				eventVO.setEventImage(eventImage);
				
				eventDAO.updateEvent(eventVO, deleteFile);
				
				if(deleteFile != null || eventImage != null) {
					deleteFile(eventNo, eventImage);
				}
				
				if(eventImage != null) {
					moveFile(eventNo, eventImage);
				}
				
				PrintWriter pw = response.getWriter();
				pw.print("<script>"
						+ " window.alert('글을 수정했습니다.');"
						+ " location.href='" + request.getContextPath()
						+ "/eventAdmin/readEvent.do?eventNo=" + eventNo + "';"
						+ "</script>"
						);
				return;
			} else if(action.equals("/deleteEvent.do")) {
				
				int eventNo = Integer.parseInt(request.getParameter("eventNo"));
				eventDAO.deleteEvent(eventNo);
				
				PrintWriter pw = response.getWriter();
				pw.print("<script>"
						+ " window.alert('글을 삭제했습니다.');"
						+ " location.href='"
						+ request.getContextPath() + "/eventAdmin/listEvent.do';"
						+ "</script>"
						);
				return;
				
				
			} else if(action.equals("/download.do")) {		
				
				int eventNo = Integer.parseInt(request.getParameter("eventNo"));
				String eventImage = request.getParameter("eventImage");
				System.out.println(eventNo);
				System.out.println(eventImage);
				downloadFile(response, eventNo, eventImage);
					
			} else {
				nextPage = "/admin/dist/event/eventList.jsp";
			}
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private Map<String, String> uploadFile(HttpServletRequest request) {
		
		Map<String, String> eventMap = new HashMap<String, String>();
		
		File repository = new File(realPath);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024*1024*1);
		factory.setRepository(repository);
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			
			for(int i=0; i<items.size(); i++) {
				
				DiskFileItem fileItem = (DiskFileItem)items.get(i);
				
				if(fileItem.isFormField()) {
					eventMap.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
				
				} else if(fileItem.getSize() > 0){
					eventMap.put(fileItem.getFieldName(), fileItem.getName());
					int idx = fileItem.getName().lastIndexOf("\\");
					
					if(idx == -1) {
						idx = fileItem.getName().lastIndexOf("/");
					}
					
					String eventFile = fileItem.getName().substring(idx + 1);
					String tempDirPath = realPath + "\\temp";
					File tempDir = new File(tempDirPath);
					
					if(!tempDir.exists()) {
						tempDir.mkdir();
					}
					
					File uploadFile = new File(tempDirPath + "\\" + eventFile);
					
					if(!uploadFile.exists()) {
						fileItem.write(uploadFile);
					}
				} else {
					eventMap.put(fileItem.getFieldName(), null);
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eventMap;
	}
	
	private void moveFile(int eventNo, String eventImage) {
		try {
			File srcFile = new File(realPath + "\\temp\\" + eventImage );
			File destDir = new File(realPath + "\\" + eventNo );
			Boolean createDestDir = destDir.mkdir();
			
			String filePath = realPath + "\\" + eventNo + "\\" + eventImage;
			File file = new File(filePath);
			
			if(!file.exists()) {
				FileUtils.moveFileToDirectory(srcFile, destDir, createDestDir);
			}
		} catch (Exception e) {
			System.out.println("컨트롤러에서 오류");
		}
	}
	
	private void deleteFile(int eventNo, String eventImage) {
		try {
			String filePath = realPath + "\\" + eventNo + "\\" + eventImage;
			File file = new File(filePath);
			
			if(file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void downloadFile(HttpServletResponse response, int eventNo, String eventImage){
		try {			
			String filePath = realPath + "\\" + eventNo + "\\" + eventImage;
			File file = new File(filePath);
		
			OutputStream out = response.getOutputStream();			
			
			response.setHeader("Cache-Control", "no-chche");
			response.addHeader("Cache-Control", "no-store");			
			response.setHeader("Content-disposition", "attachment; fileName=\"" + URLEncoder.encode(eventImage,"UTF-8") + "\";");
			
			FileInputStream in = new FileInputStream(file);	
			
			byte[] buffer = new byte[1024*8];
			
			while(true) {
				int count = in.read(buffer);
				
				if(count == -1) {
					break;
				}
				out.write(buffer, 0, count);;
			}
			
			in.close();
			out.close();
		} catch (Exception e) {
			System.out.println("downloadFile()메소드 내부에서 오류 : " + e.toString());
		}		
	}
	
	private String getFileType(int eventNo, String eventImage) {
		String noticeFileType = "";
		
		try {
			String filePath = realPath + "\\" + eventNo + "\\" + eventImage;
			File file = new File(filePath);
			
			String mimeType = Files.probeContentType(file.toPath());
			noticeFileType = mimeType.split("/")[0];
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeFileType;
	}
	
	private void deleteDirectory(int eventNo) {
		try {
			String realDirPath = realPath + "\\" + eventNo;
			File realDir = new File(realDirPath);
			
			if(realDir.exists()) {
				FileUtils.deleteDirectory(realDir);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
