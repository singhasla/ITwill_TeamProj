package adminMovie;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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

import user.UserVO;

@WebServlet("/adminMovieServlet/*")
public class MovieController extends HttpServlet {

	MovieService movieService;
	MovieVO movieVO;
	MovieDAO movieDAO;
	String realPath;

	@Override
	public void init() throws ServletException {
		movieService = new MovieService();
		movieDAO = new MovieDAO();
		movieVO = new MovieVO();
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
		realPath = request.getServletContext().getRealPath("/files/product");
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String action = request.getPathInfo();
		System.out.println("action: " + action);

		try {

			if (action == null || action.equals("/movie.do")) { //관리자 첫화면
				List<MovieVO> list = movieService.movieList();

				if (!list.isEmpty()) {
					request.setAttribute("movieList", list);
				}

				nextPage = "/admin/dist/movie/movie.jsp";
			
			} else if (action.equals("/addMovie.do")) {	//영화 추가버튼 누를때
				
				List<CategoryVO> categoryList = movieService.categoryList();	
				request.setAttribute("categoryList", categoryList);

								
				nextPage = "/admin/dist/movie/addMovie.jsp";

			} else if (action.equals("/insertMovie.do")) { //영화 입력 다하고 등록버튼 누를때

				Map<String, String> multipartMap = uploadFile(request);
				
				String movieName = multipartMap.get("movieName");
				String movieContent = multipartMap.get("movieContent");
				String movieImage = multipartMap.get("movieImage");
				int moviePrice = Integer.parseInt(multipartMap.get("moviePrice"));
				int movieCategoryNo1 = Integer.parseInt(multipartMap.get("movieCategoryNo1"));
				int movieCategoryNo2 = Integer.parseInt(multipartMap.get("movieCategoryNo2"));
				String movieDirector = multipartMap.get("movieDirector");
				String movieLink = multipartMap.get("movieLink");
				Date movieReleaseDate = Date.valueOf(multipartMap.get("movieReleaseDate"));
				String actorName = multipartMap.get("actorName");
				String movieTime = multipartMap.get("movieTime");

				

				movieVO = new MovieVO(movieName, movieContent, movieImage, moviePrice, movieCategoryNo1,
						movieCategoryNo2, movieDirector, movieLink, movieReleaseDate, actorName, movieTime);

				movieService.insertMovie(movieVO);
				
				List<MovieVO> list = movieService.movieList();

				if (!list.isEmpty()) {
					request.setAttribute("movieList", list);
				}

				nextPage = "/admin/dist/movie/movie.jsp";

			}else if(action.equals("/modifyMovie.do")){
				
				int movieNo = Integer.parseInt(request.getParameter("movieNo"));
				MovieVO movieVO = movieService.readMovie(movieNo);
				request.setAttribute("movieNo", movieNo);
				request.setAttribute("movieVO", movieVO);

				List<CategoryVO> categoryList = movieService.categoryList();	
				request.setAttribute("categoryList", categoryList);
				
				nextPage = "/admin/dist/movie/modifyMovie.jsp";
				
			}else if(action.equals("/updateMovie.do")){
				Map<String, String> multipartMap = uploadFile(request);
				
				String movieName = multipartMap.get("movieName");
				String movieContent = multipartMap.get("movieContent");
				String movieImage = multipartMap.get("movieImage");
				int moviePrice = Integer.parseInt(multipartMap.get("moviePrice"));
				int movieCategoryNo1 = Integer.parseInt(multipartMap.get("movieCategoryNo1"));
				int movieCategoryNo2 = Integer.parseInt(multipartMap.get("movieCategoryNo2"));
				String movieDirector = multipartMap.get("movieDirector");
				String movieLink = multipartMap.get("movieLink");
				Date movieReleaseDate = Date.valueOf(multipartMap.get("movieReleaseDate"));
				String actorName = multipartMap.get("actorName");
				String movieTime = multipartMap.get("movieTime");
				int movieNo = Integer.parseInt(multipartMap.get("movieNo"));

			}else if(action.equals("/modifyMovie.do")){
				
				int movieNo = Integer.parseInt(request.getParameter("movieNo"));
				MovieVO movieVO = movieService.readMovie(movieNo);
				request.setAttribute("movieNo", movieNo);
				request.setAttribute("movieVO", movieVO);
				
				
				
				List<CategoryVO> categoryList = movieService.categoryList();	
				request.setAttribute("categoryList", categoryList);
				
				nextPage = "/admin/dist/movie/modifyMovie.jsp";
				
			}else if(action.equals("/updateMovie.do")){ //영화 수정
				Map<String, String> multipartMap = uploadFile(request);
				
				String movieName = multipartMap.get("movieName");
				String movieContent = multipartMap.get("movieContent");
				String movieImage = multipartMap.get("movieImage");
				int moviePrice = Integer.parseInt(multipartMap.get("moviePrice"));
				int movieCategoryNo1 = Integer.parseInt(multipartMap.get("movieCategoryNo1"));
				int movieCategoryNo2 = Integer.parseInt(multipartMap.get("movieCategoryNo2"));
				String movieDirector = multipartMap.get("movieDirector");
				String movieLink = multipartMap.get("movieLink");
				Date movieReleaseDate = Date.valueOf(multipartMap.get("movieReleaseDate"));
				String actorName = multipartMap.get("actorName");
				String movieTime = multipartMap.get("movieTime");
				int movieNo = Integer.parseInt(multipartMap.get("movieNo"));


				movieVO = new MovieVO(movieName, movieContent, movieImage, moviePrice, movieCategoryNo1,
						movieCategoryNo2, movieDirector, movieLink, movieReleaseDate, actorName, movieTime, movieNo);

				movieService.updateMovie(movieVO);
				
				
				nextPage="/adminMovieServlet/movie.do";
				/*
				List<MovieVO> list = movieService.movieList();
				if (!list.isEmpty()) {
					request.setAttribute("movieList", list);
				}
				

				nextPage = "/admin/dist/movie/movie.jsp";
				 */

			}else if(action.equals("/deleteMovie.do")){//영화 삭제
				int movieNo = Integer.parseInt(request.getParameter("movieNo"));
				
				movieService.deleteMovie(movieNo);
				
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + " alert('삭제완료');" 
						+ " location.href='" + request.getContextPath()
						+ "/adminMovieServlet/movie.do';" + "</script>");
				return;

			}

			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private Map<String, String> uploadFile(HttpServletRequest request){
		Map<String, String> productMap = null;
					
		try {
			productMap = new HashMap<String, String>();
			
			File repository = new File(realPath);
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024*1024*1);
			factory.setRepository(repository);
			ServletFileUpload upload = new ServletFileUpload(factory);
		
			List<FileItem> items = upload.parseRequest(request);
			
			for(int i=0; i<items.size(); i++) {
				DiskFileItem fileItem = (DiskFileItem)items.get(i);
				
				if(fileItem.isFormField()) {
					productMap.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
				}else {
					
					if(fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						
						if(idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						
						int fieldLength = fileItem.getFieldName().length();						
						String fieldNum = fileItem.getFieldName().substring(fieldLength-1,fieldLength);					
						
						String fileName = fieldNum + "_" + fileItem.getName().substring(idx + 1);
						String tempDirPath = realPath + "\\temp";
						File tempDir = new File(tempDirPath);
						
						if(!tempDir.exists()) {
							tempDir.mkdir();
						}
						
						String filePath = tempDirPath + "\\" + fileName;
						File file = new File(filePath);
						
						productMap.put(fileItem.getFieldName(), fileName);
						
						if(!file.exists()) {
							fileItem.write(file);
						}
						
					}else {
						productMap.put(fileItem.getFieldName(), null);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("uploadFile()메소드 오류 : " + e.toString());
		}
		
		return productMap;
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
