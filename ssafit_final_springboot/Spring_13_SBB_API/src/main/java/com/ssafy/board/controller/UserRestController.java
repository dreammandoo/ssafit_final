package com.ssafy.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/user")
@Api(tags = "유저 컨트롤러")
public class UserRestController {

	@Autowired
	private UserService userService;

	// 전체 유저목록 가져와~~
	@GetMapping("")
	public List<User> userList() {
		return userService.getUserList();
	}

	// 회원가입을 해보자 (form data 형식으로 넘어왔다.
	@PostMapping("/signup")
	public ResponseEntity<String> signup(User user) {
		// 프론트에서 not null인 부분 제한 해주길 요망
		User result = userService.signup(user);
		
		return new ResponseEntity<String>(result.getLoginid()+" 계정이 등록되었습니다.", HttpStatus.CREATED);
	}

	// 로그인 (실제 수행)
	@PostMapping("/login")
	public ResponseEntity<?> login(User user, HttpSession session) {
		User tmp = userService.login(user.getLoginid(), user.getPassword());
		if(tmp == null) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		session.setAttribute("loginUser", tmp);
		return new ResponseEntity<String>(tmp.getNickname(), HttpStatus.OK);
	}

	// 로그아웃
	@GetMapping("logout")
	public ResponseEntity<Void> logout(HttpSession session) {
//		session.removeAttribute("loginUser");
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
