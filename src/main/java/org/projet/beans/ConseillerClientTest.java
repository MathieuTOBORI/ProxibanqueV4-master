package org.projet.beans;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.formation.model.Item;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "conseillerClient")
@Component
public class ConseillerClientTest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idConseilelr;

	private String nom;
	private String prenom;
	@Embedded
	private Adresse adresse;
	private String telephone;
	private String email;

	private String password;
	private String loging;
	
	@OneToMany
	private Collection<ClientTest> listeClients= new LinkedHashSet<ClientTest>();
	
	private List<CompteBancaire> listeComptesBancaires;

	// Constructeur par defaut
	public ConseillerClientTest() {

	}

	public ConseillerClientTest(String nom, String prenom, Adresse adresse, String telephone, String email, String password,
			String loging) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
		this.loging = loging;
	}

	public long getIdConseilelr() {
		return idConseilelr;
	}

	public void setIdConseilelr(long idConseilelr) {
		this.idConseilelr = idConseilelr;
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

	
	public Collection<ClientTest> getListeClients() {
		return listeClients;
	}

	public void setListeClients(Collection<ClientTest> listeClients) {
		this.listeClients = listeClients;
	}

	public List<CompteBancaire> getListeComptesBancaires() {
		return listeComptesBancaires;
	}

	public void setListeComptesBancaires(List<CompteBancaire> listeComptesBancaires) {
		this.listeComptesBancaires = listeComptesBancaires;
	}

	// Constructeur "complet"

}
