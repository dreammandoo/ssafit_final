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

import com.ssafy.board.model.dto.Apply;
import com.ssafy.board.model.dto.Recruit;
import com.ssafy.board.model.service.ApplyService;
import com.ssafy.board.model.service.RecruitService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "참가신청 컨트롤러")
public class ApplyRestController {

	@Autowired
	private ApplyService applyService;

	@Autowired
	private RecruitService recruitService;
	
	// 지원글 작성
	@PostMapping("/apply")
	public ResponseEntity<String> applyWrite(Apply apply) {

		// 지원자가 꽉찼는지 확인
		int rid = apply.getRecruitid();
		int lim = recruitService.select(rid).getApplierslimit();
		int cur = recruitService.select(rid).getAppliers();
		if(cur>=lim) {
			return new ResponseEntity<String>("apply full", HttpStatus.OK);
		}
		
		// 지원한 적 있는지 확인
		int myid = apply.getCreatorid();
		List<Apply> applist = applyService.selectAll();
		for(Apply a: applist) {
			if(a.getCreatorid()==myid && a.getRecruitid()==rid) {
				return new ResponseEntity<String>("already applied", HttpStatus.OK);
			}
		}
		
		int num=0;
		try {
			num = applyService.insertApply(apply);
			recruitService.addApplier(rid);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<String>("apply insertion failed", HttpStatus.OK);
		}
		
		if(num==0) 
			return new ResponseEntity<String>("apply insertion failed", HttpStatus.OK);
		else
			return new ResponseEntity<String>("apply inserted", HttpStatus.OK);
	}

	// 지원글 삭제
	@DeleteMapping("/apply/{creatorid}/{recruitid}")
	public ResponseEntity<String> applyDelete(@PathVariable("creatorid") int creatorid,@PathVariable("recruitid") int recruitid){
		int num = applyService.deleteApply(creatorid, recruitid);
		System.out.println(num);
		if(num==0) 
			return new ResponseEntity<String>("apply delete failed", HttpStatus.OK);
		else {
			recruitService.delApplier(recruitid);
			return new ResponseEntity<String>("apply deleted", HttpStatus.OK);
		}
	}

	// 나의 지원글
	@GetMapping("/myapply/{creatorid}")
	public ResponseEntity<?> myApply(@PathVariable("creatorid") int creatorid){
		List<Apply> list = applyService.selectMy(creatorid);
		if(list==null)
			return new ResponseEntity<String>("no my apply", HttpStatus.OK);
		else
			return new ResponseEntity<List<Apply>>(list, HttpStatus.OK);
	}
	
}
