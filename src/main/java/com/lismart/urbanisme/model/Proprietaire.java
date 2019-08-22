package com.lismart.urbanisme.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="prop_type", 
  discriminatorType =DiscriminatorType.INTEGER)
public class Proprietaire {

	@Id @GeneratedValue
	private Long id;
	private Qualite qualite;
	private Boolean groupementCabinet;
	
	@ManyToOne
    @JoinColumn(name = "projet")
	private Projet projet;
	
	public Proprietaire() {
	}

	public Proprietaire(Qualite qualite, Boolean groupementCabinet) {
		super();
		this.qualite = qualite;
		this.groupementCabinet = groupementCabinet;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Qualite getQualite() {
		return qualite;
	}
	public void setQualite(Qualite qualite) {
		this.qualite = qualite;
	}

	public Boolean getGroupementCabinet() {
		return groupementCabinet;
	}

	public void setGroupementCabinet(Boolean groupementCabinet) {
		this.groupementCabinet = groupementCabinet;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
	
}
