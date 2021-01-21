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
	
	

	
	
	
	public List<AdminOrderVO> orderList() {

		List<AdminOrderVO> list = new ArrayList();

		try {
			conn = getConnection();

			sql = "SELECT o.orderNo, o.userNo, u.userID, "
					+ "o.movieNo, m.movieName, m.moviePrice, "
					+ "o.orderStatus, o.orderWriteDate "
					+ "FROM team.order o "
					+ "LEFT JOIN team.user u "
					+ "ON o.userNo = u.userNo "
					+ "LEFT JOIN team.movie m "
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
													rs.getInt("moviePrice"),
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

	public int periodSales(Date start, Date end) {
		
		int sales=0;
		
		try {
			conn = getConnection();

			sql = "SELECT sum(moviePrice) AS total FROM team.order o JOIN team.movie m "
					+ "ON o.movieNo = m.movieNo "
					+ "WHERE o.orderStatus=1 "
					+ "AND o.orderWriteDate BETWEEN STR_TO_DATE(?,'%Y-%m-%d') "
									+ "AND DATE_ADD(STR_TO_DATE(?,'%Y-%m-%d'), INTERVAL 1 DAY) ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setDate(1, start);
			pstmt.setDate(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				sales = rs.getInt("total");
			}

		} catch (Exception e) {
			System.out.println("periodSales 메소드 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return sales;
	}//periodSales

	public int totalSales() {
		
		int totalSales=0;
		
		try {
			conn = getConnection();

			sql = "SELECT sum(moviePrice) AS total FROM team.order o JOIN team.movie m "
					+ "ON o.movieNo = m.movieNo "
					+ "WHERE o.orderStatus=1";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			if(rs.next()){
				totalSales = rs.getInt("total");
			}

		} catch (Exception e) {
			System.out.println("periodSales 메소드 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		
		return totalSales;
	}
	
	public List<AdminOrderVO> periodList(Date start, Date end) {
		
		List<AdminOrderVO> list = new ArrayList();

		try {
			conn = getConnection();

			sql = "SELECT o.orderNo, o.userNo, u.userID, o.movieNo, "
					+ "m.movieName, m.moviePrice, o.orderStatus, o.orderWriteDate "
					+ "FROM team.order o "
					+ "JOIN team.movie m ON o.movieNo = m.movieNo "
					+ "JOIN team.user u ON o.userNo = u.userNo "
					+ "WHERE o.orderStatus=1 "
					+ "AND o.orderWriteDate BETWEEN STR_TO_DATE(?,'%Y-%m-%d') "
									+ "AND DATE_ADD(STR_TO_DATE(?,'%Y-%m-%d'), INTERVAL 1 DAY) "
					+ "ORDER BY o.orderWriteDate DESC";

			pstmt = conn.prepareStatement(sql);

			pstmt.setDate(1, start);
			pstmt.setDate(2, end);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				AdminOrderVO vo = new AdminOrderVO(	rs.getInt("orderNo"),
													rs.getInt("userNo"),
													rs.getString("userID"),
													rs.getInt("movieNo"),
													rs.getString("movieName"), 
													rs.getInt("moviePrice"),
													rs.getInt("orderStatus"),
													rs.getTimestamp("orderWriteDate"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("periodList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		
		return list;
		
	}//periodList
		
}