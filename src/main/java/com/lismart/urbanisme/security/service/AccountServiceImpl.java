package com.lismart.urbanisme.security.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lismart.urbanisme.model.RoleName;
import com.lismart.urbanisme.model.User;
import com.lismart.urbanisme.repository.UserRepository;



@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public User saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}


	@Override
	public Boolean existsByUsername(String userName) {
		if(userRepository.findByUsername(userName) != null)
			return true;
		return false;
	}
	
	@Override
	public Boolean existsByEmail(String email) {
		if(userRepository.findByEmail(email) != null)
			return true;
		return false;
	}

	@Override
	public void addRoleToUser(String userName, String strRole) {
		User user = userRepository.findByUsername(userName);
		switch (strRole) {
			case "ROLE_ADMIN":
				user.setRole(RoleName.ROLE_ADMIN);
				break;
			case "ROLE_CHEF_DEP":
				user.setRole(RoleName.ROLE_CHEF_DEP);
				break;
			case "ROLE_CHEF_SRV":
				user.setRole(RoleName.ROLE_CHEF_SRV);
				break;
			case "ROLE_DIRECTEUR":
				user.setRole(RoleName.ROLE_DIRECTEUR);
				break;
			default: 
				System.err.println("Role non trouvé");
		}
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public Optional<User> findUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> retreiveUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}

