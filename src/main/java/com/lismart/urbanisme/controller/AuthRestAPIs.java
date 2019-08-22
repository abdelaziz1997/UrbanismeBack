package com.lismart.urbanisme.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lismart.urbanisme.message.request.LoginForm;
import com.lismart.urbanisme.message.request.SignUpForm;
import com.lismart.urbanisme.message.response.JwtResponse;
import com.lismart.urbanisme.message.response.ResponseMessage;
import com.lismart.urbanisme.model.User;
import com.lismart.urbanisme.security.jwt.JwtProvider;
import com.lismart.urbanisme.security.service.AccountService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private AccountService accountService;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		System.out.println("User ===> nom d'utilisateur:"+userDetails.getUsername()+" est connecté.");
		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		String userName = signUpRequest.getUsername();
		
		if (accountService.existsByUsername(userName)) {
			return new ResponseEntity<>(new ResponseMessage("Nom d'utilisateur déja existe!"),
					HttpStatus.BAD_REQUEST);
		}

		if (accountService.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Email déja existe!"),
					HttpStatus.BAD_REQUEST);
		}
		
		accountService.saveUser(new User(signUpRequest.getNom(),signUpRequest.getPrenom(),userName,signUpRequest.getEmail(),signUpRequest.getPassword(), signUpRequest.getRole()));
		accountService.addRoleToUser(userName, signUpRequest.getRole());
		
		return new ResponseEntity<>(new ResponseMessage("Compte créé avec succée!"), HttpStatus.OK);
	}

	
	
}
