package customerService;

import java.sql.Timestamp;

public class QnaVO {
	
	private int qnaNo;
	private int userNo;
	private String qnaTitle;
	private String qnaContent;
	private Timestamp qnaWriteDate;
	private String answerTitle;
	private String answerContent;
	private Timestamp answerWriteDate;
	private Timestamp answerUpdateDate;
	
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public Timestamp getQnaWriteDate() {
		return qnaWriteDate;
	}
	public void setQnaWriteDate(Timestamp qnaWriteDate) {
		this.qnaWriteDate = qnaWriteDate;
	}
	public String getAnswerTitle() {
		return answerTitle;
	}
	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public Timestamp getAnswerWriteDate() {
		return answerWriteDate;
	}
	public void setAnswerWriteDate(Timestamp answerWriteDate) {
		this.answerWriteDate = answerWriteDate;
	}
	public Timestamp getAnswerUpdateDate() {
		return answerUpdateDate;
	}
	public void setAnswerUpdateDate(Timestamp answerUpdateDate) {
		this.answerUpdateDate = answerUpdateDate;
	}
	
	
}
