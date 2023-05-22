package com.ssafy.board.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {
	private static final String SALT = "SSAFIT";
	
	//억세스토큰생성
	public String createToken(String claimId, String data) throws UnsupportedEncodingException {
		return Jwts.builder()
				.setHeaderParam("alg", "HS256")
				.setHeaderParam("typ", "JWT") //헤더
				.claim(claimId, data)
				.setExpiration(new Date(System.currentTimeMillis()+5000)) //페이로드
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")) //서명
				.compact();
	}
	
	//토큰생성
//		public String createRefreshToken(String claimId, String data) throws UnsupportedEncodingException {
//			return Jwts.builder()
//					.setHeaderParam("alg", "HS256")
//					.setHeaderParam("typ", "JWT") //헤더
//					.setExpiration(new Date(System.currentTimeMillis()+900000)) //페이로드
//					.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")) //서명
//					.compact();
//		}
	
	// 유효성 검사
	public boolean valid(String token) {
		try {
			Jwts.parser().setSigningKey("SSAFIT".getBytes("UTF-8")).parseClaimsJws(token);
			return true;
		} catch (ExpiredJwtException e) {
			e.printStackTrace();
			return false;
		} catch (UnsupportedJwtException e) {
			e.printStackTrace();
			return false;
		} catch (MalformedJwtException e) {
			e.printStackTrace();
			return false;
		} catch (SignatureException e) {
			e.printStackTrace();
			return false;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
	}
}
