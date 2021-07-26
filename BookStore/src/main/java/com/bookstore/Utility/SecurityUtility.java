package com.bookstore.Utility;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtility {
	private static final String SALT = "salt";
	
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12,new SecureRandom(SALT.getBytes()));
		
	}
	
	@Bean
	public static String randomPassword() {
		String SALTCHAR = "1234567890QWERTYUIOPASDFGHJKLMNBVCXZ";
		StringBuilder saltBuilder = new StringBuilder();
		Random random = new Random();
		while(saltBuilder.length() <18) {
			
			int index = 	(int) (random.nextFloat()*SALTCHAR.length());
			saltBuilder.append(SALTCHAR.charAt(index));
			
			
		}
		
		return saltBuilder.toString();
		
		
		
	}

}
