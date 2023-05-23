package com.ssafy.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.board.util.JwtUtil;

@Component
public class JwtInterceptor implements HandlerInterceptor {
	private static final String HEADER_AUTH = "Authorization";
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
//		if(request.getMethod().contentEquals("OPTIONS"))
//			return true;
//		
//		String token = request.getHeader(HEADER_AUTH);
//		System.out.println(token);
//		if(token != null) {
//			if(jwtUtil.valid(token)) {
//				return true;
//			} else {
//				response.setStatus(401);
//				return false;
//			}
//		}
//		response.setStatus(401);
		return true;
	}
}
