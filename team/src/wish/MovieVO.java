package wish;

import java.sql.Date;

public class MovieVO {

	private int movieNo;
	private String movieName;
	private String movieImage;
	private int moviePrice;
	private Date movieWriteDate;
	
	public MovieVO(){}
	
	public MovieVO(int movieNo, String movieName, String movieImage, int moviePrice,
			Date movieWriteDate) {
		super();
		this.movieNo = movieNo;
		this.movieName = movieName;
		this.movieImage = movieImage;
		this.moviePrice = moviePrice;
		this.movieWriteDate = movieWriteDate;
	}



	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieImage() {
		return movieImage;
	}
	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}
	public int getMoviePrice() {
		return moviePrice;
	}
	public void setMoviePrice(int moviePrice) {
		this.moviePrice = moviePrice;
	}
	public Date getMovieWriteDate() {
		return movieWriteDate;
	}
	public void setMovieWriteDate(Date movieWriteDate) {
		this.movieWriteDate = movieWriteDate;
	}
	
}