package com.lismart.urbanisme.message.request;

import javax.validation.constraints.*;

public class SignUpForm {
	@NotBlank
    private String nom;
	
	@NotBlank
    private String prenom;

    @NotBlank
    private String username;

	@NotBlank
    @Size(max = 60)
    @Email
    private String email;
    
    private String role;
    
    @NotBlank
    @Size(min = 8)
    private String password;

    public String getNom() {
        return nom;
    }

    public void setName(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
    	return this.role;
    }
    
    public void setRole(String role) {
    	this.role = role;
    }
}

