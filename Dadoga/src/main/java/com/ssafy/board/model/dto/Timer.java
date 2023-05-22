package com.ssafy.board.model.dto;

public class Timer {
	private int id;
	private int userid;
	private String event;
	private String timer;
	private String date;
	
	
	public Timer() {
		super();
	}


	public Timer(int id, int userid, String event, String timer, String date) {
		super();
		this.id = id;
		this.userid = userid;
		this.event = event;
		this.timer = timer;
		this.date = date;
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


	public String getEvent() {
		return event;
	}


	public void setEvent(String event) {
		this.event = event;
	}


	public String getTimer() {
		return timer;
	}


	public void setTimer(String timer) {
		this.timer = timer;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Timer [id=" + id + ", userid=" + userid + ", event=" + event + ", timer=" + timer + ", date=" + date
				+ "]";
	}
	
	
}
