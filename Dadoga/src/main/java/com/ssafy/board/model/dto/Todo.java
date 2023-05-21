package com.ssafy.board.model.dto;

public class Todo {
	private int id;
	private int userid;
	private String date;
	private int done;
	private String content;
	
	public Todo() {
		super();
	}
	public Todo(int id, int userid, String date, int done, String content) {
		super();
		this.id = id;
		this.userid = userid;
		this.date = date;
		this.done = done;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDone() {
		return done;
	}
	public void setDone(int done) {
		this.done = done;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", userid=" + userid + ", date=" + date + ", done=" + done + ", content=" + content
				+ "]";
	}
	
	
}
