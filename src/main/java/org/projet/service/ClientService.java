package org.projet.service;

import java.util.List;

import org.projet.beans.ClientTest;
import org.projet.dao.IEntityProjetDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value = "clientService")
@Transactional
public class ClientService implements IClientService {

	@Autowired
	private IEntityProjetDao<ClientTest> clientDao;

	public void add(ClientTest c) throws Exception {
		clientDao.add(c);

	}

	public void delete(Object idClient) throws Exception {
		clientDao.delete(idClient);

	}

	public ClientTest searchClientByID(Object id) throws Exception {

		return clientDao.searchClientByID(id);
	}

	public List<ClientTest> Lists() throws Exception {

		return clientDao.Lists();
	}

	public List<ClientTest> searchByConseiller(String conseiller, Object val) throws Exception {

		return clientDao.searchByConseiller(conseiller, val);
	}

	public List<ClientTest> searchInRange(int firstResult, int maxResults) throws Exception {
		return clientDao.searchInRange(firstResult, maxResults);
	}

	public long count() throws Exception {
		return clientDao.count();
	}

	public void edit(ClientTest c) throws Exception {
		clientDao.edit(c);

	}

}
