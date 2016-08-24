package org.projet.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "compteEpargne")
@Component
public class CompteEpargne extends CompteBancaire{
	
	private double tauxRemuneration;

//	Constructeur par defaut
	public CompteEpargne() {
	
	}

//	Constructeur Complet
public CompteEpargne(double tauxRemuneration) {
	super();
	this.tauxRemuneration = tauxRemuneration;
}

public double getTauxRemuneration() {
	return tauxRemuneration;
}

public void setTauxRemuneration(double tauxRemuneration) {
	this.tauxRemuneration = tauxRemuneration;
}
	

	
	
}
