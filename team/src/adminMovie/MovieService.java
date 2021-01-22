package adminMovie;

import java.util.List;


public class MovieService {
	MovieDAO movieDAO = new MovieDAO();
	CategoryVO categoryVO = new CategoryVO();
	MovieVO vo = new MovieVO();
	
	
	public List<MovieVO> movieList() {

		return movieDAO.movieList();
	}

	public void insertMovie(MovieVO vo) {
		movieDAO.insertMoive(vo);

	}

	public List<CategoryVO> categoryList() {
		
		return movieDAO.categoryList();
	}

	

	

}