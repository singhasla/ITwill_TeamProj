package main;

import java.util.List;

import adminMovie.MovieVO;


public class MainService {
	MainDAO mainDAO = new MainDAO();
	MainMovieVO mainVO =new MainMovieVO();
	
	public List<MainMovieVO> latestList() {
		return mainDAO.latestList();
	}

	public List<MainMovieVO> hotList() {
		return mainDAO.hotList();
	}

	

}