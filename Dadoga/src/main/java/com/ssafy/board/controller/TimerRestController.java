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

import com.ssafy.board.model.dto.Timer;
import com.ssafy.board.model.service.TimerService;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "타이머 컨트롤러")
public class TimerRestController {

	@Autowired
	private TimerService timerService;

	// 나의 타이머리스트
	@GetMapping("/timer/{userid}")
	public ResponseEntity<?> myTimer(@PathVariable("userid") int userid) {
		List<Timer> list = timerService.selectMy(userid);
		if(list==null || list.size()==0)
			return new ResponseEntity<String>("no list", HttpStatus.OK);
		
		return new ResponseEntity<List<Timer>>(list, HttpStatus.OK);
	}
	
	
	// 타이머 작성
	@PostMapping("/timer")
	public ResponseEntity<String> insertTimer(Timer timer) {

		int num=0;
		try {
			num = timerService.insertTimer(timer);
		} catch (Exception e) {
			System.out.println(e);
		}
		if(num==0) 
			return new ResponseEntity<String>("timer insertion failed", HttpStatus.OK);
		else
			return new ResponseEntity<String>("timer inserted", HttpStatus.OK);
	}

	// 타이머 시간 변경
	@PutMapping("/timer")
	public ResponseEntity<String> updateTimer(Timer timer) {
		int num = 0;
		try {
			num = timerService.updateTimer(timer);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if(num==0) 
			return new ResponseEntity<String>("timer modify failed", HttpStatus.OK);
		else
			return new ResponseEntity<String>("timer modified", HttpStatus.OK);
	}
	
	//타이머 하나 삭제
	@DeleteMapping("/timer/{id}")
	public ResponseEntity<String> deleteOneTimer(@PathVariable("id") int id) {
		int num = 0;
		try {
			num = timerService.deleteOne(id);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<String>("timer delete failed", HttpStatus.OK);
		}
		
		if(num==0) 
			return new ResponseEntity<String>("timer delete failed", HttpStatus.OK);
		else
			return new ResponseEntity<String>("timer deleted", HttpStatus.OK);
	}

	// 내 타이머 다 삭제
	@DeleteMapping("/timer/all/{userid}")
	public ResponseEntity<String> deleteAllTimer(@PathVariable("userid") int userid) {
		int num = 0;
		try {
			num = timerService.deleteAll(userid);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<String>("alltimer delete failed", HttpStatus.OK);
		}
		
		if(num==0) 
			return new ResponseEntity<String>("alltimer delete failed", HttpStatus.OK);
		else
			return new ResponseEntity<String>("alltimer deleted", HttpStatus.OK);
	}
	
}
