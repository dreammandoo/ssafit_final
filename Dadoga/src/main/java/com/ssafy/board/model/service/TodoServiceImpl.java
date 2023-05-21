package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.TodoDao;
import com.ssafy.board.model.dto.Todo;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoDao todoDao;
	
	@Override
	public List<Todo> selectMy(int userid) {
		return todoDao.selectMy(userid);
	}

	@Transactional
	@Override
	public int insertTodo(Todo todo) {
		return todoDao.insertTodo(todo);
	}

	@Transactional
	@Override
	public int deleteTodo(int id) {
		return todoDao.deleteTodo(id);
	}

	@Transactional
	@Override
	public int updateDone(int id) {
		return todoDao.updateDone(id);
	}

}
