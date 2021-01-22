package adminMovie;

public class CategoryVO {

	private int movieCategoryNo;
	private String movieCategoryName;

	public CategoryVO() {
	}

	public CategoryVO(int movieCategoryNo, String movieCategoryName) {
		super();
		this.movieCategoryNo = movieCategoryNo;
		this.movieCategoryName = movieCategoryName;
	}

	public int getMovieCategoryNo() {
		return movieCategoryNo;
	}

	public void setMovieCategoryNo(int movieCategoryNo) {
		this.movieCategoryNo = movieCategoryNo;
	}

	public String getMovieCategoryName() {
		return movieCategoryName;
	}

	public void setMovieCategoryName(String movieCategoryName) {
		this.movieCategoryName = movieCategoryName;
	}

}