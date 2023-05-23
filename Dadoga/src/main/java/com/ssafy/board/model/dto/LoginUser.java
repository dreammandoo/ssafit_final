package com.ssafy.board.model.dto;

public class LoginUser {
	private String loginid;
	private String token;
	
	public LoginUser() {
		super();
	}
	public LoginUser(String loginid, String token) {
		super();
		this.loginid = loginid;
		this.token = token;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "LoginUser [loginid=" + loginid + ", token=" + token + "]";
	}
	
	
}
