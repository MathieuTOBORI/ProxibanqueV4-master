package org.projet.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gerant")
public class Gerant extends ConseillerClientTest {

	private List<ConseillerClientTest> listeConseillerClients;

	public Gerant() {

	}

	public Gerant(List<ConseillerClientTest> listeConseillerClients) {
		super();
		this.listeConseillerClients = listeConseillerClients;
	}

	public List<ConseillerClientTest> getListeConseillerClients() {
		return listeConseillerClients;
	}

	public void setListeConseillerClients(List<ConseillerClientTest> listeConseillerClients) {
		this.listeConseillerClients = listeConseillerClients;
	}
	
	
	
	
	

}
