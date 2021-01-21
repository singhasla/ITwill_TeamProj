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

public class FaqDAO {
	
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
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<FaqVO> faqList(Map faqMap) {
		
		List<FaqVO> faqList = new ArrayList<FaqVO>();
		int section = (int)faqMap.get("section");
		int pageNo = (int)faqMap.get("pageNo"); 
		int startNum = (section - 1)*27 + (pageNo - 1)*10;
		String search = (String)faqMap.get("search");
		
		try {
			conn = getConnection();
			String sql = "select * from faq"
						+ " where faqTitle like ?"
						+ " order by faqNo desc"
						+ " limit ?, 10";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, startNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FaqVO faqVO = new FaqVO();
				faqVO.setFaqNo(rs.getInt("faqNo"));
				faqVO.setFaqTitle(rs.getString("faqTitle"));
				faqVO.setFaqContent(rs.getString("faqContent"));
				faqList.add(faqVO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return faqList;	
	}
	
	public int faqListCount() {
		
		try {
			conn = getConnection();
			String sql = "select count(faqNo) from faq";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) return rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return 0;
	}
}
