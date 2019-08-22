package com.lismart.urbanisme.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Direction {

	@Id @GeneratedValue
	private Long id;
	private String nom;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "directeur_id")
	private User directeur;
	
	@OneToMany(mappedBy = "direction", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Departement> departements = new HashSet<>();
	
	public Direction() {
	}
	public Direction(String nom) {
		super();
		this.nom = nom;
	}
	
	public Direction(String nom, User directeur, Set<Departement> departements) {
		super();
		this.nom = nom;
		this.directeur = directeur;
		this.departements = departements;
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
	public User getDirecteur() {
		return directeur;
	}
	public void setDirecteur(User directeur) {
		this.directeur = directeur;
	}
	public Set<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(Set<Departement> departements) {
		this.departements = departements;
	}
	
}
