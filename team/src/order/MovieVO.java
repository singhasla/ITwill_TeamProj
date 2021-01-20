package order;

import java.sql.Date;

public class MovieVO {

	private int movieNo;
	private String movieName;
	private String movieContent;
	private String movieImage;
	private int moviePrice;
	private int movieCategoryNo1;
	private int movieCategoryNo2;
	private int movieAvgRating;
	private String movieLink;
	private Date movieWriteDate;
	private Date cartUpdateDate;
	
	public MovieVO(){}
	
	public MovieVO(int movieNo, String movieName, String movieContent, String movieImage, int moviePrice,
			int movieCategoryNo1, int movieCategoryNo2, int movieAvgRating, String movieLink, Date movieWriteDate, Date cartUpdateDate) {
		super();
		this.movieNo = movieNo;
		this.movieName = movieName;
		this.movieContent = movieContent;
		this.movieImage = movieImage;
		this.moviePrice = moviePrice;
		this.movieCategoryNo1 = movieCategoryNo1;
		this.movieCategoryNo2 = movieCategoryNo2;
		this.movieAvgRating = movieAvgRating;
		this.movieLink = movieLink;
		this.movieWriteDate = movieWriteDate;
		this.cartUpdateDate = cartUpdateDate;
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
	public String getMovieContent() {
		return movieContent;
	}
	public void setMovieContent(String movieContent) {
		this.movieContent = movieContent;
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
	public int getMovieCategoryNo1() {
		return movieCategoryNo1;
	}
	public void setMovieCategoryNo1(int movieCategoryNo1) {
		this.movieCategoryNo1 = movieCategoryNo1;
	}
	public int getMovieCategoryNo2() {
		return movieCategoryNo2;
	}
	public void setMovieCategoryNo2(int movieCategoryNo2) {
		this.movieCategoryNo2 = movieCategoryNo2;
	}
	public int getMovieAvgRating() {
		return movieAvgRating;
	}
	public void setMovieAvgRating(int movieAvgRating) {
		this.movieAvgRating = movieAvgRating;
	}
	public String getMovieLink() {
		return movieLink;
	}
	public void setMovieLink(String movieLink) {
		this.movieLink = movieLink;
	}
	public Date getMovieWriteDate() {
		return movieWriteDate;
	}
	public void setMovieWriteDate(Date movieWriteDate) {
		this.movieWriteDate = movieWriteDate;
	}
	public Date getCartUpdateDate() {
		return cartUpdateDate;
	}
	public void setCartUpdateDate(Date cartUpdateDate) {
		this.cartUpdateDate = cartUpdateDate;
	}
	
	
}