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
