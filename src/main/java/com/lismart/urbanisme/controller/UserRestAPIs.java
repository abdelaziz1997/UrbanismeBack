package com.lismart.urbanisme.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lismart.urbanisme.message.request.SignUpForm;
import com.lismart.urbanisme.message.response.ResponseMessage;
import com.lismart.urbanisme.model.User;
import com.lismart.urbanisme.security.service.AccountService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserRestAPIs {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/utilisateurs")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<User> listUtilisateurs(){
		return accountService.retreiveUsers();
	}
	@RequestMapping(value="/utilisateurs/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Optional<User> getUser( @PathVariable long id){
		return accountService.findUserById(id);
	}
	@RequestMapping(value="/utilisateur/{username}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User getUserByUsername( @PathVariable  String username){
		return accountService.findUserByUsername(username);
	}
	@RequestMapping(value="/{email}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean getUserByEmail( @PathVariable  String email){
		System.out.println("fffffffff "+accountService.existsByEmail(email));
		return accountService.existsByEmail(email);
	}
	
	@RequestMapping(value="/saveUser",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		String userName = signUpRequest.getUsername();
		
		if (accountService.existsByUsername(userName)) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (accountService.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}
		
		accountService.saveUser(new User(signUpRequest.getNom(),signUpRequest.getPrenom(),userName,
				signUpRequest.getEmail(),signUpRequest.getPassword(), signUpRequest.getRole()));
		System.out.println("*****ROLES: "+signUpRequest.getRole());
		accountService.addRoleToUser(userName, signUpRequest.getRole());
		
		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateUser/{id}",method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> updateUser(@Valid @RequestBody SignUpForm signUpRequest, @PathVariable long id) {
		System.out.println("*****ROLES: "+signUpRequest.getRole());
		Optional<User> userOptional = accountService.findUserById(id);
    
		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();
    
		User user = new User(signUpRequest.getNom(),signUpRequest.getPrenom(),signUpRequest.getUsername(),
				signUpRequest.getEmail(),signUpRequest.getPassword(), signUpRequest.getRole());
		
		user.setId(id);
		
		accountService.updateUser(user);
		System.out.println("*****ROLES: "+signUpRequest.getRole());
		accountService.addRoleToUser(signUpRequest.getUsername(), signUpRequest.getRole());
    
		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteUser/{id}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(@PathVariable("id") Long id) {
		accountService.deleteUser(id);
	}
}
