package day09;


import java.sql.Date;
import java.sql.Time;

public class BBSItem {
    private int seqNo;         // 순번
    private String title;      // 제목
    private String content;    // 내용
    private String writer;     // 작성자
    private Date date;         // 저장일자
    private Time time;         // 저장시각
    
    
    public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
}
