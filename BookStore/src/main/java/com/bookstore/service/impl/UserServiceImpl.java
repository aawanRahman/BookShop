package com.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.User;
import com.bookstore.domain.security.PasswordResetToken;
import com.bookstore.repository.PasswordResetTokenRepository;
import com.bookstore.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;

	@Override
	public PasswordResetToken gePasswordResetToken(String token) {
		// TODO Auto-generated method stub
		return passwordResetTokenRepository.findByToken(token); 
		//return null;
	}

	@Override
	public void passwordResetToken(User user, String token) {
		// TODO Auto-generated method stub
		final PasswordResetToken newToken = new PasswordResetToken(token, user);
		passwordResetTokenRepository.save(newToken);
		
	}

}
 