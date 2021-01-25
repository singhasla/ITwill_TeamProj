package category;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ctgrServlet/*")
public class CtgrController extends HttpServlet {

	CtgrService ctgrService;
	CtgrDAO ctgrDAO;
	CtgrMovieVO ctgrVO;
	
	@Override
	public void init() throws ServletException {
		ctgrService = new CtgrService();
		ctgrDAO = new CtgrDAO();
		ctgrVO = new CtgrMovieVO();
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

			if (action.equals("/romance.do")) { //1. 로맨스

				List<CtgrMovieVO> romancelist = ctgrService.romanceList();
				
				request.setAttribute("ctgrList", romancelist);
				
				nextPage = "/category/categories1.jsp";
			
			}else if (action.equals("/adventure.do")) { //2. 액션/모험

				List<CtgrMovieVO> adventurelist = ctgrService.adventureList();
				
				request.setAttribute("ctgrList", adventurelist);
				
				nextPage = "/category/categories2.jsp";
			
			} else if (action.equals("/comedy.do")) { //3. 코미디

				List<CtgrMovieVO> comedylist = ctgrService.comedyList();
				
				request.setAttribute("ctgrList", comedylist);
				
				nextPage = "/category/categories3.jsp";
			
			} else if (action.equals("/drama.do")) { //4. 드라마

				List<CtgrMovieVO> dramalist = ctgrService.dramaList();
				
				request.setAttribute("ctgrList", dramalist);
				
				nextPage = "/category/categories4.jsp";
			
			} else if (action.equals("/thriller.do")) { //5. 공포/스릴러

				List<CtgrMovieVO> thrillerlist = ctgrService.thrillerList();
				
				request.setAttribute("ctgrList", thrillerlist);
				
				nextPage = "/category/categories5.jsp";
			
			} else if (action.equals("/phantasy.do")) { //6. SF/판타지

				List<CtgrMovieVO> phantasylist = ctgrService.phantasyList();
				
				request.setAttribute("ctgrList", phantasylist);
				
				nextPage = "/category/categories6.jsp";
			
			} else if (action.equals("/animation.do")) { //7. 애니메이션

				List<CtgrMovieVO> animationlist = ctgrService.animationList();
				
				request.setAttribute("ctgrList", animationlist);
				
				nextPage = "/category/categories7.jsp";
			
			} else if (action.equals("/documentary.do")) { //8. 다큐멘터리

				List<CtgrMovieVO> documentarylist = ctgrService.documentaryList();
				
				request.setAttribute("ctgrList", documentarylist);
				
				nextPage = "/category/categories8.jsp";
			
			} else if (action.equals("/crime.do")) { //9. 범죄

				List<CtgrMovieVO> crimelist = ctgrService.crimeList();
				
				request.setAttribute("ctgrList", crimelist);
				
				nextPage = "/category/categories9.jsp";
			
			}

			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
