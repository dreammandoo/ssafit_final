package com.ssafy.board.model.service;

import com.ssafy.board.model.dto.LoginUser;

public interface LoginUserService {
	public LoginUser getToken(String loginid);
	public int insertToken(LoginUser loginUser);
	public int updateToken(LoginUser loginUser);
	public int deleteToken(String loginid);
}
