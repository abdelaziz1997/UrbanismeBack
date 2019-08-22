package com.lismart.urbanisme.security.service;

import com.lismart.urbanisme.model.User;

import java.util.List;
import java.util.Optional;

public interface AccountService {
	public User saveUser(User user);
	public Boolean existsByUsername(String userName);
	public Boolean existsByEmail(String email);
	public void addRoleToUser(String userName, String strRole);
	public User findUserByUsername(String username);
	public List<User> retreiveUsers();
	public void deleteUser(Long id);
	public Optional<User> findUserById(Long id);
	User updateUser(User user);
}