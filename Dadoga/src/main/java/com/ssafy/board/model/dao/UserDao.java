package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.User;

public interface UserDao {
	public List<User> selectAll();
	public int insertUser(User user);
	public User selectById(int id);
	public User selectByLoginId(String loginid);
	public int deleteUser(int id);
	public int updateUser(User user);
}