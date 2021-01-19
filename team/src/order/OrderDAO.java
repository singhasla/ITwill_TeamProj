package order;

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

public class OrderDAO {
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
	
	public List<MovieVO> myCartList(int userNo) { // 장바구니 내역 조회
		
		List<MovieVO> list = new ArrayList();

		try {
			conn = getConnection();

			sql = "SELECT m.* FROM team.order o JOIN movie m ON o.movieNo = m.movieNo"
					+ " WHERE o.userNo=? AND o.orderStatus=0 ORDER BY orderWriteDate";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieVO vo = new MovieVO(rs.getInt("movieNo"), 
										 rs.getString("movieName"), 
										 rs.getString("movieContent"),
										 rs.getString("movieImage"), 
										 rs.getInt("moviePrice"), 
										 rs.getInt("movieCategoryNo1"),
										 rs.getInt("movieCategoryNo2"),
										 rs.getInt("movieAvgRating"), 
										 rs.getString("movieLink"), 
										 rs.getDate("movieWriteDate"),
										 rs.getDate("movieUpdateDate"));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("myCartList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}// myCartList

	public List<MovieVO> myOrderList(int userNo) {	// 구매 내역 조회

		List<MovieVO> list = new ArrayList();

		try {
			conn = getConnection();

			sql = "SELECT m.* FROM team.order o JOIN movie m ON o.movieNo = m.movieNo"
					+ " WHERE o.userNo=? AND o.orderStatus=1 ORDER BY orderWriteDate";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieVO vo = new MovieVO(rs.getInt("movieNo"), 
										 rs.getString("movieName"), 
										 rs.getString("movieContent"),
										 rs.getString("movieImage"), 
										 rs.getInt("moviePrice"), 
										 rs.getInt("movieCategoryNo1"),
										 rs.getInt("movieCategoryNo2"),
										 rs.getInt("movieAvgRating"), 
										 rs.getString("movieLink"), 
										 rs.getDate("movieWriteDate"),
										 rs.getDate("movieUpdateDate"));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("myOrderList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}//myOrderList
	
	public void allDelItem(int userNo) { // 카트목록 전체삭제

		try {
			conn = getConnection();

			sql = "DELETE FROM team.order WHERE userNo=? AND orderStatus=0";

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
	
	
	public void delSelectedItem(int userNo, int movieNo) {// 카트 목록에서 선택한 목록 제거

		try {
			conn = getConnection();

			sql = "DELETE FROM team.order WHERE userNo=? AND movieNo=? AND orderStatus=0";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);
			pstmt.setInt(2, movieNo);

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("delSelectedItem 메소드 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
	}// delSelectedItem
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void addItemCart(OrderVO vo) { // 카트에 추가
		
		try {
			conn = getConnection();

			int userNo = vo.getUserNo();
			int movieNo = vo.getMovieNo();

			//쿼리로 중복체크 후 데이터 삽입(같은 userNo에 movieNo가 중복될 수 없도록...)
			sql = "INSERT INTO team.order(userNo, movieNo, orderWriteDate)"
								+ " SELECT ?,?,sysdate() FROM dual"
								+ "	WHERE NOT EXISTS (SELECT * FROM team.order"
													+ "	WHERE userNo=? AND movieNo=?)";
			
			//sql = "INSERT INTO order(userNo, movieNo, orderWriteDate)" 
			//		+ " VALUES(?,?,sysdate())";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);
			pstmt.setInt(2, movieNo);
			pstmt.setInt(3, userNo);
			pstmt.setInt(4, movieNo);

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("addItemCart메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
	}// addItemCart

	

	public int cartTotalPrice(int userNo) { // 장바구니에 담긴 상품 전체금액

		int totalPrice = 0;

		try {
			conn = getConnection();

			sql = "SELECT sum(moviePrice)" 
					+ " FROM movie m JOIN team.order o" 
					+ " ON m.movieNo = o.movieNo"
					+ " WHERE o.userNo=? AND o.orderStatus=0";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				totalPrice = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println("cartTotalPrice메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}

		return totalPrice;
	}//cartTotalPrice

	public int cartTotalCount(int userNo) { // 카트 목록 갯수
		
		int totalcount = 0;

		try {
			conn = getConnection();

			sql = "SELECT count(*) FROM team.order WHERE userNo=? AND orderStatus=0";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalcount = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println("cartTotalCount메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return totalcount;
	}//cartTotalCount

	public String firstMovieName(int userNo) {
	
		String firstMN = null;

		try {
			conn = getConnection();

			sql = "SELECT m.movieName FROM team.order o JOIN movie m ON o.movieNo = m.movieNo"
					+ " WHERE o.userNo=? AND o.orderStatus=0 ORDER BY orderWriteDate";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				firstMN = rs.getString(1);
			}

		} catch (Exception e) {
			System.out.println("firstMovieName메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return firstMN;
	}//firstMovieName

	public void updateStatus(int userNo) {	//장바구니에서 결제완료된 상품들 후처리(0:결제대기 -> 1:결제완료)

		try {
			conn = getConnection();

			sql = "UPDATE team.order SET orderStatus=1 WHERE userNo=? AND orderStatus=0";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateStatus메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
	}//paycomplt

	

}