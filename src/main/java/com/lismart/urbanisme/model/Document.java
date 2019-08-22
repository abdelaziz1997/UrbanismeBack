package com.lismart.urbanisme.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Document {

	@Id @GeneratedValue
    private Long id;
	private Date date_depot;
	private String chemin;
	
	@ManyToOne
    @JoinColumn(name = "dossier")
    private Dossier dossier;
    
	public Document() {
	}
	
	public Document(Date date_depot, String chemin) {
		super();
		this.date_depot = date_depot;
		this.chemin = chemin;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate_depot() {
		return date_depot;
	}
	public void setDate_depot(Date date_depot) {
		this.date_depot = date_depot;
	}
	public String getChemin() {
		return chemin;
	}
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	
      
      
      
}
