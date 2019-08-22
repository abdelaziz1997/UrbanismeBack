package com.lismart.urbanisme.model;

import javax.persistence.*;

@Entity
public class Localisation {

	@Id @GeneratedValue
	private Long id;
	private String adresse;
	
	@OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "localisation")
	private Projet projet;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "surface_id")
	private Surface surface;
	
	public Localisation() {
	}
	public Localisation(String adresse) {
		super();
		this.adresse = adresse;
	}
	
	public Localisation(String adresse, Projet projet, Surface surface) {
		super();
		this.adresse = adresse;
		this.projet = projet;
		this.surface = surface;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public Surface getSurface() {
		return surface;
	}
	public void setSurface(Surface surface) {
		this.surface = surface;
	}
	
	
	
}
