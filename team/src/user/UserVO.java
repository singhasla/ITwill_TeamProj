package user;

import java.sql.Timestamp;

public class UserVO {
	private String userID;
	private String userPW; 
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

	

	public UserVO(String userID, String userPW, String userName, String userNickname, String userTel, String userEmail,
			String userAddr1, String userAddr2, String userAddr3, String userAddr4) {
		this.userID = userID;
		this.userPW = userPW;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.userAddr1 = userAddr1;
		this.userAddr2 = userAddr2;
		this.userAddr3 = userAddr3;
		this.userAddr4 = userAddr4;
	}



	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getUserPW() {
		return userPW;
	}


	public void setUserPW(String userPW) {
		this.userPW = userPW;
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
