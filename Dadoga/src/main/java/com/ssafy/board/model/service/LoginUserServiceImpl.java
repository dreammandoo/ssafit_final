package com.ssafy.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.LoginUserDao;
import com.ssafy.board.model.dto.LoginUser;

@Service
public class LoginUserServiceImpl implements LoginUserService{

	@Autowired
	private LoginUserDao loginUserDao;
	
	@Override
	@Cacheable(value = "token", key="#loginid")
	public LoginUser getToken(String loginid) {
		return loginUserDao.getToken(loginid);
	}

	@Override
	@CachePut(value = "token", key = "#loginUser.loginid")
	public int insertToken(LoginUser loginUser) {
		return loginUserDao.insertToken(loginUser);
	}

	@Override
	@CachePut(value = "token", key = "#loginUser.loginid")
	public int updateToken(LoginUser loginUser) {
		return loginUserDao.updateToken(loginUser);
	}

	@Override
	@CacheEvict(value = "token", key = "#loginid")
	public int deleteToken(String loginid) {
		return loginUserDao.deleteToken(loginid);
	}

}
