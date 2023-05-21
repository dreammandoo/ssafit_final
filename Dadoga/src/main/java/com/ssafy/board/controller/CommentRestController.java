package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Apply;
import com.ssafy.board.model.dto.Comment;
import com.ssafy.board.model.service.CommentService;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "후기 컨트롤러")
public class CommentRestController {

	@Autowired
	private CommentService commentService;

	// 후기글 작성
	@PostMapping("/comment")
	public ResponseEntity<String> commentWrite(Comment comment) {

		int num=0;
		
		try {
			num = commentService.insertComment(comment);
		} catch (Exception e) {
			System.out.println(e);
		}
		if(num==0) 
			return new ResponseEntity<String>("comment insertion failed", HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<String>("comment inserted", HttpStatus.CREATED);
	}

	

	// 후기글 삭제
	@DeleteMapping("/comment/{creatorid}/{recruitid}")
	public ResponseEntity<String> commentDelete(@PathVariable("creatorid") int creatorid,@PathVariable("recruitid") int recruitid){
		int num = commentService.deleteComment(creatorid, recruitid);
		System.out.println(num);
		if(num==0) 
			return new ResponseEntity<String>("comment delete failed", HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<String>("comment deleted", HttpStatus.OK);
	}

	// 나의 후기글
	@GetMapping("/mycomment/{creatorid}")
	public ResponseEntity<?> myComment(@PathVariable("creatorid") int creatorid){
		List<Comment> list = commentService.selectMy(creatorid);
		if(list==null)
			return new ResponseEntity<String>("no my comment", HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Comment>>(list, HttpStatus.OK);
	}
	
}
