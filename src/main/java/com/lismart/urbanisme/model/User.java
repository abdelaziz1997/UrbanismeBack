package com.lismart.urbanisme.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.NaturalId;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_status", 
  discriminatorType =DiscriminatorType.INTEGER)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String nom;
    
    @NotBlank
    @Size( max = 50)
    private String prenom;
    
    @NotBlank
    @Size( max = 50)
    @Column(unique = true)
    private String username;

    @NaturalId(mutable=true)
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    @Email
    private String email;

    @NotBlank
    @Size(min=8, max = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private RoleName role;

    public User() {}

    

    public User(String nom, String prenom, String username, String email, String password, String strRole) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = RoleName.valueOf(strRole);
    }



    public String getNom() {
        return nom;
    }



    public void setNom(String nom) {
        this.nom = nom;
    }



    public String getPrenom() {
        return prenom;
    }



    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



    public RoleName getRole() {
        return role;
    }



    public void setRole(RoleName role) {
        this.role = role;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
