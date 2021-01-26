package event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import customerService.NoticeVO;

public class EventDAO {
	
	private DataSource ds;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	//DB연결
	public Connection getConnection() throws Exception{
		
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/team");
			conn = ds.getConnection();
			return conn;
	}
	
	//자원해제
	public void closeAll(){
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
			e.printStackTrace();
		}
	}
	
	//검색어에 해당하는 이벤트 리스트 가져오기
	public List getSearchEventList(Map pagingMap){
		List eventList = new ArrayList();
		
		int section = (Integer)pagingMap.get("section");
		int pageNum = (Integer)pagingMap.get("pageNum");
		int startNum = (section - 1)*27 + (pageNum -1)*8;
		String search = (String)pagingMap.get("search");
		
		try {
			conn = getConnection();
			String sql = "select * from event"
					+ " where eventTitle like ?"
					+ " order by eventNo desc"
					+ " limit ?, 8";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, startNum);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				EventVO event = new EventVO();
				event.setEventNo(rs.getInt("eventNo"));
				event.setEventTitle(rs.getString("eventTitle"));
				event.setEventContent(rs.getString("eventContent"));
				event.setEventImage(rs.getString("eventImage"));
				eventList.add(event);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return eventList;
	}
	
	//전체 이벤트 리스트 가져오기
	public List getNewEventList() {
		List eventList = new ArrayList();
		
		try {
			conn = getConnection();
			String sql = "select * from event"
						+ " order by eventNo desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EventVO eventVO = new EventVO();
				eventVO.setEventNo(rs.getInt("eventNo"));
				eventVO.setEventTitle(rs.getString("eventTitle"));
				eventVO.setEventContent(rs.getString("eventContent"));
				eventVO.setEventImage(rs.getString("eventImage"));
				eventVO.setEventWriteDate(rs.getTimestamp("eventWriteDate"));
				
				eventList.add(eventVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return eventList;
	}
	
	//검색어에 해당하는 글개수 얻기
	public int searchEventCount(Map pagingMap) {
		
		int section = (Integer)pagingMap.get("section");
		int pageNum = (Integer)pagingMap.get("pageNum");
		int startNum = (section - 1)*27 + (pageNum - 1)*9;
		String search = (String) pagingMap.get("search");
		
		try {
			conn = getConnection();
			String sql = "select count(eventNo) from event where eventTitle like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%'+search+'%');
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return 0;
	}
	
	//글 개수 가져오기
	public int getEventListCount() {
		int eventListCount = 0;
		try {
			conn = getConnection();
			String sql = "select count(eventNo) from event";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				eventListCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return eventListCount;
	}
	
	//최신 글번호 가져오기
	public int getNewEventNo() {
		
		int eventNo = 0;
		
		try {
			conn = getConnection();
			String sql = "select max(eventNo) from event";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				eventNo = rs.getInt(1) + 1;
			} else {
				eventNo = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return eventNo;
	}
	
	//새 이번트 등록 후 해당 글번호 가져오기 
	public int insertEvent(EventVO event) {
		
		int eventNo=0;
		try {
			conn = getConnection();
			
			String sql = "insert into event (eventTitle, eventContent, eventImage, eventWriteDate)"
					+ "values (?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, event.getEventTitle());
			pstmt.setString(2, event.getEventContent());
			pstmt.setString(3, event.getEventImage());
			
			pstmt.executeUpdate();
			
			sql =  "select eventNo from event order by eventNo desc limit 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			
			eventNo = rs.getInt("eventNo");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return eventNo;
	}
	
	//글번호에 해당하는 이벤트 글 가져오기
	 public EventVO getEvent(int eventNo) {
		
		 EventVO eventVO = new EventVO();
		 
		 try {
			conn = getConnection();
			
			String sql = "select *,"
						+ "(select ifnull(eventNo,0) from event where eventNo < ? order by eventNo desc limit 1) as prev_eventNo,"
						+ "(select ifnull(eventNo,0) from event where eventNo > ? order by eventNo asc limit 1) as next_eventNo"
						+ " from event where eventNo = ?";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventNo);
			pstmt.setInt(2, eventNo);
			pstmt.setInt(3, eventNo);
			rs = pstmt.executeQuery();
			rs.next();
			
			eventVO.setEventNo(rs.getInt("eventNo"));
			eventVO.setEventTitle(rs.getString("eventTitle"));
			eventVO.setEventContent(rs.getString("eventContent"));
			eventVO.setEventImage(rs.getString("eventImage"));
			eventVO.setEventWriteDate(rs.getTimestamp("eventWriteDate"));
			eventVO.setPrev_eventNo(rs.getInt("prev_eventNo"));
			eventVO.setNext_eventNo(rs.getInt("next_eventNo"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return eventVO;
	 }
	 
	 //이벤트 글 수정
	 public void updateEvent(EventVO event) {
		 
		 String eventImage = event.getEventImage();
		 try {
			conn = getConnection();
			String sql = "update event set eventTitle=?, eventContent=?";
					
			if(eventImage != null && eventImage.length() != 0) {
				sql += ", eventImage=?";
			}
			sql += " where eventNo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, event.getEventTitle());
			pstmt.setString(2, event.getEventContent());
			
			if(eventImage != null && eventImage.length() != 0) {
				pstmt.setString(3, eventImage);
				pstmt.setInt(4, event.getEventNo());
			} else {
				pstmt.setInt(3, event.getEventNo());
			}
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
	 }
	 
	 public void updateEvent(EventVO eventVO, String deleteFile) {
			
			String eventImage = eventVO.getEventImage();
			
			try {
				conn = getConnection();
				
				if(eventImage != null && eventImage.length() != 0) {
					String sql = "update event set eventTitle=?, eventContent=?, eventImage=?"
							+ " where eventNo= ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, eventVO.getEventTitle());
					pstmt.setString(2, eventVO.getEventContent());
					pstmt.setString(3, eventVO.getEventImage());
					pstmt.setInt(4, eventVO.getEventNo());	
				} else if(deleteFile != null) {
					String sql = "update event set eventTitle=?, eventContent=?, eventImage=?"
							+ " where eventNo= ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, eventVO.getEventTitle());
					pstmt.setString(2, eventVO.getEventContent());
					pstmt.setString(3, null);
					pstmt.setInt(4, eventVO.getEventNo());
				} else {
					String sql = "update event set eventTitle=?, eventContent=?"
							+ " where eventNo= ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, eventVO.getEventTitle());
					pstmt.setString(2, eventVO.getEventContent());
					pstmt.setInt(3, eventVO.getEventNo());
				}
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll();
			}
		}
	 
	 //삭제할 글번호
	 public List<Integer> selectRemoveEvent(int eventNo) {
		 
		 List<Integer> removeEventNo = new ArrayList<Integer>();
		 
		 try {
			conn = getConnection();
			String sql = "select * from event where eventNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				eventNo = rs.getInt("eventNo");
				removeEventNo.add(eventNo);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return removeEventNo;
	 }
	
	 //이벤트 글 삭제
	 public void deleteEvent(int eventNo) {
		 
		 try {
			 conn = getConnection();
			 String sql = "delete from event"
					 	+ " where eventNo = ?";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, eventNo);
			 pstmt.executeUpdate();
			 closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
	 }
	 //이전 글 다음글 
	 
}

