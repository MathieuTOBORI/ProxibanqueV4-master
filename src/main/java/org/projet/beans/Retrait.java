package org.projet.beans;



import org.springframework.stereotype.Component;


@Component(value="retrait")
public class Retrait extends Operation{

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(long idOperation, String dateOperation, double montant, CompteBancaire compte,
			ConseillerClientTest conseillerClient) {
		super(idOperation, dateOperation, montant, compte, conseillerClient);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Retrait [getIdOperation()=" + getIdOperation() + ", getDateOperation()=" + getDateOperation()
				+ ", getMontant()=" + getMontant() + ", getCompte()=" + getCompte() + ", getConseillerClient()="
				+ getConseillerClient() + ", toString()=" + super.toString() + "]";
	}

	

}
