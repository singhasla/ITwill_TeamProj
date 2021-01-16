package customerService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class NoticeDAO {

	private DataSource ds;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Connection getConnection() throws Exception {
		
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/team");
		conn = ds.getConnection();
		return conn;
	}
	
	public void closeAll() {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getNoticeListCount(Map searchMap) {
		
		String search = (String)searchMap.get("search");
		
		try {
			conn = getConnection();
			String sql = "select count(noticeNo) from notice";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) return rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List getNoticeList(Map searchMap) {
		
		List noticeList = new ArrayList();
		int pageNum = (Integer)searchMap.get("pageNum");
		int section = (Integer)searchMap.get("section");
		String search = (String)searchMap.get("search");
		int startNum = (section - 1)*27 + (pageNum -1)*9;
		try {
			conn = getConnection();
			String sql = "select * from notice"
						+ " where noticeTitle like ?"
						+ " or noticeContent like ?"
						+ " order by field(noticeCategory, 1) asc, noticeNo desc"
						+ " limit ?, 20";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setString(2, "%" + search + "%");
			pstmt.setInt(3, startNum);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVO notice = new NoticeVO();
				notice.setNoticeNo(rs.getInt("noticeNo"));
				notice.setNoticeTitle(rs.getString("noticeTitle"));
				notice.setNoticeContent(rs.getString("noticeContent"));
				notice.setNoticeFile(rs.getString("noticeFile"));
				notice.setNoticeCategory(rs.getInt("noticeCategory"));
				notice.setNoticeReadCount(rs.getInt("noticeReadCount"));
				notice.setNoticeWriteDate(rs.getTimestamp("noticeWriteDate"));
				noticeList.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return noticeList;
	}
	
	public int insertNotice(NoticeVO notice) {
		
		int noticeNo = 0;
		try {
			conn = getConnection();
			String sql = "insert into notice (noticeTitle, noticeContent, noticeWriteDate, noticeCategory, noticeFile)"
					+ "values (?, ?, now(), ?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setInt(3, notice.getNoticeCategory());
			pstmt.setString(4, notice.getNoticeFile());
			
			pstmt.executeUpdate();
			
			sql = "select noticeNo from notice order by noticeNo limit 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			
			noticeNo = rs.getInt("noticeNo");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return noticeNo;
	}
	
	public void increaseNoticeReadCount(int noticeNo) {
		
		try {
			conn = getConnection();
			String sql = "update notice set noticeReadCount = noticeReadCount +1"
						+ " where noticeNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
	}
	
	public NoticeVO getNotice(int noticeNo) {
		
		NoticeVO noticeVO = new NoticeVO();
		
		try {
			conn = getConnection();
			String sql = "select * from notice where noticeNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				noticeVO.setNoticeCategory(rs.getInt("noticeCategory"));
				noticeVO.setNoticeNo(rs.getInt("noticeNo"));
				noticeVO.setNoticeTitle(rs.getString("noticeTitle"));
				noticeVO.setNoticeContent(rs.getString("noticeContent"));
				noticeVO.setNoticeWriteDate(rs.getTimestamp("noticeWriteDate"));
				noticeVO.setNoticeReadCount(rs.getInt("noticeReadCount"));
				noticeVO.setNoticeFile(rs.getString("noticeFile"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return noticeVO;
	}
	
}
