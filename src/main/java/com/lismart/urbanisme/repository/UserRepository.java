package com.lismart.urbanisme.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lismart.urbanisme.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	User findByEmail(String email);
}
