package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.User;

public interface UserService {
	public List<User> getUserList();
	public User getUserById(int id);
	public User getUserByLoginId(String loginid);
	public int signup(User user);
	public int deleteUser(int id);
	public int updateUser(User user);
}
