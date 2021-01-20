package adminOrder;

import java.sql.Date;

public class AdminOrderVO {

	private int orderNo;
	private int userNo;
	private String userID;
	private int movieNo;
	private String movieName;
	private int orderStatus;	//결제대기 0, 결제완료 1
	private Date orderWriteDate;
	
	public AdminOrderVO(){}
	
	public AdminOrderVO(int orderNo, int userNo, 
						String userID, int movieNo, 
						String movieName, int orderStatus,
						Date orderWriteDate) {
		super();
		this.orderNo = orderNo;
		this.userNo = userNo;
		this.userID = userID;
		this.movieNo = movieNo;
		this.movieName = movieName;
		this.orderStatus = orderStatus;
		this.orderWriteDate = orderWriteDate;
	}
	
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getOrderWriteDate() {
		return orderWriteDate;
	}
	public void setOrderWriteDate(Date orderWriteDate) {
		this.orderWriteDate = orderWriteDate;
	}

	
}