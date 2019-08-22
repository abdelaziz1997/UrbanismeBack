package com.lismart.urbanisme.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {
	
	@GetMapping("/api/test/chefService")
	@PreAuthorize("hasRole('ROLE_CHEF_SRV')")
	public String chefSrvAccess() {
		return ">>> CHEF DE SERVICE";
	}

	@GetMapping("/api/test/chefDepartement")
	@PreAuthorize("hasRole('ROLE_CHEF_DEP')")
	public String chefDepAccess() {
		return ">>> Chef de département";
	}
	
	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminAccess() {
		return ">>> Admin";
	}
	
	@GetMapping("/api/test/directeur")
	@PreAuthorize("hasRole('ROLE_DIRECTEUR')")
	public String directeurAccess() {
		return ">>> directeur";
	}
}