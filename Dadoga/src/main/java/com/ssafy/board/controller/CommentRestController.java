package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Comment;
import com.ssafy.board.model.service.ApplyService;
import com.ssafy.board.model.service.CommentService;
import com.ssafy.board.model.service.RecruitService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "후기 컨트롤러")
public class CommentRestController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private ApplyService applyService;
	
	// 후기글 작성
	@PostMapping("/comment")
	public ResponseEntity<String> commentWrite(Comment comment) {

		int rid = comment.getRecruitid();
		int myid = comment.getCreatorid();
		
		// 신청한 적 있는지 확인
		if(applyService.selectByCreatorId(myid)==null) {
			return new ResponseEntity<String>("need to apply first", HttpStatus.OK);
		}
		
		// 이미 작성했는지 확인
		List<Comment> comlist = commentService.selectAll();
		for(Comment c: comlist) {
			if(c.getCreatorid()==myid && c.getRecruitid()==rid) {
				return new ResponseEntity<String>("already commented", HttpStatus.OK);
			}
		}
		
		// 
		int num=0;
		try {
			num = commentService.insertComment(comment);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<String>("comment insertion failed", HttpStatus.OK);
		}
		if(num==0) 
			return new ResponseEntity<String>("comment insertion failed", HttpStatus.OK);
		else
			return new ResponseEntity<String>("comment inserted", HttpStatus.OK);
	}

	

	// 후기글 삭제
	@DeleteMapping("/comment/{creatorid}/{recruitid}")
	public ResponseEntity<String> commentDelete(@PathVariable("creatorid") int creatorid,@PathVariable("recruitid") int recruitid){
		int num = commentService.deleteComment(creatorid, recruitid);
		System.out.println(num);
		if(num==0) 
			return new ResponseEntity<String>("comment delete failed", HttpStatus.OK);
		else 
			return new ResponseEntity<String>("comment deleted", HttpStatus.OK);
	}

	// 나의 후기글
	@GetMapping("/mycomment/{creatorid}")
	public ResponseEntity<?> myComment(@PathVariable("creatorid") int creatorid){
		List<Comment> list = commentService.selectMy(creatorid);
		if(list==null)
			return new ResponseEntity<String>("no my comment", HttpStatus.OK);
		else
			return new ResponseEntity<List<Comment>>(list, HttpStatus.OK);
	}
	
}
