package com.ssafy.board.model.dto;

public class Apply {
	private int id;
	private int recruitid;
	private int creatorid;
	String title;
	String content;
	String createdtime;
	
	public Apply() {
		super();
	}

	public Apply(int id, int recruitid, int creatorid, String title, String content, String createdtime) {
		super();
		this.id = id;
		this.recruitid = recruitid;
		this.creatorid = creatorid;
		this.title = title;
		this.content = content;
		this.createdtime = createdtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRecruitid() {
		return recruitid;
	}

	public void setRecruitid(int recruitid) {
		this.recruitid = recruitid;
	}

	public int getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(int creatorid) {
		this.creatorid = creatorid;
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

	public String getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}

	@Override
	public String toString() {
		return "Apply [id=" + id + ", recruitid=" + recruitid + ", creatorid=" + creatorid + ", title=" + title
				+ ", content=" + content + ", createdtime=" + createdtime + "]";
	}
	
	
}
