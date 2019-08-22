package com.lismart.urbanisme.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Ingenieur {

	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "ing_projet", 
    	joinColumns = @JoinColumn(name = "ing_id"), 
    	inverseJoinColumns = @JoinColumn(name = "projet_id"))
	private Set<Projet> projets = new HashSet<>();
	
	public Ingenieur() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Ingenieur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public Set<Projet> getProjets() {
		return projets;
	}
	public void setProjets(Set<Projet> projets) {
		this.projets = projets;
	}
	
	
}
