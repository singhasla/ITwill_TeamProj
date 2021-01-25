package detail;

import java.util.List;

import category.CtgrMovieVO;

public class DetailService {
	DetailDAO movieDAO = new DetailDAO();
	DetailVO vo = new DetailVO();
	
	public DetailVO movieDetail(int movieNo) {

		return movieDAO.movieDetail(movieNo);
	}

	public List<CtgrMovieVO> searchMovie(String text) {
		return movieDAO.searchMovie(text);
	}

	

	

}