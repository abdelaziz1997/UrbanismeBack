package com.lismart.urbanisme.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ReferencesFoncieres {

	@Id @GeneratedValue
	private Long id;
	private Long numero;
	private String type;
	private String indice;
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "ref_projet", 
    	joinColumns = @JoinColumn(name = "ref_id"), 
    	inverseJoinColumns = @JoinColumn(name = "projet_id"))
	private Set<Projet> projets = new HashSet<>();
	
	public ReferencesFoncieres() {
	}


	public ReferencesFoncieres(Long numero, String type, String indice) {
		super();
		this.numero = numero;
		this.type = type;
		this.indice = indice;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getNumero() {
		return numero;
	}


	public void setNumero(Long numero) {
		this.numero = numero;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getIndice() {
		return indice;
	}


	public void setIndice(String indice) {
		this.indice = indice;
	}
	
	
	
	
	
}
