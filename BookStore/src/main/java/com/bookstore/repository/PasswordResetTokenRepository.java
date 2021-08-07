package com.bookstore.repository;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bookstore.domain.User;
import com.bookstore.domain.security.PasswordResetToken;
import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

public interface PasswordResetTokenRepository extends JpaRepository< PasswordResetToken, Long> {
	
	PasswordResetToken findByToken( String token);
	PasswordResetToken findByuser(User user);
	Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date nowDate);

	@Modifying
	@Query("delete from PasswordResetToken t where t.expiryDate <= ?1")
	void deleteAllExpiredSince(Date nowDate);
	
	
	
}
