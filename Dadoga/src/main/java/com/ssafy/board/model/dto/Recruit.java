package com.ssafy.board.model.dto;

public class Recruit {
	private int id;
	private int writerid;
	private String title;
	private String content;
	private String datetime;
	private String location;
	private String part;
	private int gender;
	private int level;
	public int appliers;
	public int applierslimit;
	public String createdtime;
	public String img;
	public int done;
	
	public Recruit() {
		super();
	}
	public Recruit(int id, int writerid, String title, String content, String datetime, String location, String part,
			int gender, int level, int appliers, int applierslimit, String createdtime, String img, int done) {
		super();
		this.id = id;
		this.writerid = writerid;
		this.title = title;
		this.content = content;
		this.datetime = datetime;
		this.location = location;
		this.part = part;
		this.gender = gender;
		this.level = level;
		this.appliers = appliers;
		this.applierslimit = applierslimit;
		this.createdtime = createdtime;
		this.img = img;
		this.done = done;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWriterid() {
		return writerid;
	}
	public void setWriterid(int writerid) {
		this.writerid = writerid;
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
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getAppliers() {
		return appliers;
	}
	public void setAppliers(int appliers) {
		this.appliers = appliers;
	}
	public int getApplierslimit() {
		return applierslimit;
	}
	public void setApplierslimit(int applierslimit) {
		this.applierslimit = applierslimit;
	}
	public String getCreatedtime() {
		return createdtime;
	}
	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getDone() {
		return done;
	}
	public void setDone(int done) {
		this.done = done;
	}
	@Override
	public String toString() {
		return "Recruit [id=" + id + ", writerid=" + writerid + ", title=" + title + ", content=" + content
				+ ", datetime=" + datetime + ", location=" + location + ", part=" + part + ", gender=" + gender
				+ ", level=" + level + ", appliers=" + appliers + ", applierslimit=" + applierslimit + ", createdtime="
				+ createdtime + ", img=" + img + ", done=" + done + "]";
	}
	
	
	
	
	
	
}
