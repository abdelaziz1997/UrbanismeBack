package com.lismart.urbanisme.security.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lismart.urbanisme.model.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

    private String nom;
    
    private String prenom;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private GrantedAuthority authority;

    public UserPrinciple(Long id, String nom, String prenom, 
			    		String username, String email, String password, 
			    	    GrantedAuthority authority) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authority = authority;
    }

    public static UserPrinciple build(User user) {
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());

        return new UserPrinciple(
                user.getId(),
                user.getNom(),
                user.getPrenom(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authority
        );
    }

    public Long getId() {
        return id;
    }



    public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public GrantedAuthority getAuthority() {
		return authority;
	}

	public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	List <GrantedAuthority> authorities = new ArrayList<>();
    	authorities.add(this.authority);
        return authorities.stream().collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}