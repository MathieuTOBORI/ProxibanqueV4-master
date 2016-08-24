package org.projet.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "compteCourant")
@Component
public  class CompteCourant extends CompteBancaire{
	
	private double authorisationDecouvert;

	public CompteCourant(double authorisationDecouvert) {
		super();
		this.authorisationDecouvert = authorisationDecouvert;
	}

	public CompteCourant() {
	
	}

	public double getAuthorisationDecouvert() {
		return authorisationDecouvert;
	}

	public void setAuthorisationDecouvert(double authorisationDecouvert) {
		this.authorisationDecouvert = authorisationDecouvert;
	}
	
	
	

}
