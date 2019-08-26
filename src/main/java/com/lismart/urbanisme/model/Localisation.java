package com.lismart.urbanisme.model;

import javax.persistence.*;

@Entity
public class Localisation {

	@Id @GeneratedValue
	private Long id;
	private String adresse_ar;
	private String adresse_fr;
	@OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "localisation")
	private Projet projet;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "surface_id")
	private Surface surface;
	
	public Localisation() {
	}
	public Localisation(String adresse_ar,String adresse_fr) {
		super();
		this.adresse_ar = adresse_ar;
		this.adresse_fr = adresse_fr;
	}
	
	
	public Localisation(String adresse_ar,String adresse_fr, Projet projet, Surface surface) {
		super();
		this.adresse_ar = adresse_ar;
		this.adresse_fr = adresse_fr;
		this.projet = projet;
		this.surface = surface;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getAdresse_ar() {
		return adresse_ar;
	}
	public void setAdresse_ar(String adresse_ar) {
		this.adresse_ar = adresse_ar;
	}
	public String getAdresse_fr() {
		return adresse_fr;
	}
	public void setAdresse_fr(String adresse_fr) {
		this.adresse_fr = adresse_fr;
	}
	
	
	
}
