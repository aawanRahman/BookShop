package com.bookstore.domain.security;



import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.bookstore.domain.User;

@Entity
public class PasswordResetToken {
	private static final int Expiration = 60*24;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String token;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false , name = "user_id")
	private User user;

	private Date expiryDate;
	public PasswordResetToken(final String token, final User user) {
		// TODO Auto-generated constructor stub
		super();
		this.token = token ;
		this.user= user ;
		this.expiryDate = CalculateExpiryDate( Expiration );
	}
	private Date CalculateExpiryDate(int expirationTime) { // expirationTime in minutes..............
		// TODO Auto-generated method stub
		final Calendar calendar = Calendar.getInstance() ;
		calendar.setTimeInMillis(new Date().getTime());
		calendar.add(calendar.MINUTE, expirationTime);
		return new Date(calendar.getTime().getTime());
		
		
	}
}

