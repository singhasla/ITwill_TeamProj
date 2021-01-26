package category;

import java.util.List;

import adminMovie.MovieVO;


public class CtgrService {
	CtgrDAO ctrgDAO = new CtgrDAO();
	CtgrMovieVO ctrgVO =new CtgrMovieVO();
	
	public List<CtgrMovieVO> romanceList() {
		return ctrgDAO.romanceList();
	}

	public List<CtgrMovieVO> adventureList() {
		return ctrgDAO.adventureList();
	}

	public List<CtgrMovieVO> comedyList() {
		return ctrgDAO.comedyList();
	}

	public List<CtgrMovieVO> dramaList() {
		return ctrgDAO.dramaList();
	}

	public List<CtgrMovieVO> thrillerList() {
		return ctrgDAO.thrillerList();
	}

	public List<CtgrMovieVO> phantasyList() {
		return ctrgDAO.phantasyList();
	}

	public List<CtgrMovieVO> animationList() {
		return ctrgDAO.animationList();
	}

	public List<CtgrMovieVO> documentaryList() {
		return ctrgDAO.documentaryList();
	}

	public List<CtgrMovieVO> crimeList() {
		return ctrgDAO.crimeList();
	}

	public List<CtgrMovieVO> latestAllList() {
		return ctrgDAO.latestAllList();
	}

	public List<CtgrMovieVO> hotAllList() {
		return ctrgDAO.hotAllList();
	}
	

}