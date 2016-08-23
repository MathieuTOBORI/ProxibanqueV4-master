package org.projet.service;

import java.util.List;

import org.projet.beans.Client;
import org.projet.dao.IClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ClientService implements IclientService<Client> {
	
	@Autowired
	@Qualifier(value="daoClient")
	private IClientDAO<Client> daoClient;

	public void addClient(Client c) throws Exception {
		daoClient.addClient(c);
		
	}

	public void editClient(Client c) throws Exception {
		daoClient.editClient(c);
		
	}

	public void deleteClient(Object idClient) throws Exception {
		daoClient.deleteClient(idClient);
		
	}

	public Client searchClientByID(Object id) throws Exception {
		
		return daoClient.searchClientByID(id);
	}

	public List<Client> ListClients() throws Exception {
		
		return daoClient.ListClients();
	}

	public List<Client> searchByConseiller(String conseiller, Object val) throws Exception {
	
		return daoClient.searchByConseiller(conseiller, val);
	}

	public List<Client> searchInRange(int firstResult, int maxResults) throws Exception {
				return daoClient.searchInRange(firstResult, maxResults);
	}

	public long count() throws Exception {
			return daoClient.count();
	}

}
