package com.lismart.urbanisme.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Projet {

	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String objet;
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

	@ManyToMany(mappedBy = "projets")
	private Set<ReferencesFoncieres> referencesFoncieres = new HashSet<>();

	@OneToMany(mappedBy = "projet")
	private Set<Proprietaire> proprietaires = new HashSet<>();
    
	
	public Projet() {
	}
	public Projet(String nom, String objet, NbrNiveaux nbr_niveaux, NatureProjet nature, CategorieProjet categorie,
			TypeProjet type) {
		super();
		this.nom = nom;
		this.objet = objet;
		this.nbr_niveaux = nbr_niveaux;
		this.nature = nature;
		this.categorie = categorie;
		this.type = type;
	}
	
	public Projet(String nom, String objet, NbrNiveaux nbr_niveaux, NatureProjet nature, CategorieProjet categorie,
			TypeProjet type, Dossier dossier, Localisation localisation, DetailEstimatif detailEstimatif,
			Set<Ingenieur> ingenieurs, Set<ReferencesFoncieres> referencesFoncieres,
			Set<Proprietaire> proprietaires) {
		super();
		this.nom = nom;
		this.objet = objet;
		this.nbr_niveaux = nbr_niveaux;
		this.nature = nature;
		this.categorie = categorie;
		this.type = type;
		this.dossier = dossier;
		this.localisation = localisation;
		this.detailEstimatif = detailEstimatif;
		this.ingenieurs = ingenieurs;
		this.referencesFoncieres = referencesFoncieres;
		this.proprietaires = proprietaires;
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
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
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
	public Set<ReferencesFoncieres> getReferencesFoncieres() {
		return referencesFoncieres;
	}
	public void setReferencesFoncieres(Set<ReferencesFoncieres> referencesFoncieres) {
		this.referencesFoncieres = referencesFoncieres;
	}
	public Set<Proprietaire> getProprietaires() {
		return proprietaires;
	}
	public void setProprietaires(Set<Proprietaire> proprietaires) {
		this.proprietaires = proprietaires;
	}
	
	
}
