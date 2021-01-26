package event;

import java.sql.Timestamp;

public class EventVO {
	
	private int eventNo;
	private String eventTitle;
	private String eventContent;
	private String eventImage;
	private Timestamp eventWriteDate;
	private Timestamp eventUpdateDate;
	private int prev_eventNo;
	private int next_eventNo;
	
	public EventVO() {
		
	}

	public EventVO(String eventTitle, String eventContent, String eventImage) {
		
		this.eventTitle = eventTitle;
		this.eventContent = eventContent;
		this.eventImage = eventImage;
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventContent() {
		return eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	public String getEventImage() {
		return eventImage;
	}

	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}

	public Timestamp getEventWriteDate() {
		return eventWriteDate;
	}

	public void setEventWriteDate(Timestamp eventWriteDate) {
		this.eventWriteDate = eventWriteDate;
	}

	public Timestamp getEventUpdateDate() {
		return eventUpdateDate;
	}

	public void setEventUpdateDate(Timestamp eventUpdateDate) {
		this.eventUpdateDate = eventUpdateDate;
	}

	public int getPrev_eventNo() {
		return prev_eventNo;
	}

	public void setPrev_eventNo(int prev_eventNo) {
		this.prev_eventNo = prev_eventNo;
	}

	public int getNext_eventNo() {
		return next_eventNo;
	}

	public void setNext_eventNo(int next_eventNo) {
		this.next_eventNo = next_eventNo;
	}
	
	
	
	
	
}
