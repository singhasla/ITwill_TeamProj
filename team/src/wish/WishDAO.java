package wish;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class WishDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource dataFactory;
	String sql;

	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:/comp/env/jdbc/team");

		conn = ds.getConnection();

		return conn;
	}// getconnection

	public void freeResource() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (Exception e) {
			System.out.println("freeResource 오류 :" + e.getMessage());
		}
	}// freeResource();

	public int myUserNo(String userID) { // 회원아이디로 회원번호 조회
	
		int Number = 0;

		try {
			conn = getConnection();

			sql = "SELECT userNo FROM user WHERE userID=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Number = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println("myUserNo메소드 오류:" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return Number;
	}//myUserNo
	
	public List<MovieVO> myWishList(int userNo, int start, int pageLength) { // 회원의 찜 목록 조회
		
		List<MovieVO> list = new ArrayList();

		try {
			conn = getConnection();

			sql = "SELECT m.* FROM team.wishlist w JOIN team.movie m "
					+ "ON w.movieNo = m.movieNo "
					+ "WHERE w.userNo=? "
					+ "ORDER BY wishWriteDate DESC "
					+ "LIMIT ?, ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, pageLength);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieVO vo = new MovieVO(rs.getInt("movieNo"), 
										 rs.getString("movieName"), 
										 rs.getString("movieImage"), 
										 rs.getInt("moviePrice"), 
										 rs.getDate("movieWriteDate"));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("myWishList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}// myWishList

	
	public void allDelItem(int userNo) { // 찜 목록 전체삭제

		try {
			conn = getConnection();

			sql = "DELETE FROM team.wishlist WHERE userNo=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("allDelItem메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
	}// allDelItem
	
	
	public void delSelectedItem1(int userNo, int movieNo) {// 찜 목록에서 선택한 목록 제거

		try {
			conn = getConnection();

			sql = "DELETE FROM team.wishlist WHERE userNo=? AND movieNo=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);
			pstmt.setInt(2, movieNo);

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("delSelectedItem1 메소드 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
	}// delSelectedItem1
	
	public void addItemWish(WishVO vo) { // 찜 목록에 추가
		
		try {
			conn = getConnection();

			int userNo = vo.getUserNo();
			int movieNo = vo.getMovieNo();

			//쿼리로 중복체크 후 데이터 삽입(같은 userNo에 movieNo가 중복될 수 없도록...)
			sql = "INSERT INTO team.wishlist(userNo, movieNo, wishWriteDate) "
							+ "SELECT ?,?,sysdate() FROM dual "
							+ "WHERE NOT EXISTS (SELECT * FROM team.wishlist "
														+ "WHERE userNo=? AND movieNo=?)";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);
			pstmt.setInt(2, movieNo);
			pstmt.setInt(3, userNo);
			pstmt.setInt(4, movieNo);

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("addItemWish메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
	}// addItemWish

	public int getBoardCount() {
		
		int count = 0; 
		
		try {
			conn = getConnection();
			
			sql = "select count(*) from team.wishlist";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println("getBoardCount 메서드 내부에서 오류 : " + e.getMessage());
			e.printStackTrace();
		}finally {
			freeResource();
		}
		return count;
	}


}