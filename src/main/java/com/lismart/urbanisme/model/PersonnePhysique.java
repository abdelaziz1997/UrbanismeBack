package com.lismart.urbanisme.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("1")
public class PersonnePhysique extends Proprietaire {
    
	
	private String nom;
	private String prenom;
	private String civilite;
	private String numCin_passport_titreSejour;
	private String lieuDelivrancePieceId;
	@Temporal(TemporalType.DATE)
	private Date dateFinValidId;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String lieuNaissance;
	private String nationalite;
	private String profession;
	private String nomPere;
	private String nomMere;
	private String email;
	private String telephone;
	private String adresse;
	private String codePostal;
	private String ville;
	private String pays;
	
	private Boolean representant;
	
	@ManyToMany(mappedBy = "representantMorPhy")
	private Set<PersonneMorale> personneMorale = new HashSet<>();
	
	@ManyToMany(mappedBy = "representantAdmPhy")
	private Set<AdministrationPublique> administrationPublique = new HashSet<>();
	
	public PersonnePhysique() {
	}
	public PersonnePhysique(String nom, String prenom, String civilite, String numCin_passport_titreSejour,
			String lieuDelivrancePieceId, Date dateFinValidId, Date dateNaissance, String lieuNaissance,
			String nationalite, String profession, String nomPere, String nomMere, String email, String telephone,
			String adresse, String codePostal, String ville, String pays) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
		this.numCin_passport_titreSejour = numCin_passport_titreSejour;
		this.lieuDelivrancePieceId = lieuDelivrancePieceId;
		this.dateFinValidId = dateFinValidId;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.nationalite = nationalite;
		this.profession = profession;
		this.nomPere = nomPere;
		this.nomMere = nomMere;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
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
	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public String getNumCin_passport_titreSejour() {
		return numCin_passport_titreSejour;
	}
	public void setNumCin_passport_titreSejour(String numCin_passport_titreSejour) {
		this.numCin_passport_titreSejour = numCin_passport_titreSejour;
	}
	public String getLieuDelivrancePieceId() {
		return lieuDelivrancePieceId;
	}
	public void setLieuDelivrancePieceId(String lieuDelivrancePieceId) {
		this.lieuDelivrancePieceId = lieuDelivrancePieceId;
	}
	public Date getDateFinValidId() {
		return dateFinValidId;
	}
	public void setDateFinValidId(Date dateFinValidId) {
		this.dateFinValidId = dateFinValidId;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getNomPere() {
		return nomPere;
	}
	public void setNomPere(String nomPere) {
		this.nomPere = nomPere;
	}
	public String getNomMere() {
		return nomMere;
	}
	public void setNomMere(String nomMere) {
		this.nomMere = nomMere;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public Boolean getRepresentant() {
		return representant;
	}
	public void setRepresentant(Boolean representant) {
		this.representant = representant;
	}
	public Set<PersonneMorale> getPersonneMorale() {
		return personneMorale;
	}
	public void setPersonneMorale(Set<PersonneMorale> personneMorale) {
		this.personneMorale = personneMorale;
	}
	public Set<AdministrationPublique> getAdministrationPublique() {
		return administrationPublique;
	}
	public void setAdministrationPublique(Set<AdministrationPublique> administrationPublique) {
		this.administrationPublique = administrationPublique;
	}
	
	
}
