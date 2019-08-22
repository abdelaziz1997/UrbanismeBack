package com.lismart.urbanisme.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lismart.urbanisme.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	AccountService accountService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = accountService.findUserByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("User Not Found with -> username or email : " + username);

		return UserPrinciple.build(user);
	}
}