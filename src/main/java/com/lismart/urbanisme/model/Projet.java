package com.lismart.urbanisme.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Projet {

	@Id @GeneratedValue
	private Long id;
	private String nom_ar;
	private String nom_fr;
	private String objet_ar;
	private String objet_fr;
	private NbrNiveaux nbr_niveaux;
	private NatureProjet nature;
	private CategorieProjet categorie;
	private TypeProjet type;
	
	@OneToOne
	@JoinColumn(name = "dossier")
	private Dossier dossier;
	
	@OneToOne
	@JoinColumn(name = "localisation")
	private Localisation localisation;
	
	@OneToOne
	@JoinColumn(name = "detailEstimatif")
	private DetailEstimatif detailEstimatif;

	@ManyToMany(mappedBy = "projets")
	private Set<Ingenieur> ingenieurs = new HashSet<>();

	private String[] references ;

	@OneToMany(mappedBy = "projet")
	private Set<Proprietaire> proprietaires = new HashSet<>();
    
	
	public Projet() {
	}
	public Projet(String nom_ar, String objet_ar,String nom_fr, String objet_fr, NbrNiveaux nbr_niveaux, NatureProjet nature, CategorieProjet categorie,
			TypeProjet type) {
		super();
		this.nom_ar = nom_ar;
		this.objet_ar = objet_ar;
		this.nom_fr = nom_fr;
		this.objet_fr = objet_fr;
		this.nbr_niveaux = nbr_niveaux;
		this.nature = nature;
		this.categorie = categorie;
		this.type = type;
	}
	
	public Projet(String nom_ar, String objet_ar,String nom_fr, String objet_fr, NbrNiveaux nbr_niveaux, NatureProjet nature, CategorieProjet categorie,
			TypeProjet type, Dossier dossier, Localisation localisation, DetailEstimatif detailEstimatif,
			Set<Ingenieur> ingenieurs, String[] referencesFoncieres,
			Set<Proprietaire> proprietaires) {
		super();
		this.nom_ar = nom_ar;
		this.objet_ar = objet_ar;
		this.nom_fr = nom_fr;
		this.objet_fr = objet_fr;
		this.nbr_niveaux = nbr_niveaux;
		this.nature = nature;
		this.categorie = categorie;
		this.type = type;
		this.dossier = dossier;
		this.localisation = localisation;
		this.detailEstimatif = detailEstimatif;
		this.ingenieurs = ingenieurs;
		this.references = referencesFoncieres;
		this.proprietaires = proprietaires;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public NbrNiveaux getNbr_niveaux() {
		return nbr_niveaux;
	}
	public void setNbr_niveaux(NbrNiveaux nbr_niveaux) {
		this.nbr_niveaux = nbr_niveaux;
	}
	public NatureProjet getNature() {
		return nature;
	}
	public void setNature(NatureProjet nature) {
		this.nature = nature;
	}
	public CategorieProjet getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieProjet categorie) {
		this.categorie = categorie;
	}
	public TypeProjet getType() {
		return type;
	}
	public void setType(TypeProjet type) {
		this.type = type;
	}
	public Dossier getDossier() {
		return dossier;
	}
	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	public Localisation getLocalisation() {
		return localisation;
	}
	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}
	public DetailEstimatif getDetailEstimatif() {
		return detailEstimatif;
	}
	public void setDetailEstimatif(DetailEstimatif detailEstimatif) {
		this.detailEstimatif = detailEstimatif;
	}
	public Set<Ingenieur> getIngenieurs() {
		return ingenieurs;
	}
	public void setIngenieurs(Set<Ingenieur> ingenieurs) {
		this.ingenieurs = ingenieurs;
	}
	public String[]  getReferencesFoncieres() {
		return references;
	}
	public void setReferencesFoncieres(String[] referencesFoncieres) {
		this.references = referencesFoncieres;
	}
	public Set<Proprietaire> getProprietaires() {
		return proprietaires;
	}
	public void setProprietaires(Set<Proprietaire> proprietaires) {
		this.proprietaires = proprietaires;
	}
	public String getNom_ar() {
		return nom_ar;
	}
	public void setNom_ar(String nom_ar) {
		this.nom_ar = nom_ar;
	}
	public String getNom_fr() {
		return nom_fr;
	}
	public void setNom_fr(String nom_fr) {
		this.nom_fr = nom_fr;
	}
	public String getObjet_ar() {
		return objet_ar;
	}
	public void setObjet_ar(String objet_ar) {
		this.objet_ar = objet_ar;
	}
	public String getObjet_fr() {
		return objet_fr;
	}
	public void setObjet_fr(String objet_fr) {
		this.objet_fr = objet_fr;
	}
	
	
}
