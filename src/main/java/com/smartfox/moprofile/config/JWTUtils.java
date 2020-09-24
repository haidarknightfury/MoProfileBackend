package com.smartfox.moprofile.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtils {

	
	private String jwtSecret;
	private Integer jwtExpirationMs;

	public JWTUtils(@Value("${moprofile.app.jwtSecret}") String jwtSecret,
			        @Value("${moprofile.app.jwtExpiration}") Integer jwtExpirationMs) {
		this.jwtSecret = jwtSecret;
		this.jwtExpirationMs = jwtExpirationMs;
	};
	
	
	public String generateJWTToken(Authentication authentication) {
		MoProfileUser userPrincipal  = (MoProfileUser) authentication.getPrincipal();
		return Jwts.builder().setSubject(userPrincipal.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date( new Date().getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, this.jwtSecret)
				.compact();
	}
	
	
	public String getUserNameFromJWTToken(String token) {
		return Jwts.parser().setSigningKey(this.jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public Boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(this.jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (Exception e) {
			System.out.println("An error ocurred "+ e.getMessage());
			return false;
		}
	}
	
	
	
}
