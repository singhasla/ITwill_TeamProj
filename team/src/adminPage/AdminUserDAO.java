package adminPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import customerService.QnaVO;
import order.MovieVO;
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
				userVO.setUserNo(rs.getInt("userNo"));
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
				userVO.setUserNo(rs.getInt("userNo"));
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

	public int deleteUser(String userID) {
		
		try {
			conn = getConnection();
			String sql = "delete from user where userID =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete()메소드 내부에서 오류"+e);
		}finally {
			discon();
		}
		return 0;
	}

	public MovieVO getuserM(int userNo) {//개인별 영화
	
		MovieVO userM = new MovieVO();
		try {
			conn = getConnection();
			String sql ="";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				userM.setMovieName("movieName");
				userM.setMoviePrice(rs.getInt("moviePrice"));
				userM.setMovieNo(rs.getInt("movieNo"));
				userM.setMovieCategoryNo1(rs.getInt("movieCategoryNo1"));

			}
			
			
			
		} catch (Exception e) {
			System.out.println("getuserM 실행중 오류 "+e);
		}finally {
			discon();
		}
		return userM;
	}

	public List<MovieVO> getUserM(int userNo) {
		String sql ="";
		List<MovieVO> userM = new ArrayList();
		try {
			conn = getConnection();
			sql="select a.userNo, c.*  from user a, `order` b, movie c where a.userNo = b.userNo &&  b.movieNO = c.movieNO && a.userNo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			while(rs.next()){
				MovieVO movieVo = new MovieVO();
				movieVo.setMovieNo(rs.getInt("movieNo"));
				movieVo.setMovieName(rs.getString("movieName"));
				movieVo.setMoviePrice(rs.getInt("moviePrice"));
				movieVo.setMovieContent(rs.getString("movieContent")); 
				movieVo.setMovieImage(rs.getString("movieImage"));
			
				userM.add(movieVo);
			}
		
			
		} catch (Exception e) {
			System.out.println("getuserM 실행중 오류 "+e);
		}finally {
			discon();
		}
		
		return userM;
	}

	public List<QnaVO> getUserQ(int userNo) {
		String sql ="";
		List<QnaVO> userQ = new ArrayList();
		try {
			conn = getConnection();
			sql="select * from qna where userNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			while(rs.next()){
				QnaVO qnaVo = new QnaVO();
				qnaVo.setQnaTitle(rs.getString("qnaTitle"));
				qnaVo.setQnaCategory(rs.getString("qnaContent"));
				qnaVo.setQnaWriteDate(rs.getTimestamp("qnaWriteDate"));
				qnaVo.setAnswerWriteDate(rs.getTimestamp("answerWriteDate"));
				qnaVo.setAnswerTitle(rs.getString("answerTitle"));	
				qnaVo.setAnswerContent(rs.getString("answerContent"));
				userQ.add(qnaVo);
			}
			
		} catch (Exception e) {
			System.out.println("");
		}finally {
			discon();
		}
		
		return userQ;
	}



}
