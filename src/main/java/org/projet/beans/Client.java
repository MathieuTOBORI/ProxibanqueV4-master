package org.projet.beans;

import java.util.Collection;
import java.util.LinkedHashSet;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.formation.model.Order;

@Entity
@Table(name = "client")
@NamedQueries({ @NamedQuery(name = "clients.getAll", query = "select o from Item o"), })
public class Client extends Personne {

	private long idConseiller;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CompteBancaire")
	private Collection<CompteBancaire> ListComptes = new LinkedHashSet<CompteBancaire>();
	
	@ManyToOne
	private ConseillerClientTest conseillerClient;

	// Constructeur Complet
	public Client(long idclient, Collection<CompteBancaire> listComptes) {
		super();
		this.idConseiller = idConseiller;
		ListComptes = listComptes;
	}

	public Client(long id, String nom, String prenom, Adresse adresse, String telephone, String email,
			long idConseiller) {
		super(id, nom, prenom, adresse, telephone, email);
		this.idConseiller = idConseiller;
	}

	// Constructeur per defaut
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdConseiller() {
		return idConseiller;
	}

	public void setIdclient(long idConseiller) {
		this.idConseiller = idConseiller;
	}

	public Collection<CompteBancaire> getListComptes() {
		return ListComptes;
	}

	public void setListComptes(Collection<CompteBancaire> listComptes) {
		ListComptes = listComptes;
	}

}
