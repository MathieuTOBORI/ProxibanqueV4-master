package org.projet.beans;

import java.util.Collection;
import java.util.LinkedHashSet;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;




@Entity
@NamedQueries({ @NamedQuery(name = "listeClients.Lists", query = "select o from Item o"), })
public class ClientTest {

	
	private long idConseiller;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "compteBancaire")
	private Collection<CompteBancaire> listComptes = new LinkedHashSet<CompteBancaire>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conseillerClient")
	private ConseillerClientTest conseillerClient;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nom;
	private String prenom;
	@Embedded
	private Adresse adresse;
	private String telephone;
	private String email;

	public ClientTest() {
		super();
	}

	public ClientTest(long idConseiller, String nom, String prenom, Adresse adresse, String telephone, String email) {
		super();
		this.idConseiller = idConseiller;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
	}

	public long getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(long idConseiller) {
		this.idConseiller = idConseiller;
	}

	public Collection<CompteBancaire> getListComptes() {
		return listComptes;
	}

	public void setListComptes(Collection<CompteBancaire> listComptes) {
		listComptes = listComptes;
	}

	public ConseillerClientTest getConseillerClient() {
		return conseillerClient;
	}

	public void setConseillerClient(ConseillerClientTest conseillerClient) {
		this.conseillerClient = conseillerClient;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
