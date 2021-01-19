package order;

import java.sql.Date;

public class OrderVO {

	private int orderNo;
	private int userNo;
	private int movieNo;
	private int orderStatus;	//결제대기 0, 결제완료 1
	private Date orderWriteDate;
	
	public OrderVO() {}
	
	public OrderVO(int userNo, int movieNo) {

		super();
		this.userNo=userNo;
		this.movieNo=movieNo;
	}
	
	public OrderVO(int orderNo, int userNo, int movieNo, Date orderWriteDate) {

		super();
		this.orderNo=orderNo;
		this.userNo=userNo;
		this.movieNo=movieNo;
		this.orderWriteDate=orderWriteDate;
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
	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
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