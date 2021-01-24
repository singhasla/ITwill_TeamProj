package main;

import java.sql.Date;

public class MainMovieVO {

	private int movieNo;
	private String movieName;
	private String movieContent;
	private String movieImage;
	private int moviePrice;
	private int movieCategoryNo1;
	private String cn1;
	private int movieCategoryNo2;
	private String cn2;
	private String movieDirector;
	private String actorName;
	private String movieTime;
	private String movieLink;
	private Date movieReleaseDate;
	private Date movieWriteDate;
	private Date movieUpdateDate;

	public MainMovieVO() {
	}

	/*메인페이지에 쓸 목록가져올 VO*/
	public MainMovieVO(int movieNo, String movieName, String movieImage, int movieCategoryNo1, String cn1, int movieCategoryNo2, String cn2,
			String movieTime) {
		super();
		this.movieNo = movieNo;
		this.movieName = movieName;
		this.movieImage = movieImage;
		this.movieCategoryNo1 = movieCategoryNo1;
		this.cn1 = cn1;
		this.movieCategoryNo2 = movieCategoryNo2;
		this.cn2 = cn2;
		this.movieTime = movieTime;
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

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
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

	public Date getMovieUpdateDate() {
		return movieUpdateDate;
	}

	public void setMovieUpdateDate(Date movieUpdateDate) {
		this.movieUpdateDate = movieUpdateDate;
	}

	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(Date movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
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

	public String getCn1() {
		return cn1;
	}

	public void setCn1(String cn1) {
		this.cn1 = cn1;
	}

	public String getCn2() {
		return cn2;
	}

	public void setCn2(String cn2) {
		this.cn2 = cn2;
	}

	

}