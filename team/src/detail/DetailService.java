package detail;

public class DetailService {
	DetailDAO movieDAO = new DetailDAO();
	DetailVO vo = new DetailVO();
	
	public DetailVO movieDetail(int movieNo) {

		return movieDAO.movieDetail(movieNo);
	}

	

	

}