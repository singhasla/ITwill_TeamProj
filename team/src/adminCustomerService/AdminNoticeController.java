package adminCustomerService;

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

import customerService.NoticeDAO;
import customerService.NoticeVO;

@WebServlet("/noticeAdmin/*")
public class AdminNoticeController extends HttpServlet{

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
		
		String nextPage = "";
		realPath = request.getServletContext().getRealPath("/files/notice");
		
		request.setCharacterEncoding("UTF-8");		
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getPathInfo();
		System.out.println("action: " + action);
		
		try {
			if(action == null || action.equals("/listNotice.do")){
				Map<String, Object> noticeMap = new HashMap<String, Object>();
				List<NoticeVO> noticeList = noticeDAO.getNoticeList();
				int noticeListCount = noticeDAO.getNoticeListCount();
				noticeMap.put("noticeList", noticeList);
				noticeMap.put("noticeListCount", noticeListCount);
				
				request.setAttribute("noticeMap", noticeMap);
				
				nextPage = "/admin/dist/customerService/noticeList.jsp";
				
			} else if(action.equals("/addNotice.do")) {	
				
				nextPage = "/admin/dist/customerService/noticeAdd.jsp";
				
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
				
				PrintWriter out = response.getWriter();
				out.print("<script>"
						 + " window.alert('새글을 추가했습니다.');"
						 + " location.href='" + request.getContextPath() 
						 + "/noticeAdmin/readNotice.do?noticeNo="+ noticeNo + "';"
						 + "</script>"
						 );
				return;
				
			} else if(action.equals("/readNotice.do")) {		
				
				int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
				
				NoticeVO noticeVO = noticeDAO.getNotice(noticeNo);
				request.setAttribute("noticeVO", noticeVO);
				
				nextPage = "/admin/dist/customerService/noticeRead.jsp";
				
			} else if(action.equals("/modifyNotice.do")) {		
				
				int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
				
				Map<String, Object> noticeMap = new HashMap<String, Object>();
				NoticeVO noticeVO = noticeDAO.getNotice(noticeNo);
				noticeMap.put("noticeVO", noticeVO);
				
				List noticeCategoryList = noticeDAO.noticeCategoryList();
				noticeMap.put("noticeCategoryList", noticeCategoryList);
				
				request.setAttribute("noticeMap", noticeMap);
				
				nextPage = "/admin/dist/customerService/noticeUpdate.jsp";
				
			} else if(action.equals("/updateNotice.do")) {	
				
				Map<String, String> multipartMap = uploadFile(request);
				
				int noticeNo = Integer.parseInt(multipartMap.get("noticeNo"));
				String noticeTitle = multipartMap.get("noticeTitle");
				String noticeContent = multipartMap.get("noticeContent");
				String noticeCategory = multipartMap.get("noticeCategory");
				String noticeFile = multipartMap.get("noticeFile");
				String deleteFile = multipartMap.get("deleteFile");
				String originalFile = multipartMap.get("originalFile");
				
				noticeVO.setNoticeNo(noticeNo);
				noticeVO.setNoticeTitle(noticeTitle);
				noticeVO.setNoticeContent(noticeContent);
				noticeVO.setNoticeFile(noticeFile);
				noticeVO.setNoticeCategory(noticeCategory);
				
				noticeDAO.updateNotice(noticeVO, deleteFile);
				
				if(deleteFile != null || noticeFile != null) {
					deleteFile(noticeNo, noticeFile);
				}
				
				if(noticeFile != null) {
					moveFile(noticeNo, noticeFile);
				}
				
				PrintWriter pw = response.getWriter();
				pw.print("<script>"
						+ " window.alert('글을 수정했습니다.');"
						+ " location.href='" + request.getContextPath()
						+ "/noticeAdmin/readNotice.do?noticeNo=" + noticeNo + "';"
						+ "</script>"
						);
				return;
				
			} else if(action.equals("/deleteNotice.do")) {	
				
				int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
				noticeDAO.deleteNotice(noticeNo);
				
				PrintWriter pw = response.getWriter();
				pw.print("<script>"
						+ " window.alert('글을 삭제했습니다.');"
						+ " location.href='"
						+ request.getContextPath() + "/noticeAdmin/listNotice.do';"
						+ "</script>"
						);
				return;
				
			} else if(action.equals("/download.do")) {
				
				int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
				String noticeFile = request.getParameter("noticeFile");
				downloadFile(response, noticeNo, noticeFile);
				
			} else {
				nextPage = "/admin/dist/customerService/noticeList.jsp";
			}
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
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

	private void downloadFile(HttpServletResponse response, int noticeNo, String noticeFile){
		try {			
			String filePath = realPath + "\\" + noticeNo + "\\" + noticeFile;
			File file = new File(filePath);
		
			OutputStream out = response.getOutputStream();			
			
			response.setHeader("Cache-Control", "no-chche");
			response.addHeader("Cache-Control", "no-store");			
			response.setHeader("Content-disposition", "attachment; fileName=\"" + URLEncoder.encode(noticeFile,"UTF-8") + "\";");
			
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
