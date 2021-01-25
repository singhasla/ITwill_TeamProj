package detail;

import java.sql.Date;
import java.sql.Timestamp;

public class DetailVO {

	private int movieNo;
	private String movieName;
	private String movieContent;
	private String movieImage;
	private int moviePrice;
	private int movieCategoryNo1;
	private String CN1;
	private int movieCategoryNo2;
	private String CN2;
	private double movieAvgRating;
	private String movieLink;
	private Date movieReleaseDate;
	private Timestamp movieWriteDate;
	private Timestamp movieUpdateDate;
	private String movieDirector;
	private String actorName;
	private String movieTime;

	public DetailVO() {
	}

	
	public DetailVO(int movieNo, String movieName, String movieContent, String movieImage, int moviePrice,
			int movieCategoryNo1, String CN1, int movieCategoryNo2, String CN2, double movieAvgRating, String movieLink, Date movieReleaseDate,
			Timestamp movieWriteDate, Timestamp movieUpdateDate, String movieDirector, String actorName,
			String movieTime) {
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
		this.movieReleaseDate = movieReleaseDate;
		this.movieWriteDate = movieWriteDate;
		this.movieUpdateDate = movieUpdateDate;
		this.movieDirector = movieDirector;
		this.actorName = actorName;
		this.movieTime = movieTime;
		this.CN1 = CN1;
		this.CN2 = CN2;
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

	public double getMovieAvgRating() {
		return movieAvgRating;
	}

	public void setMovieAvgRating(double movieAvgRating) {
		this.movieAvgRating = movieAvgRating;
	}

	public String getMovieLink() {
		return movieLink;
	}

	public void setMovieLink(String movieLink) {
		this.movieLink = movieLink;
	}

	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(Date movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	public Timestamp getMovieWriteDate() {
		return movieWriteDate;
	}

	public void setMovieWriteDate(Timestamp movieWriteDate) {
		this.movieWriteDate = movieWriteDate;
	}

	public Timestamp getMovieUpdateDate() {
		return movieUpdateDate;
	}

	public void setMovieUpdateDate(Timestamp movieUpdateDate) {
		this.movieUpdateDate = movieUpdateDate;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}


	public String getCN1() {
		return CN1;
	}


	public void setCN1(String cN1) {
		CN1 = cN1;
	}


	public String getCN2() {
		return CN2;
	}


	public void setCN2(String cN2) {
		CN2 = cN2;
	}


}