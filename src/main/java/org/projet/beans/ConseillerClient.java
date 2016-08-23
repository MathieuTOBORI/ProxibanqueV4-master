package org.projet.beans;

import java.util.List;

public class ConseillerClient extends Personne{
	
private String password;
private String loging;

private List<Client> listeClients;
private List<CompteBancaire> listeComptesBancaires;

//Constructeur par defaut
public ConseillerClient() {

}

//Constructeur "complet"
public ConseillerClient(String password, String loging, List<Client> listeClients, List<CompteBancaire> listeComptes) {
	super();
	this.password = password;
	this.loging = loging;
	this.listeClients = listeClients;
	this.listeComptesBancaires = listeComptes;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getLoging() {
	return loging;
}

public void setLoging(String loging) {
	this.loging = loging;
}

public List<Client> getListeClients() {
	return listeClients;
}

public void setListeClients(List<Client> listeClients) {
	this.listeClients = listeClients;
}

public List<CompteBancaire> getListeComptes() {
	return listeComptesBancaires;
}

public void setListeComptes(List<CompteBancaire> listeComptes) {
	this.listeComptesBancaires = listeComptes;
}









}
