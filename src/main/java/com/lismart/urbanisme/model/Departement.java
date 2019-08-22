package com.lismart.urbanisme.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Departement {

	@Id @GeneratedValue
	private Long id;
	private String nom;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chefDep_id")
	private User chefDepartement;
	
    @ManyToOne
    @JoinColumn(name = "direction_id")
	private Direction direction;
    
	@OneToMany(mappedBy = "departement", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Service> services = new HashSet<>();

	
	public Departement() {
	}
	public Departement(String nom) {
		super();
		this.nom = nom;
	}
	
	public Departement(String nom, User chefDepartement, Direction direction, Set<Service> services) {
		super();
		this.nom = nom;
		this.chefDepartement = chefDepartement;
		this.direction = direction;
		this.services = services;
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
	public User getChefDepartement() {
		return chefDepartement;
	}
	public void setChefDepartement(User chefDepartement) {
		this.chefDepartement = chefDepartement;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public Set<Service> getServices() {
		return services;
	}
	public void setServices(Set<Service> services) {
		this.services = services;
	}
	
}
