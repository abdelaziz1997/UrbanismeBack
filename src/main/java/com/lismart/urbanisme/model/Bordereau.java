package com.lismart.urbanisme.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bordereau {

	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "dossier")
	private Dossier dossier;

	public Bordereau() {
	}

	public Bordereau(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	
}
