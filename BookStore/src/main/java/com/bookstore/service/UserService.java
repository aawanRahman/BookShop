package com.bookstore.service;

import com.bookstore.domain.User;
import com.bookstore.domain.security.PasswordResetToken;

public interface UserService {
	PasswordResetToken gePasswordResetToken(final String token);
	
	void passwordResetToken(final User user, final String token);
	

}
