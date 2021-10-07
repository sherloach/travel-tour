package com.nqhtour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nqhtour.entity.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	// Khong can find password vi Spring security da tu dong lam buoc xac thuc pass truoc roi (bcrypt pass)
	UserEntity findOneByUserNameAndStatus(String name, int status);
	List<UserEntity> findAllByRole(String role);
}
