package org.projet.beans;

import java.util.List;

public class Client extends Personne{
	
	private long idclient ;
	
	private List<CompteBancaire> ListComptes;

//	Constructeur Complet
	public Client(long idclient, List<CompteBancaire> listComptes) {
		super();
		this.idclient = idclient;
		ListComptes = listComptes;
	}

	
//	Constructeur per defaut
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getIdclient() {
		return idclient;
	}


	public void setIdclient(long idclient) {
		this.idclient = idclient;
	}


	public List<CompteBancaire> getListComptes() {
		return ListComptes;
	}


	public void setListComptes(List<CompteBancaire> listComptes) {
		ListComptes = listComptes;
	}


	

	
	
	

}
