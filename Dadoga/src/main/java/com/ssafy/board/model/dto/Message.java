package com.ssafy.board.model.dto;

public class Message {
	private int id;
	private int senderid;
	private int receiverid;
	private String title;
	private String content;
	private int checked;
	private String createdtime;
	
	public Message() {
		super();
	}
	public Message(int id, int senderid, int receiverid, String title, String content, int checked,
			String createdtime) {
		super();
		this.id = id;
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.title = title;
		this.content = content;
		this.checked = checked;
		this.createdtime = createdtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSenderid() {
		return senderid;
	}
	public void setSenderid(int senderid) {
		this.senderid = senderid;
	}
	public int getReceiverid() {
		return receiverid;
	}
	public void setReceiverid(int receiverid) {
		this.receiverid = receiverid;
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
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	public String getCreatedtime() {
		return createdtime;
	}
	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", senderid=" + senderid + ", receiverid=" + receiverid + ", title=" + title
				+ ", content=" + content + ", checked=" + checked + ", createdtime=" + createdtime + "]";
	}
	
	
	
}
