package org.projet.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component(value= "virement")
public class Virement extends Operation{

	public Virement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Virement(long idOperation, String dateOperation, double montant, CompteBancaire compte,
			ConseillerClientTest conseillerClient) {
		super(idOperation, dateOperation, montant, compte, conseillerClient);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Virement [getIdOperation()=" + getIdOperation() + ", getDateOperation()=" + getDateOperation()
				+ ", getMontant()=" + getMontant() + ", getCompte()=" + getCompte() + ", getConseillerClient()="
				+ getConseillerClient() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	

}
