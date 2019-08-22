package com.lismart.urbanisme.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("1")
public class Directeur extends User {
    
	
	@OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "directeur")
	private Direction direction;
	
	public Directeur() {}
	
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	
}
