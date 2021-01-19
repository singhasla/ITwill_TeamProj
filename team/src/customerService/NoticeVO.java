package customerService;

import java.sql.Timestamp;

public class NoticeVO {
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private Timestamp noticeWriteDate;
	private Timestamp noticeUpdateDate;
	private String noticeCategory;
	private int noticeReadCount;
	private String noticeFile;
	
	public NoticeVO() {
		
	}

	public NoticeVO(int noticeNo, String noticeTitle, String noticeContent, String noticeCategory, int noticeReadCount, String noticeFile) {
	
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeCategory = noticeCategory;
		this.noticeReadCount = noticeReadCount;
		this.noticeFile = noticeFile;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Timestamp getNoticeWriteDate() {
		return noticeWriteDate;
	}

	public void setNoticeWriteDate(Timestamp noticeWriteDate) {
		this.noticeWriteDate = noticeWriteDate;
	}

	public Timestamp getNoticeUpdateDate() {
		return noticeUpdateDate;
	}

	public void setNoticeUpdateDate(Timestamp noticeUpdateDate) {
		this.noticeUpdateDate = noticeUpdateDate;
	}


	public String getNoticeCategory() {
		return noticeCategory;
	}

	public void setNoticeCategory(String noticeCategory) {
		this.noticeCategory = noticeCategory;
	}

	public int getNoticeReadCount() {
		return noticeReadCount;
	}

	public void setNoticeReadCount(int noticeReadCount) {
		this.noticeReadCount = noticeReadCount;
	}

	public String getNoticeFile() {
		return noticeFile;
	}

	public void setNoticeFile(String noticeFile) {
		this.noticeFile = noticeFile;
	}
	
	
	
	
}
