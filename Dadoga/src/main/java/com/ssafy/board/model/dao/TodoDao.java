package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Todo;

public interface TodoDao {
	public List<Todo> selectMy(int userid);
	public int insertTodo(Todo todo);
	public int deleteTodo(int id);
	public int updateDone(int id);
}
