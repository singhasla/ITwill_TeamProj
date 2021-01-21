package adminOrder;

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

import order.MovieVO;
import order.OrderVO;

public class AdminOrderDAO {
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

	
	public void allDelItem(int userNo) { // 목록 전체삭제

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


	
	
	public List<AdminOrderVO> orderList() {

		List<AdminOrderVO> list = new ArrayList();

		try {
			conn = getConnection();

			sql = "SELECT o.orderNo, o.userNo, u.userID, "
					+ "o.movieNo, m.movieName, "
					+ "o.orderStatus, o.orderWriteDate "
					+ "FROM team.order o "
					+ "left JOIN team.user u "
					+ "ON o.userNo = u.userNo "
					+ "left JOIN team.movie m "
					+ "ON o.movieNo = m.movieNo "
					+ "ORDER BY o.orderWriteDate ";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				AdminOrderVO vo = new AdminOrderVO(	rs.getInt("orderNo"),
													rs.getInt("userNo"),
													rs.getString("userID"),
													rs.getInt("movieNo"),
													rs.getString("movieName"), 
													rs.getInt("orderStatus"),
													rs.getTimestamp("orderWriteDate"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("orderList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}//orderList

	public void delSelectedItem(int orderNo) {
		try {
			conn = getConnection();

			sql = "DELETE FROM team.order WHERE orderNo=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, orderNo);

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("delSelectedItem 메소드 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
	}// delSelectedItem
		
}