package customerService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.file.Files;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import sun.print.PrinterJobWrapper;

@WebServlet("/notice/*")
public class NoticeController extends HttpServlet {
	
	NoticeDAO noticeDAO;
	NoticeVO noticeVO;
	String realPath;
	
	@Override
	public void init() throws ServletException {
		noticeDAO = new NoticeDAO();
		noticeVO = new NoticeVO();
		
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
	
		realPath = request.getServletContext().getRealPath("/files/notice");
		
		String nextPage = "";
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String action = request.getPathInfo();
		System.out.println("action: " + action);
		
		try {
			if(action == null || action.equals("/listNotice.do")) {
				
				setPagination(request);
				
				Map<String, Object> searchMap = new HashMap<String, Object>();
				searchMap.put("pageNo", request.getAttribute("pageNo"));
				searchMap.put("section", request.getAttribute("section"));
				searchMap.put("search", request.getAttribute("search"));
				
//				String _search = request.getParameter("search");			
//				String _section = request.getParameter("section");
//				String _pageNo = request.getParameter("pageNo");			
//				
//				int section = Integer.parseInt(((_section == null) ? "1" : _section));
//				int pageNo = Integer.parseInt(((_pageNo == null) ? "1" : _pageNo));
//				String search = (_search == null) ? "" : _search;
//				
//				Map<String, Object> searchMap = new HashMap<String, Object>();
//				searchMap.put("pageNo", pageNo);
//				searchMap.put("search", search);
//				searchMap.put("section", section);
				
				Map<String, Object> noticeMap = new HashMap<String, Object>();
				searchMap.put("pageNo", request.getAttribute("pageNo"));
				searchMap.put("section", request.getAttribute("section"));
				searchMap.put("search", request.getAttribute("search"));
				
				List<NoticeVO> noticeList = noticeDAO.getNoticeList(searchMap);
				int noticeListCount = noticeDAO.getNoticeListCount(searchMap);
				noticeMap.put("noticeList", noticeList);
				noticeMap.put("noticeListCount", noticeListCount);
				
				request.setAttribute("noticeMap", noticeMap);
				nextPage = "/customerService/notice.jsp";
			
			} else if(action.equals("/addNotice.do")) {	
				
				nextPage = "/customerService/noticeForm.jsp";
			
			} else if(action.equals("/insertNotice.do")) {
				
				Map<String, String> multipartMap = uploadFile(request);
				String noticeTitle = multipartMap.get("noticeTitle");
				String noticeContent = multipartMap.get("noticeContent");
				String noticeFile = multipartMap.get("noticeFile");
				String noticeCategory = multipartMap.get("noticeCategory");
	
				noticeVO.setNoticeTitle(noticeTitle);
				noticeVO.setNoticeContent(noticeContent);
				noticeVO.setNoticeFile(noticeFile);
				noticeVO.setNoticeCategory(noticeCategory);
				
				int noticeNo = noticeDAO.insertNotice(noticeVO);
				
				if(noticeFile != null && noticeFile.length() != 0) {
					moveFile(noticeNo, noticeFile);
				}
				
				nextPage = "/notice/viewNotice.do?noticeNo=" + noticeNo;
			
			} else if(action.equals("/viewNotice.do")) {	
				
				setPagination(request);
				
				int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
				
				Map<String, Object> noticeMap = new HashMap<String, Object>();
				noticeDAO.increaseNoticeReadCount(noticeNo);
				
				NoticeVO noticeVO = noticeDAO.getNotice(noticeNo);
				noticeMap.put("noticeVO", noticeVO);
				request.setAttribute("noticeMap", noticeMap);
				
				nextPage = "/customerService/noticeView.jsp";
			
			} else if(action.equals("/modifyNotice.do")) {		
				
				setPagination(request);
				
				int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
				
				Map<String, Object> noticeMap = new HashMap<String, Object>();
				NoticeVO noticeVO = noticeDAO.getNotice(noticeNo);
				noticeMap.put("noticeVO", noticeVO);
				
				List noticeCategoryList = noticeDAO.noticeCategoryList();
				System.out.println(noticeCategoryList);
				noticeMap.put("noticeCategoryList", noticeCategoryList);
				
				request.setAttribute("noticeMap", noticeMap);
				
				nextPage = "/customerService/noticeUpdate.jsp";
				
			} else if(action.equals("/download.do")) {		
				
				int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
				String noticeFile = request.getParameter("noticeFile");
				
				downloadFile(response, noticeNo, noticeFile);
				
			} else {
				nextPage = "/customerService.jsp";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void setPagination(HttpServletRequest request) {
		try {
			int pageNo = 1;
			if(request.getParameter("pageNo")!=null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
			}
			if(request.getAttribute("pageNo")==null) {
				request.setAttribute("pageNo", pageNo);
			}
			
			int section = 1;
			if(request.getParameter("section")!=null) {
				section = Integer.parseInt(request.getParameter("section"));
			}
			if(request.getAttribute("section")==null) {
				request.setAttribute("section", section);
			}
			
			String search = "";
			if(request.getParameter("search")!=null) {
				search = request.getParameter("search");
			}
			if(request.getAttribute("search")==null) {
				request.setAttribute("search", search);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Map<String, String> uploadFile(HttpServletRequest request) {
		
		Map<String, String> noticeMap = new HashMap<String, String>();
		
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
					noticeMap.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
				
				} else if(fileItem.getSize() > 0){
					noticeMap.put(fileItem.getFieldName(), fileItem.getName());
					int idx = fileItem.getName().lastIndexOf("\\");
					
					if(idx == -1) {
						idx = fileItem.getName().lastIndexOf("/");
					}
					
					String noticeFile = fileItem.getName().substring(idx + 1);
					String tempDirPath = realPath + "\\temp";
					File tempDir = new File(tempDirPath);
					
					if(!tempDir.exists()) {
						tempDir.mkdir();
					}
					
					File uploadFile = new File(tempDirPath + "\\" + noticeFile);
					
					if(!uploadFile.exists()) {
						fileItem.write(uploadFile);
					}
				} else {
					noticeMap.put(fileItem.getFieldName(), null);
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeMap;
	}
	
	private void moveFile(int noticeNo, String noticeFile) {
		try {
			File srcFile = new File(realPath + "\\temp\\" + noticeFile );
			File destDir = new File(realPath + "\\" + noticeNo );
			Boolean createDestDir = destDir.mkdir();
			
			String filePath = realPath + "\\" + noticeNo + "\\" + noticeFile;
			File file = new File(filePath);
			
			if(!file.exists()) {
				FileUtils.moveFileToDirectory(srcFile, destDir, createDestDir);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void deleteFile(int noticeNo, String noticeFile) {
		try {
			String filePath = realPath + "\\" + noticeNo + "\\" + noticeFile;
			File file = new File(filePath);
			
			if(file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void downloadFile(HttpServletResponse response, int noticeNo, String noticeFile) {
		try {
			String filePath = realPath + "\\" + noticeNo + "\\" + noticeFile;
			File file = new File(filePath);
			
			OutputStream out = response.getOutputStream();
			
			response.setHeader("Cache-Cotrol", "no-chche");
			response.addHeader("Cache-Control", "no-store");
			response.setHeader("Content-disposition", "attachment; noticeFile=\"" + URLEncoder.encode(noticeFile, "UTF-8") + "\";");
			
			FileInputStream in = new FileInputStream(file);
			
			byte[] buffer = new byte[1024*8];
			
			while(true) {
				int count = in.read(buffer);
				
				if(count == -1) {
					break;
				}
				out.write(buffer, 0, count);
			}
			
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getFileType(int noticeNo, String noticeFile) {
		String noticeFileType = "";
		
		try {
			String filePath = realPath + "\\" + noticeNo + "\\" + noticeFile;
			File file = new File(filePath);
			
			String mimeType = Files.probeContentType(file.toPath());
			noticeFileType = mimeType.split("/")[0];
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeFileType;
	}
	
	private void deleteDirectory(int noticeNo) {
		try {
			String realDirPath = realPath + "\\" + noticeNo;
			File realDir = new File(realDirPath);
			
			if(realDir.exists()) {
				FileUtils.deleteDirectory(realDir);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
