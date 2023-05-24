package com.ssafy.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Apply;
import com.ssafy.board.model.dto.Comment;
import com.ssafy.board.model.dto.Recruit;
import com.ssafy.board.model.service.ApplyService;
import com.ssafy.board.model.service.CommentService;
import com.ssafy.board.model.service.RecruitService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "모임모집 컨트롤러")
public class RecruitRestController {

	@Autowired
	private RecruitService recruitService;
	@Autowired
	private ApplyService applyService;
	@Autowired
	private CommentService commentService;

	// 모임리스트
	@GetMapping("/recruit")
	public ResponseEntity<?> recruitList() {
		List<Recruit> list = recruitService.selectAll();
		if(list==null)
			return new ResponseEntity<String>("no list", HttpStatus.OK);
		
		return new ResponseEntity<List<Recruit>>(list, HttpStatus.OK);
	}
	
	// 모임글 상세
	@GetMapping("/recruit/{id}")
	public ResponseEntity<?> recruitDetail(@PathVariable("id") int id) {
		
		// 글, 참가리스트, 후기리스트 다 집어넣어야댐
		Map<String,Object> result = new HashMap<>();
		
		Recruit recruitDetial = recruitService.select(id);
		List<Apply> applyList = applyService.selectByRecruitId(id);
		List<Comment> commentList = commentService.selectByRecruitId(id);
		
		result.put("recruit_detail", recruitDetial);
		result.put("apply_list", applyList);
		result.put("comment_list", commentList);
		
		return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
	}
	
	// 모임글 작성
	@PostMapping("/recruit")
	public ResponseEntity<?> recruitWrite(Recruit recruit) {
		int num = 0;
		try {
			num = recruitService.insert(recruit);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<String>("recruit insertion failed", HttpStatus.OK);
		}
		if(num==0) 
			return new ResponseEntity<String>("recruit insertion failed", HttpStatus.OK);
		else
			return new ResponseEntity<Integer>(recruit.getId(), HttpStatus.OK);
	}

	// 모임글 수정
	@PutMapping("/recruit")
	public ResponseEntity<String> recruitUpdate(Recruit recruit) {
		int num = 0;
		try {
			num = recruitService.update(recruit);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<String>("recruit update failed", HttpStatus.OK);
		}
		if(num==0) 
			return new ResponseEntity<String>("recruit update failed", HttpStatus.OK);
		else
			return new ResponseEntity<String>("recruit updated", HttpStatus.OK);
	}

	// 모임글 삭제
	@DeleteMapping("/recruit/{id}")
	public ResponseEntity<String> recruitDelete(@PathVariable("id") int id){
		int num = recruitService.delete(id);
		System.out.println(num);
		if(num==0) 
			return new ResponseEntity<String>("recruit delete failed", HttpStatus.OK);
		else 
			return new ResponseEntity<String>("recruit deleted", HttpStatus.OK);
	}

	// 유저가 쓴 모임글 
	@GetMapping("/myrecruit/{writerid}")
	public ResponseEntity<?> myRecruitList(@PathVariable("writerid") int writerid) {
		
		List<Recruit> list = recruitService.selectMy(writerid);
		
		if(list==null)
			return new ResponseEntity<String>("no my recruit", HttpStatus.OK);
		else
			return new ResponseEntity<List<Recruit>>(list, HttpStatus.OK);
		
	}
	
}
