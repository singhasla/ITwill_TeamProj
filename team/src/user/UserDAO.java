package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
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
	
	
	public  int idCheck(String userId) {
		int check = 0;
		
		try {
			conn = getConnection();
			String sql ="select userID from user where userID =?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				check=1; //중복
			}else{
				check =0;
			}
			
			
		} catch (Exception e) {
			System.out.println("idCheck메소드  오류: " + e);
		}finally {
			discon();
		}
		
		
		return check;
	}

	public void signup(UserVO userVO) {
		
		
		try {
			conn = getConnection();
			String sql ="insert into user(userID,userPW,userName,userNickname,userTel,userEmail,userAddr1,userAddr2,userAddr3,userAddr4,userWriteDate)"
					+" values(?,?,?,?,?,?,?,?,?,?,now())";
			
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, userVO.getUserID());
			pstmt.setString(2, userVO.getUserPW());
			pstmt.setString(3, userVO.getUserName());
			pstmt.setString(4, userVO.getUserNickname());
			pstmt.setString(5, userVO.getUserTel());
			pstmt.setString(6, userVO.getUserEmail());
			pstmt.setString(7, userVO.getUserAddr1());
			pstmt.setString(8, userVO.getUserAddr2());
			pstmt.setString(9, userVO.getUserAddr3());
			pstmt.setString(10, userVO.getUserAddr4());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("signup  SQL실행 오류 : " + e);
		}finally {
			discon();
		}
		
	}//회원가입 메소드 

	public int login(String userID, String userPW) {
		int check = 0;
		
		try {
			conn = getConnection();
			String query = "select * from user where userID=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(userPW.equals(rs.getString("userPW"))){
					check=1;//로그인가능
				}else{
					check=2;//비밀번호 틀림
				}
			}else{
				check =0;//아이디 없음
			}

		} catch (Exception e) {
			System.out.println("login SQL  오류: " + e);
		}finally {
			discon();
		}
		
		return check;
	}//로그인

	public int nickCheck(String userNickname) {
		int check = 0;
		try {
			conn = getConnection();
			String sql ="select userNickname from user where userNickname =?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, userNickname);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				check=1; //중복
			}else{
				check =0;
			}
			
			
		} catch (Exception e) {
			System.out.println("nickCheck메소드  오류: " + e);
		}finally {
			discon();
		}
		
		return check;
	}

	public int telCheck(String userTel) {
		int check = 0;
		try {
			conn = getConnection();
			String sql ="select userTel from user where userTel =?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, userTel);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				check=1; //중복
			}else{
				check =0;
			}
			
			
		} catch (Exception e) {
			System.out.println("telCheck메소드  오류: " + e);
		}finally {
			discon();
		}
		
		return check;
	}

	public int mailCheck(String userEmail) {
		int check = 0;
		try {
			conn = getConnection();
			String sql ="select userEmail from user where userEmail =?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				check=1; //중복
			}else{
				check =0;
			}

		} catch (Exception e) {
			System.out.println("emailCheck 메소드  오류: " + e);
		}finally {
			discon();
		}
		
		return check;
	}

	public String idFind(String userName, String userEmail) {
		String userID ="";
		
		try {
			conn = getConnection();
			String sql ="select userID from user where userName =? and userEmail =?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userEmail);
			rs = pstmt.executeQuery();
			if(rs.next()){
				userID = rs.getString("userID");
			}
			
		} catch (Exception e) {
			System.out.println("idfind 메소드 실행중 오류 " + e);
		}finally {
			discon();
		}

		return userID;
	}

	public String findPW(String userID, String userEmail) {
		String userPW = "";
		try {
			conn = getConnection();
			String sql = "select userPW from user where userID=? and userEmail=?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, userEmail);
			rs = pstmt.executeQuery();
			if(rs.next()){
				userPW = rs.getString("userPW");
			}
			
		} catch (Exception e) {
			System.out.println("findPW 메소드 실행중 오류"+e);
		}finally {
			discon();
		}
		return userPW;
	}

	
	
	

}
