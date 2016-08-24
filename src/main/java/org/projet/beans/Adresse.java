package org.projet.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	private String rue;
	private String ville;
	private String numero;
	private String codePostal;

	// Constructeur par defaut
	public Adresse() {

	}

	// Constructeur "complet"
	public Adresse(String rue, String ville, String numero,String codePostal) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.numero = numero;
		this.codePostal=codePostal;
		
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	
	
	

}
