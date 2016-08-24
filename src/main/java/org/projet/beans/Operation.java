package org.projet.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idOperation;
	
	private String dateOperation;
	private double montant;
	private CompteBancaire compte;
	private ConseillerClientTest conseillerClient;

	// ConstructorExecutor par defaut
	public Operation() {
	}

	// Constructeur Completr
	public Operation(long idOperation, String dateOperation, double montant, CompteBancaire compte,
			ConseillerClientTest conseillerClient) {
		super();
		this.idOperation = idOperation;
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
		this.conseillerClient = conseillerClient;
	}

	public long getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(long idOperation) {
		this.idOperation = idOperation;
	}

	public String getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(String dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public CompteBancaire getCompte() {
		return compte;
	}

	public void setCompte(CompteBancaire compte) {
		this.compte = compte;
	}

	public ConseillerClientTest getConseillerClient() {
		return conseillerClient;
	}

	public void setConseillerClient(ConseillerClientTest conseillerClient) {
		this.conseillerClient = conseillerClient;
	}

}
