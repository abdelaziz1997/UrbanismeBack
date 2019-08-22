package com.lismart.urbanisme.model;

import javax.persistence.*;

@Entity
public class Surface {

	@Id @GeneratedValue
	private Long id;
	private Double surfaceTerrain;
	private Double surfaceBatie;
	private Double surfacePlancher;
	private Double cus;
	private Double cos;
	private Double x;
	private Double y;
	
	@OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "surface")
	private Localisation localisation;
	
	public Surface() {
	}
	public Surface(Double surfaceTerrain, Double surfaceBatie, Double surfacePlancher, Double cus, Double cos, Double x,
			Double y) {
		super();
		this.surfaceTerrain = surfaceTerrain;
		this.surfaceBatie = surfaceBatie;
		this.surfacePlancher = surfacePlancher;
		this.cus = cus;
		this.cos = cos;
		this.x = x;
		this.y = y;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getSurfaceTerrain() {
		return surfaceTerrain;
	}
	public void setSurfaceTerrain(Double surfaceTerrain) {
		this.surfaceTerrain = surfaceTerrain;
	}
	public Double getSurfaceBatie() {
		return surfaceBatie;
	}
	public void setSurfaceBatie(Double surfaceBatie) {
		this.surfaceBatie = surfaceBatie;
	}
	public Double getSurfacePlancher() {
		return surfacePlancher;
	}
	public void setSurfacePlancher(Double surfacePlancher) {
		this.surfacePlancher = surfacePlancher;
	}
	public Double getCus() {
		return cus;
	}
	public void setCus(Double cus) {
		this.cus = cus;
	}
	public Double getCos() {
		return cos;
	}
	public void setCos(Double cos) {
		this.cos = cos;
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	
	
}
