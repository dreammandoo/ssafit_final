package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public User signup(User user) {
		userDao.insertUser(user);
		return user;
	}

	@Override
	public User login(String loginid, String password) {
		
		User tmp = userDao.selectByLoginId(loginid);
		
		if(tmp != null && tmp.getPassword().equals(password))
			return tmp;
		return null;
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

}
