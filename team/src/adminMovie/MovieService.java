package adminMovie;

import java.util.List;
import java.util.Map;


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

	public MovieVO readMovie(int movieNo) {
		return movieDAO.getMovie(movieNo);
	}

	public void updateMovie(MovieVO vo) {
		movieDAO.updateMoive(vo);
		
	}

	public void deleteMovie(int movieNo) {
		movieDAO.deleteMovie(movieNo);
		
	}

	

	

}