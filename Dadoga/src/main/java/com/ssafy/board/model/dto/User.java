package com.ssafy.board.model.dto;

public class User {
	private int id;
	private String loginid;
	private String password;
	private String nickname;
	private String email;
	private int age;
	private String createdtime;
	private int exp;
	private int level;
	private String gender;
	private String img;
	
	public User() {
		super();
	}

	public User(int id, String loginid, String password, String nickname, String email, int age, String createdtime,
			int exp, int level, String gender, String img) {
		super();
		this.id = id;
		this.loginid = loginid;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.age = age;
		this.createdtime = createdtime;
		this.exp = exp;
		this.level = level;
		this.gender = gender;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginid=" + loginid + ", password=" + password + ", nickname=" + nickname
				+ ", email=" + email + ", age=" + age + ", createdtime=" + createdtime + ", exp=" + exp + ", level="
				+ level + ", gender=" + gender + ", img=" + img + "]";
	}
	
	
	
	
	
	
}
