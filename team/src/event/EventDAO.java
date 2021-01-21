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
	
	//
	public List selectAllEvents(Map pagingMap){
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
	//전체 이벤트 조회
	public List selectAllEvent(){
		
		List eventList = new ArrayList();
		
		try {
			conn = getConnection();
			String sql = "select * from event order by eventNo desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				EventVO event = new EventVO();
				event.setEventNo(rs.getInt("eventNO"));
				event.setEventTitle(rs.getString("eventTitle"));
				event.setEventContent(rs.getString("eventContent"));
				event.setEventImage(rs.getString("eventImage"));
				event.setEventWriteDate(rs.getTimestamp("eventWriteDate"));
				eventList.add(event);
			}
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eventList;
	}
	
	//검색어에 해당하는 글갯수 얻기
	public int allEvents(Map pagingMap) {
		
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
	public int insertNewEvent(EventVO event) {
		
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
	 public EventVO selectEvent(int eventNo) {
		
		 EventVO event = new EventVO();
		 
		 try {
			conn = getConnection();
			
			String sql = "select eventNo, eventTitle, eventContent, "
						+ "eventImage, eventWriteDate"
						+ " from event where eventNo = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventNo);
			rs = pstmt.executeQuery();
			rs.next();
			
			event.setEventNo(rs.getInt("eventNo"));
			event.setEventTitle(rs.getString("eventTitle"));
			event.setEventContent(rs.getString("eventContent"));
			event.setEventImage(rs.getString("eventImage"));
			event.setEventWriteDate(rs.getTimestamp("eventWriteDate"));
			
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return event;
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
		} 
	 }


}

