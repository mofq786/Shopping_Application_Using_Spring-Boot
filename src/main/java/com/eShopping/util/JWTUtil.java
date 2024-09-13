package com.eShopping.util;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTUtil {
	
	 private String secretkey = "";

	    public JWTUtil() {

	        try {
	            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
	            SecretKey sk = keyGen.generateKey();
	            secretkey = Base64.getEncoder().encodeToString(sk.getEncoded());
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    public String generateToken(String username) {
	        Map<String, Object> claims = new HashMap<>();
	        return Jwts.builder()
	                .addClaims(claims)
	                .setSubject(username)
	                .setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 30))
	                .signWith(getKey())
	                .compact();

	    }

	    private Key getKey() {
	        byte[] keyBytes = Decoders.BASE64.decode(secretkey);
	        return Keys.hmacShaKeyFor(keyBytes);
	    }
}
