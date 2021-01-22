package main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mainServlet/*")
public class MainController extends HttpServlet {

	MainService mainService;
	MainDAO mainDAO;
	MainMovieVO mainVO;
	
	@Override
	public void init() throws ServletException {
		mainService = new MainService();
		mainDAO = new MainDAO();
		mainVO = new MainMovieVO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "";
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String action = request.getPathInfo();
		System.out.println("action: " + action);

		try {

			if (action == null || action.equals("/main.do")) { //메인 페이지 첫화면

				List<MainMovieVO> latestlist = mainService.latestList();
				List<MainMovieVO> hotlist = mainService.hotList();
				
				request.setAttribute("latestList", latestlist);
				request.setAttribute("hotList", hotlist);
				
				nextPage = "/main/main.jsp";
			
			} else if (action.equals("")) {	
				
				nextPage = "";

			}

			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}

// private Map<String, String> uploadFile(HttpServletRequest request){
// Map<String, String> movieMap = null;
//
// try {
// movieMap = new HashMap<String, String>();
//
// File repository = new File(realPath);
// DiskFileItemFactory factory = new DiskFileItemFactory();
// factory.setSizeThreshold(1024*1024*1);
// factory.setRepository(repository);
// ServletFileUpload upload = new ServletFileUpload(factory);
//
// List<FileItem> items = upload.parseRequest(request);
//
// for(int i=0; i<items.size(); i++) {
// DiskFileItem fileItem = (DiskFileItem)items.get(i);
//
// if(fileItem.isFormField()) {
// movieMap.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
// }else {
//
// if(fileItem.getSize() > 0) {
// int idx = fileItem.getName().lastIndexOf("\\");
//
// if(idx == -1) {
// idx = fileItem.getName().lastIndexOf("/");
// }
//
// int fieldLength = fileItem.getFieldName().length();
// String fieldNum =
// fileItem.getFieldName().substring(fieldLength-1,fieldLength);
//
// String fileName = fieldNum + "_" + fileItem.getName().substring(idx + 1);
// String tempDirPath = realPath + "\\temp";
// File tempDir = new File(tempDirPath);
//
// if(!tempDir.exists()) {
// tempDir.mkdir();
// }
//
// String filePath = tempDirPath + "\\" + fileName;
// File file = new File(filePath);
//
// movieMap.put(fileItem.getFieldName(), fileName);
//
// if(!file.exists()) {
// fileItem.write(file);
// }
//
// }else {
// movieMap.put(fileItem.getFieldName(), null);
// }
// }
// }
// } catch (Exception e) {
// System.out.println("uploadFile(): " + e.toString());
// }
//
// return movieMap;
// }
