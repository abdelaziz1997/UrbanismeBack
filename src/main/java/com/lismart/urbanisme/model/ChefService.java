package com.lismart.urbanisme.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("3")
public class ChefService extends User {
	
	@OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "chefService")
	private Service service;
	
	public ChefService() {
	}

	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
}
