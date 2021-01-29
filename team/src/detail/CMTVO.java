package detail;

import java.sql.Date;

public class CMTVO {
	private int commentNo;
	private int userNo;
	private int movieNo;
	private String commentContent;
	private Date commentWriteDate;
	private int rating;
	private String userNickName;
	
	
	public CMTVO() {}

	public CMTVO(int userNo, int movieNo, String commentContent, int rating) {
		super();
		this.userNo = userNo;
		this.movieNo = movieNo;
		this.commentContent = commentContent;
		this.rating = rating;
	}
	public CMTVO(int commentNo, int userNo, int movieNo, String commentContent, Date commentWriteDate, int rating, String userNickName) {
		super();
		this.commentNo = commentNo;
		this.userNo = userNo;
		this.movieNo = movieNo;
		this.commentContent = commentContent;
		this.commentWriteDate = commentWriteDate;
		this.rating = rating;
		this.userNickName = userNickName;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentWriteDate() {
		return commentWriteDate;
	}

	public void setCommentWriteDate(Date commentWriteDate) {
		this.commentWriteDate = commentWriteDate;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

}