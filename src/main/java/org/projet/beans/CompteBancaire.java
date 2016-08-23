package org.projet.beans;

public abstract class CompteBancaire {
	
	
	
	private long idCompte;
	private String dateOuverture;
	private double soldeCompte;

	
//	Constructeur par defaut
	public CompteBancaire() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getNumeroCompte() {
		return idCompte;
	}


	public void setNumeroCompte(long numeroCompte) {
		this.idCompte = numeroCompte;
	}


	public String getDateOuverture() {
		return dateOuverture;
	}


	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}


	public double getSoldeCompte() {
		return soldeCompte;
	}


	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}
	
	
	
	


}
