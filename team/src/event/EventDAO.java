package event;

import java.awt.print.Pageable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
	private String sql;
	
	public Connection getConnection() throws Exception{
		
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/team");
			conn = ds.getConnection();
			return conn;
	}
	
	//자원해제
	public void closeAll(){
		if(conn != null) try { conn.close(); } catch (Exception e) {e.printStackTrace();}
		if(pstmt != null) try { pstmt.close(); } catch (Exception e) {e.printStackTrace();}
		if(rs != null) try { rs.close(); } catch (Exception e) {e.printStackTrace();}
	}
	
	public List selectAllEvent(){
		
		List eventList = new ArrayList();
		
		try {
			conn = ds.getConnection();
			String sql = "select * from event order by eventNo desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				EventVO event = new EventVO();
				event.setEventNo(rs.getInt("eventNO"));
				event.setEventTitle(rs.getString("eventTitle"));
				event.setEventContent(rs.getString("eventContent"));
				event.setEventImage(rs.getString("eventImage"));
				event.setEventWriteDate(rs.getTimestamp("eventWrite"));
				eventList.add(event);
			}
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eventList;
	}
	
	public int getNewEventNo() {
		
		int eventNo = 0;
		
		try {
			conn = ds.getConnection();
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
	
	public int insertNewEvent(EventVO event) {
		
		int eventNo = getNewEventNo();
		try {
			conn = ds.getConnection();
			String eventTitle = event.getEventTitle();
			String eventContent = event.getEventContent();
			String eventImage = event.getEventImage();
			Timestamp eventWriteDate = event.getEventWriteDate();
			
			String sql = "insert into event (eventNo, eventTitle, eventContent, eventImage, eventWriteDate"
					+ "values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventNo);
			pstmt.setString(2, eventTitle);
			pstmt.setString(3, eventContent);
			pstmt.setString(4, eventImage);
			pstmt.setTimestamp(5, eventWriteDate);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return eventNo;
	}
	
	
}
