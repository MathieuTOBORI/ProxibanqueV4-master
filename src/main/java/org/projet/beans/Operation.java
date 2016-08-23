package org.projet.beans;



public abstract class Operation {

	private long idOperation;
	private String dateOperation;
	private double montant;
	private CompteBancaire compte;
	private ConseillerClient conseillerClient;

	// ConstructorExecutor par defaut
	public Operation() {
	}

	// Constructeur Completr
	public Operation(long idOperation, String dateOperation, double montant, CompteBancaire compte,
			ConseillerClient conseillerClient) {
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

	public ConseillerClient getConseillerClient() {
		return conseillerClient;
	}

	public void setConseillerClient(ConseillerClient conseillerClient) {
		this.conseillerClient = conseillerClient;
	}

}
