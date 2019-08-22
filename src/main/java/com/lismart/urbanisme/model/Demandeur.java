package com.lismart.urbanisme.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Demandeur {

	@Id @GeneratedValue
	private Long id;
	private String nomDemandeur_ar;
	private String nomDemandeur_fr;
	private String preDemandeur_ar;
	private String preDemandeur_fr;
	private String qualite_ar;
	private String qualite_fr;
	
	@OneToMany(mappedBy = "demandeur", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Demande> demandes = new HashSet<>();
	
	public Demandeur() {
	}

	public Demandeur(String nomDemandeur_ar, String nomDemandeur_fr, String preDemandeur_ar, String preDemandeur_fr,
			String qualite_ar, String qualite_fr) {
		super();
		this.nomDemandeur_ar = nomDemandeur_ar;
		this.nomDemandeur_fr = nomDemandeur_fr;
		this.preDemandeur_ar = preDemandeur_ar;
		this.preDemandeur_fr = preDemandeur_fr;
		this.qualite_ar = qualite_ar;
		this.qualite_fr = qualite_fr;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomDemandeur_ar() {
		return nomDemandeur_ar;
	}

	public void setNomDemandeur_ar(String nomDemandeur_ar) {
		this.nomDemandeur_ar = nomDemandeur_ar;
	}

	public String getNomDemandeur_fr() {
		return nomDemandeur_fr;
	}

	public void setNomDemandeur_fr(String nomDemandeur_fr) {
		this.nomDemandeur_fr = nomDemandeur_fr;
	}

	public String getPreDemandeur_ar() {
		return preDemandeur_ar;
	}

	public void setPreDemandeur_ar(String preDemandeur_ar) {
		this.preDemandeur_ar = preDemandeur_ar;
	}

	public String getPreDemandeur_fr() {
		return preDemandeur_fr;
	}

	public void setPreDemandeur_fr(String preDemandeur_fr) {
		this.preDemandeur_fr = preDemandeur_fr;
	}

	public String getQualite_ar() {
		return qualite_ar;
	}

	public void setQualite_ar(String qualite_ar) {
		this.qualite_ar = qualite_ar;
	}

	public String getQualite_fr() {
		return qualite_fr;
	}

	public void setQualite_fr(String qualite_fr) {
		this.qualite_fr = qualite_fr;
	}

	public Set<Demande> getDemandes() {
		return demandes;
	}
	public void setDemandes(Set<Demande> demandes) {
		this.demandes = demandes;
	}
	
}
