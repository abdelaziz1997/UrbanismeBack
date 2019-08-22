package com.lismart.urbanisme.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@DiscriminatorValue("3")
public class AdministrationPublique extends Proprietaire {

	
	private String denomination;
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "adm_phy", 
    	joinColumns = @JoinColumn(name = "adm_id"), 
    	inverseJoinColumns = @JoinColumn(name = "phy_id"))
	private Set<PersonnePhysique> representantAdmPhy = new HashSet<>();
	
	public AdministrationPublique() {
	}
	public AdministrationPublique(String denomination) {
		super();
		this.denomination = denomination;
	}
	
	public AdministrationPublique(String denomination, Set<PersonnePhysique> representant) {
		super();
		this.denomination = denomination;
		this.representantAdmPhy = representant;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public Set<PersonnePhysique> getPersonnePhysiques() {
		return representantAdmPhy;
	}
	public void setPersonnePhysiques(Set<PersonnePhysique> representant) {
		this.representantAdmPhy = representant;
	}
	
}
