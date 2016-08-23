package org.projet.beans;

public  class CompteCourant {
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
