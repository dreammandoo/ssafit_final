package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.UserDao;
import com.ssafy.board.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	@Transactional
	@Override
	public int signup(User user) {
		return userDao.insertUser(user);
	}


	@Override
	public User getUserById(int id) {
		User tmp = userDao.selectById(id);
		return tmp;
	}

	@Override
	public User getUserByLoginId(String loginid) {
		User tmp = userDao.selectByLoginId(loginid);
		return tmp;
	}

	@Override
	public int deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

}
