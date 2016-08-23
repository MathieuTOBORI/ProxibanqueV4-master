package org.projet.dao;

import java.util.List;

import org.projet.beans.Client;

public interface IClientDAO<Client> {
	public void addClient(Client c) throws Exception;
	public void editClient(Client c) throws Exception;
	public void deleteClient( Object idClient) throws Exception;
	public Client searchClientByID( Object id) throws Exception;
	public List<Client> ListClients() throws Exception;
	public List<Client> searchByConseiller(String conseiller, Object val) throws Exception;
	public List<Client> searchInRange(int firstResult, int maxResults) throws Exception;
	long count() throws Exception;
}
