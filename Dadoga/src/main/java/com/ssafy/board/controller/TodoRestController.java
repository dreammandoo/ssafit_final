package com.ssafy.board.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Todo;
import com.ssafy.board.model.service.TodoService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "투두리스트 컨트롤러")
public class TodoRestController {

	@Autowired
	private TodoService todoService;

	// 나의 투두리스트
	@GetMapping("/todo/{userid}")
	public ResponseEntity<?> myTodo(@PathVariable("userid") int userid) {
		List<Todo> list = todoService.selectMy(userid);
		if(list==null || list.size()==0)
			return new ResponseEntity<String>("no list", HttpStatus.OK);
		
		return new ResponseEntity<List<Todo>>(list, HttpStatus.OK);
	}
	
	
	// 투두리스트 작성
	@PostMapping("/todo")
	public ResponseEntity<String> insertTodo(Todo todo) {

		int num=0;
		try {
			num = todoService.insertTodo(todo);
		} catch (Exception e) {
			System.out.println(e);
		}
		if(num==0) 
			return new ResponseEntity<String>("todo insertion failed", HttpStatus.OK);
		else
			return new ResponseEntity<String>("todo inserted", HttpStatus.OK);
	}

	// 투두리스트 완료 변경
	@PutMapping("/todo/{id}")
	public ResponseEntity<String> updateDone(@PathVariable("id") int id) {
		int num = todoService.updateDone(id);
		
		if(num==0) 
			return new ResponseEntity<String>("todo done modify failed", HttpStatus.OK);
		else
			return new ResponseEntity<String>("todo done modified", HttpStatus.OK);
	}

	// 투두리스트 삭제
	@DeleteMapping("/todo/{id}")
	public ResponseEntity<String> recruitDelete(@PathVariable("id") int id){
		int num = todoService.deleteTodo(id);
		if(num==0) 
			return new ResponseEntity<String>("todo delete failed", HttpStatus.OK);
		else 
			return new ResponseEntity<String>("todo deleted", HttpStatus.OK);
	}

	
	
}
