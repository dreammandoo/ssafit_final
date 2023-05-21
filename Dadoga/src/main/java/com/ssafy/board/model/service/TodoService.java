package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Todo;

public interface TodoService {
	public List<Todo> selectMy(int userid);
	public int insertTodo(Todo todo);
	public int deleteTodo(int id);
	public int updateDone(int id);
}
