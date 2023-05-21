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
import com.ssafy.board.model.service.ApplyService;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "참가신청 컨트롤러")
public class ApplyRestController {

	@Autowired
	private ApplyService applyService;

	// 지원글 작성
	@PostMapping("/apply")
	public ResponseEntity<String> applyWrite(Apply apply) {

		int num=0;
		
		try {
			num = applyService.insertApply(apply);
		} catch (Exception e) {
			System.out.println(e);
		}
		if(num==0) 
			return new ResponseEntity<String>("apply insertion failed", HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<String>("apply inserted", HttpStatus.CREATED);
	}

	// 지원글 삭제
	@DeleteMapping("/apply/{creatorid}/{recruitid}")
	public ResponseEntity<String> applyDelete(@PathVariable("creatorid") int creatorid,@PathVariable("recruitid") int recruitid){
		int num = applyService.deleteApply(creatorid, recruitid);
		System.out.println(num);
		if(num==0) 
			return new ResponseEntity<String>("apply delete failed", HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<String>("apply deleted", HttpStatus.OK);
	}

	// 나의 지원글
	@GetMapping("/myapply/{creatorid}")
	public ResponseEntity<?> myApply(@PathVariable("creatorid") int creatorid){
		List<Apply> list = applyService.selectMy(creatorid);
		if(list==null)
			return new ResponseEntity<String>("no my apply", HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Apply>>(list, HttpStatus.OK);
	}
	
}
