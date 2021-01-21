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

public class QnaDAO {
	
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
	
	public int insertQna(QnaVO qnaVO) {
		
		int qnaNo = 0;
		try {
			conn = getConnection();
			String sql = "insert into qna (userNo, qnaTitle, qnaContent, qnaCategory, qnaWriteDate)"
						+ " values (?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaVO.getUserNo());
			pstmt.setString(2, qnaVO.getQnaTitle());
			pstmt.setString(3, qnaVO.getQnaContent());
			pstmt.setString(4, qnaVO.getQnaCategory());
			
			pstmt.executeUpdate();
			
			sql = "select qnaNo from qna order by qnaNo desc limit 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			
			qnaNo = rs.getInt("qnaNo");
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return qnaNo;
	}
	
	public List<QnaVO> myQnaList(Map qnaMap) {
		
		List<QnaVO> qnaList = new ArrayList<QnaVO>();
		int userNo = (int)qnaMap.get("userNo");
		int section = (int)qnaMap.get("section");
		int pageNo = (int)qnaMap.get("pageNo"); 
		int startNum = (section - 1)*27 + (pageNo - 1)*10;
		
		try {
			conn = getConnection();
			String sql = "select * from qna"
						+ " where userNo like ?"
						+ " order by qnaNo desc"
						+ " limit ?, 10";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				QnaVO qnaVO = new QnaVO();
				qnaVO.setUserNo(rs.getInt("userNo"));
				qnaVO.setQnaNo(rs.getInt("qnaNo"));
				qnaVO.setQnaTitle(rs.getString("qnaTitle"));
				qnaVO.setQnaContent(rs.getString("qnaContent"));
				qnaVO.setQnaCategory(rs.getString("qnaCategory"));
				qnaVO.setQnaWriteDate(rs.getTimestamp("qnaWriteDate"));
				qnaVO.setAnswerTitle(rs.getString("answerTitle"));
				qnaVO.setAnswerContent(rs.getString("answerContent"));
				qnaVO.setAnswerWriteDate(rs.getTimestamp("answerWriteDate"));
				qnaList.add(qnaVO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return qnaList;
	}
	
	public int qnaListCount(int userNo) {
		
		try {
			conn = getConnection();
			String sql = "select count(qnaNo) from qna"
						+ " where userNo =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) return rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return 0;
	}
	
	public QnaVO getQna(int qnaNo) {
		QnaVO qnaVO = new QnaVO();
		
		try {
			conn = getConnection();
			String sql = "select * from qna"
						+ " where qnaNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				qnaVO.setUserNo(rs.getInt("userNo"));
				qnaVO.setQnaNo(rs.getInt("qnaNo"));
				qnaVO.setQnaTitle(rs.getString("qnaTitle"));
				qnaVO.setQnaContent(rs.getString("qnaContent"));
				qnaVO.setQnaCategory(rs.getString("qnaCategory"));
				qnaVO.setQnaWriteDate(rs.getTimestamp("qnaWriteDate"));
				qnaVO.setAnswerTitle(rs.getString("answerTitle"));
				qnaVO.setAnswerContent(rs.getString("answerContent"));
				qnaVO.setAnswerWriteDate(rs.getTimestamp("answerWriteDate"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return qnaVO;
	}
	
}
