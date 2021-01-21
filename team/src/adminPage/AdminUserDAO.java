package adminPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.UserVO;

public class AdminUserDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource dataFactory;
	
	private Connection  getConnection() throws Exception{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:/comp/env/jdbc/team");

		conn =ds.getConnection();
		
		return conn;
	}//getconnection 
	
	public void discon(){
		try {
			if(pstmt !=null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("자원해제중 오류 "+e);
		}

	}

	public  List<UserVO> getUserList(String searchKeyword) {
		String sql ="";
		List<UserVO> userList = new ArrayList();
		try {
			conn = getConnection();
			if(searchKeyword==null||searchKeyword.isEmpty()==true){
				 sql ="select * from user ";
			}else{
				//검색했을때
				/*sql="select * from user where userName like '%"+searchKeyword+"%'";*/
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				UserVO userVO= new UserVO();
				userVO.setUserID(rs.getString("userID"));
				userVO.setUserPW(rs.getString("userPW"));
				userVO.setUserName(rs.getString("userName"));
				userVO.setUserNickname(rs.getString("userNickname"));
				userVO.setUserTel(rs.getString("userTel"));
				userVO.setUserEmail(rs.getString("userEmail"));
				userVO.setUserAddr1(rs.getString("userAddr1"));
				userVO.setUserAddr2(rs.getString("userAddr2"));
				userVO.setUserAddr3(rs.getString("userAddr3"));
				userVO.setUserAddr4(rs.getString("userAddr4"));
				userVO.setUserUpdate(rs.getTimestamp("userUpdate"));
				userVO.setUserWriteDate(rs.getTimestamp("userWriteDate"));
				
				userList.add(userVO);
			}
			
		} catch (Exception e) {
			System.out.println( "getlist실행중 오류"+ e);
		}finally {
			discon();
		}
		
		return userList;
	}

	public int getUserListCount(String searchKeyword) {
		String sql ="";
		int total =0;
		
		try {
			conn = getConnection();
			if(searchKeyword==null||searchKeyword.isEmpty()==true){
				sql ="select count(userID) from user ";
			}else{
				sql ="select count(*) from user where userID like '%a"+searchKeyword+"%'";
				 
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				total = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println("getUserListCount 실행중 "+ e);
		}finally {
			discon();
		}
		
		return total;
	}

	public UserVO getUser(String userID) {
		UserVO userVO= new UserVO();
		try {
			conn = getConnection();
			String sql = "select * from user where userID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				userVO.setUserID(rs.getString("userID"));
				userVO.setUserPW(rs.getString("userPW"));
				userVO.setUserName(rs.getString("userName"));
				userVO.setUserNickname(rs.getString("userNickname"));
				userVO.setUserTel(rs.getString("userTel"));
				userVO.setUserEmail(rs.getString("userEmail"));
				userVO.setUserAddr2(rs.getString("userAddr2"));
				userVO.setUserAddr3(rs.getString("userAddr3"));
				userVO.setUserAddr4(rs.getString("userAddr4"));
				userVO.setUserWriteDate(rs.getTimestamp("userWriteDate"));
				userVO.setUserUpdate(rs.getTimestamp("userUpdate"));
			}
			
		} catch (Exception e) {
			System.out.println("getUser 메소드 내부 오류 "+e);
		}finally {
			discon();
		}
		return userVO;
	}

	public int userUpdate(UserVO userVO) {
		int result =0;
		try {
			conn = getConnection();
			String sql = "update user set userNickname= ?, userTel= ?, userAddr1=?,userAddr2=?,userAddr3=?,userAddr4=? , userUpdate = now() where userID =? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userVO.getUserNickname());
			pstmt.setString(2, userVO.getUserTel());
			pstmt.setString(3, userVO.getUserAddr1());
			pstmt.setString(4, userVO.getUserAddr2());
			pstmt.setString(5, userVO.getUserAddr3());
			pstmt.setString(6, userVO.getUserAddr4());
			pstmt.setString(7, userVO.getUserID());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("userUpdate 메소드 내부 오류 "+e);
		}finally {
			discon();
		}
		return result ;
	}

}
