package org.projet.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "CompteBancaire.searchByConseiller", query = "select o from CompteBancaire o"), })
public abstract class CompteBancaire {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCompte;
	private String dateOuverture;
	private double soldeCompte;
	
	private long idClient;

	@ManyToOne
	private ClientTest client;
	
	public long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(long idCompte) {
		this.idCompte = idCompte;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	// Constructeur par defaut
	public CompteBancaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteBancaire(long idCompte, String dateOuverture, double soldeCompte, long idClient) {
		super();
		this.idCompte = idCompte;
		this.dateOuverture = dateOuverture;
		this.soldeCompte = soldeCompte;
		this.idClient = idClient;
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
