package com.lismart.urbanisme.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("2")
public class PersonneMorale extends Proprietaire {

	
	private String raisonSociale;
	private String RC;
	private String ICE;
	private String patante;
	private String adresse;
	private String codePostal;
	private String ville;
	private String pays;
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "mor_phy", 
    	joinColumns = @JoinColumn(name = "mor_id"), 
    	inverseJoinColumns = @JoinColumn(name = "phy_id"))
	private Set<PersonnePhysique> representantMorPhy = new HashSet<>();

	
	public PersonneMorale() {
	}
	public PersonneMorale(String raisonSociale, String rC, String iCE, String patante, String adresse,
			String codePostal, String ville, String pays) {
		super();
		this.raisonSociale = raisonSociale;
		RC = rC;
		ICE = iCE;
		this.patante = patante;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	public PersonneMorale(String raisonSociale, String rC, String iCE, String patante, String adresse,
			String codePostal, String ville, String pays, Set<PersonnePhysique> representant) {
		super();
		this.raisonSociale = raisonSociale;
		RC = rC;
		ICE = iCE;
		this.patante = patante;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.representantMorPhy = representant;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	public String getRC() {
		return RC;
	}
	public void setRC(String rC) {
		RC = rC;
	}
	public String getICE() {
		return ICE;
	}
	public void setICE(String iCE) {
		ICE = iCE;
	}
	public String getPatante() {
		return patante;
	}
	public void setPatante(String patante) {
		this.patante = patante;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public Set<PersonnePhysique> getRepresentant() {
		return representantMorPhy;
	}
	public void setRepresentant(Set<PersonnePhysique> representant) {
		this.representantMorPhy = representant;
	}
}
