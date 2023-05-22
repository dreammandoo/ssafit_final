package com.ssafy.board.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Message;
import com.ssafy.board.model.service.MessageService;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "메세지 컨트롤러")
public class MessageRestController {

	@Autowired
	private MessageService messageService;

	// 나의 메세지
	@GetMapping("/message/{id}")
	public ResponseEntity<?> myMessages(@PathVariable("id") int id) {
		List<Message> list = messageService.selectMy(id);
		if(list==null || list.size()==0)
			return new ResponseEntity<String>("no list", HttpStatus.OK);
		
		return new ResponseEntity<List<Message>>(list, HttpStatus.OK);
	}
	
	
	// 메세지 전송
	@PostMapping("/message")
	public ResponseEntity<String> sendMessage(Message message) {

		int num=0;
		try {
			num = messageService.sendMessage(message);
		} catch (Exception e) {
			System.out.println(e);
		}
		if(num==0) 
			return new ResponseEntity<String>("message send failed", HttpStatus.OK);
		else
			return new ResponseEntity<String>("message sent", HttpStatus.OK);
	}

	// 메세지 확인
	@PutMapping("/message")
	public ResponseEntity<String> checkMessage(Message message) {
		int num = messageService.checkMessage(message);
		
		if(num==0) 
			return new ResponseEntity<String>("message check failed", HttpStatus.OK);
		else
			return new ResponseEntity<String>("message checked", HttpStatus.OK);
	}

	
	
}
