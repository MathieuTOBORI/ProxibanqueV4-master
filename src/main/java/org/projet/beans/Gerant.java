package org.projet.beans;

import java.util.List;

public class Gerant extends ConseillerClient {

	private List<ConseillerClient> listeConseillerClients;

	public Gerant() {

	}

	public Gerant(List<ConseillerClient> listeConseillerClients) {
		super();
		this.listeConseillerClients = listeConseillerClients;
	}

	public List<ConseillerClient> getListeConseillerClients() {
		return listeConseillerClients;
	}

	public void setListeConseillerClients(List<ConseillerClient> listeConseillerClients) {
		this.listeConseillerClients = listeConseillerClients;
	}
	
	
	
	
	

}
