package user;

import java.sql.Timestamp;

public class UserVO {
	private String userId;
	private String userPw; 
	private String userName;
	private String userNickname; 
	private String userTel; 
	private String userEmail; 
	private String userAddr1; 
	private String userAddr2; 
	private Timestamp userWriteDate;
	private Timestamp userUpdateDate;
	private String userAddr3; 
	private String userAddr4; 
	
	public UserVO() {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddr1() {
		return userAddr1;
	}

	public void setUserAddr1(String userAddr1) {
		this.userAddr1 = userAddr1;
	}

	public String getUserAddr2() {
		return userAddr2;
	}

	public void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}

	public Timestamp getUserWriteDate() {
		return userWriteDate;
	}

	public void setUserWriteDate(Timestamp userWriteDate) {
		this.userWriteDate = userWriteDate;
	}

	public Timestamp getUserUpdateDate() {
		return userUpdateDate;
	}

	public void setUserUpdateDate(Timestamp userUpdateDate) {
		this.userUpdateDate = userUpdateDate;
	}

	public String getUserAddr3() {
		return userAddr3;
	}

	public void setUserAddr3(String userAddr3) {
		this.userAddr3 = userAddr3;
	}

	public String getUserAddr4() {
		return userAddr4;
	}

	public void setUserAddr4(String userAddr4) {
		this.userAddr4 = userAddr4;
	}
	
	
	
	
}
