package com.lismart.urbanisme.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Demande {

	@Id @GeneratedValue
	private Long id;
	private String reference;
	@Temporal(TemporalType.DATE)
	private Date date_depot;
	private String status;
	private String plan;
	
	@ManyToOne
    @JoinColumn(name = "demandeur")
	@JsonBackReference
	private Demandeur demandeur;
	
	@ManyToOne
    @JoinColumn(name = "service")
	private Service service;
	
	@OneToOne
    @JoinColumn(name = "dossier")
	private Dossier dossier;
	
	public Demande() {
	}
	public Demande(String reference, Date date_depot, String status, String plan) {
		super();
		this.reference = reference;
		this.date_depot = date_depot;
		this.status = status;
		this.plan = plan;
	}
	
	public Demande(String reference, Date date_depot, String status, String plan, Demandeur demandeur, Service service,
			Dossier dossier) {
		super();
		this.reference = reference;
		this.date_depot = date_depot;
		this.status = status;
		this.plan = plan;
		this.demandeur = demandeur;
		this.service = service;
		this.dossier = dossier;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Date getDate_depot() {
		return date_depot;
	}
	public void setDate_depot(Date date_depot) {
		this.date_depot = date_depot;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public Demandeur getDemandeur() {
		return demandeur;
	}
	public void setDemandeur(Demandeur demandeur) {
		this.demandeur = demandeur;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Dossier getDossier() {
		return dossier;
	}
	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	
	
}
