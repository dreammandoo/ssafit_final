package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.User;

public interface UserService {
	public List<User> getUserList();
	public User getUserById(int id);
	public User getUserByLoginId(String loginid);
	public User signup(User user);
	public User login(String loginid, String password);
}