package com.ssafy.board.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;
import com.ssafy.board.util.JwtUtil;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/user")
@Api(tags = "유저 컨트롤러")
public class UserRestController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserService userService;

	// 전체 유저목록
	@GetMapping("")
	public ResponseEntity<?> userList() {
		return new ResponseEntity<List<User>>(userService.getUserList(), HttpStatus.OK);
	}

	// 유저정보
	@GetMapping("/{id}")
	public ResponseEntity<?> userDetail(@PathVariable("id")int id) {
		User user = userService.getUserById(id);
		if(user == null)
			return new ResponseEntity<String>("no user found", HttpStatus.OK);
		else
			return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	// 회원가입을 해보자 (form data 형식으로 넘어왔다.
	@PostMapping("/signup")
	public ResponseEntity<String> signup(User user) {
		// 프론트에서 not null인 부분 제한 해주길 요망
		List<User> list = userService.getUserList();
		
		for(User u: list) {
			if(u.getLoginid().equals(user.getLoginid())) {
				return new ResponseEntity<String>("duplicated loginId", HttpStatus.OK);
			}
			if(u.getEmail().equals(user.getEmail())) {
				return new ResponseEntity<String>("duplicated email", HttpStatus.OK);
			}
			if(u.getNickname().equals(user.getNickname())) {
				return new ResponseEntity<String>("duplicated nickname", HttpStatus.OK);
			}
		}
		int num=0;
		try {
			num = userService.signup(user);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if(num==0)
			return new ResponseEntity<String>("regist failed", HttpStatus.OK);
		else
			return new ResponseEntity<String>("regist complete", HttpStatus.OK);
	}

	// 로그인 (실제 수행)
	@PostMapping("/login")
	public ResponseEntity<?> login(User user) throws UnsupportedEncodingException {
		
		List<User> list = userService.getUserList();
		
		int usercnt=0;
		for(User u:list) {
			if(u.getLoginid().equals(user.getLoginid())) {
				if(u.getPassword().equals(user.getPassword())) {
					
					Map<String, Object> result = new HashMap<String, Object>();
					result.put("access-token", jwtUtil.createToken("loginid",u.getLoginid()));
					result.put("user", u);
					result.put("message", "login success");
					return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
				}
				usercnt++;
			}
		}
		System.out.println(usercnt);
		if(usercnt==0)
			return new ResponseEntity<String>("wrong loginId", HttpStatus.OK);
		else
			return new ResponseEntity<String>("wrong password", HttpStatus.OK);
		
		
	}

	// 로그아웃
	@GetMapping("logout")
	public ResponseEntity<Void> logout(HttpSession session) {
//		session.removeAttribute("loginUser");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 회원탈퇴
	@DeleteMapping("{id}")
	public ResponseEntity<String> recruitDelete(@PathVariable("id") int id){
		int num = userService.deleteUser(id);
		if(num==0) 
			return new ResponseEntity<String>("user delete failed", HttpStatus.OK);
		else 
			return new ResponseEntity<String>("user deleted", HttpStatus.OK);
	}
	
	// 회원정보수정
	@PutMapping("")
	public ResponseEntity<String> updateDone(User user) {
		int num=0;
		try {
			num = userService.updateUser(user);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<String>("user modify failed", HttpStatus.OK);
		}
		
		if(num==0) 
			return new ResponseEntity<String>("user modify failed", HttpStatus.OK);
		else
			return new ResponseEntity<String>("user modified", HttpStatus.OK);
	}
	
}
