package com.lismart.urbanisme.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Service {

	@Id @GeneratedValue
	private Long id;
	private String nom;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chefSer_id")
	private User chefService;
    
	@ManyToOne
	@JoinColumn(name = "departement_id")
	private Departement departement;
	
	@OneToMany(mappedBy = "service")
	private Set<Demande> demandes = new HashSet<>();

	public Service() {
	}
	public Service(String nom) {
		super();
		this.nom = nom;
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
	public User getChefService() {
		return chefService;
	}
	public void setChefService(User chefService) {
		this.chefService = chefService;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public Set<Demande> getDemandes() {
		return demandes;
	}
	public void setDemandes(Set<Demande> demandes) {
		this.demandes = demandes;
	}
	
}
