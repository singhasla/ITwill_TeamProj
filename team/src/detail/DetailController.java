package detail;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import category.CtgrMovieVO;


@WebServlet("/detailServlet/*")
public class DetailController extends HttpServlet {

	DetailService detailService;
	DetailDAO detailDAO;
	DetailVO detailVO;

	@Override
	public void init() throws ServletException {
		detailService = new DetailService();
		detailDAO = new DetailDAO();
		detailVO = new DetailVO();
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

			if (action == null || action.equals("/detail.do")) { //상세보기 페이지 첫화면

				int movieNo = Integer.parseInt(request.getParameter("movieNo"));
				
				DetailVO vo = detailService.movieDetail(movieNo);
				int star = (int)vo.getMovieAvgRating();
				double AvgRating = detailDAO.avgRating(movieNo);
				List<CMTVO> list = detailService.cmtList(movieNo);
				
				
				request.setAttribute("DetailVO", vo);
				request.setAttribute("star", star);
				request.setAttribute("star2", AvgRating);
				request.setAttribute("cmtList", list);
				nextPage = "/detail/movie-detail.jsp";
			
			} else if (action.equals("/watching.do")) {	
				
				int movieNo = Integer.parseInt(request.getParameter("movieNo"));
				DetailVO vo = detailService.movieDetail(movieNo);
				int star = (int)vo.getMovieAvgRating();

				request.setAttribute("DetailVO", vo);
				request.setAttribute("star", star);
				nextPage = "/detail/movie-watching.jsp";

			} else if (action.equals("/search.do")) {	//텍스트로 검색한 결과영화번호 리스트
				
				String text = request.getParameter("search");
				
				List<CtgrMovieVO> search = detailService.searchMovie(text);
				
				
				request.setAttribute("searchList", search);
				
				nextPage = "/search/search.jsp";

			} else if (action.equals("/addcmt.do")) {	// 코멘트(한줄평) 등록
				
				int userNo = Integer.parseInt((String)session.getAttribute("userNo"));
				int movieNo = Integer.parseInt(request.getParameter("movieNo"));
				String commentContent = request.getParameter("comment");
				int rating = Integer.parseInt(request.getParameter("rating"));
				
				CMTVO vo = new CMTVO(userNo, movieNo, commentContent, rating);
				detailService.addCmt(vo);
				
				nextPage = "/detailServlet/detail.do";

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
