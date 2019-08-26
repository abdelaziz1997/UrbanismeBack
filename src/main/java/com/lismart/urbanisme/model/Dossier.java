package com.lismart.urbanisme.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Dossier {

	@Id @GeneratedValue
	private Long id;
	private String numero;
	private String etat;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_depot;
	
	@OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "dossier")
	private Demande demande;
	
	@OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "dossier")
	private Projet projet; 
	
	@OneToMany(mappedBy = "dossier", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Document> documents = new HashSet<>();
	
	@OneToMany(mappedBy = "dossier", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Bordereau> bordereaux = new HashSet<>();

	public Dossier() {
	}
	public Dossier(String numero, String etat, Date date_depot) {
		super();
		this.numero = numero;
		this.etat = etat;
		this.date_depot = date_depot;
	}
	
	public Dossier(String numero, String etat, Date date_depot, Demande demande, Projet projet, Set<Document> documents,
			Set<Bordereau> bordereaux) {
		super();
		this.numero = numero;
		this.etat = etat;
		this.date_depot = date_depot;
		this.demande = demande;
		this.projet = projet;
		this.documents = documents;
		this.bordereaux = bordereaux;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Date getDate_depot() {
		return date_depot;
	}
	public void setDate_depot(Date date_depot) {
		this.date_depot = date_depot;
	}
	public Demande getDemande() {
		return demande;
	}
	public void setDemande(Demande demande) {
		this.demande = demande;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public Set<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}
	public Set<Bordereau> getBordereaux() {
		return bordereaux;
	}
	public void setBordereaux(Set<Bordereau> bordereaux) {
		this.bordereaux = bordereaux;
	}
	
	
	
	
	
}
