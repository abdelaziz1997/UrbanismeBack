package com.lismart.urbanisme.message.request;

import java.util.Date;


public class CreationDossierForm {
	private String nomDemandeur_ar;
	private String nomDemandeur_fr;
	private String preDemandeur_ar;
	private String preDemandeur_fr;
	private String qualite_ar;
	private String qualite_fr;
	private String reference;
	private Date date_depot;
	private String status;
	private String plan;
	public CreationDossierForm(String nomDemandeur_ar, String nomDemandeur_fr, String preDemandeur_ar,
			String preDemandeur_fr, String qualite_ar, String qualite_fr, String reference, Date date_depot,
			String status, String plan) {
		super();
		this.nomDemandeur_ar = nomDemandeur_ar;
		this.nomDemandeur_fr = nomDemandeur_fr;
		this.preDemandeur_ar = preDemandeur_ar;
		this.preDemandeur_fr = preDemandeur_fr;
		this.qualite_ar = qualite_ar;
		this.qualite_fr = qualite_fr;
		this.reference = reference;
		this.date_depot = date_depot;
		this.status = status;
		this.plan = plan;
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
	
}
