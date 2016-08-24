package org.projet.service;

import java.util.List;

import org.projet.beans.ConseillerClientTest;
import org.projet.dao.IEntityProjetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value = "conseillerClientService")
@Transactional
public class ConseillerClientService implements IConseillerClientService {

	@Autowired
	private IEntityProjetDao<ConseillerClientTest> conseillerClientDao;

	public void add(ConseillerClientTest c) throws Exception {
		conseillerClientDao.add(c);

	}

	public void edit(ConseillerClientTest c) throws Exception {
		conseillerClientDao.edit(c);

	}

	public void delete(Object idClient) throws Exception {
		conseillerClientDao.delete(idClient);

	}

	public ConseillerClientTest searchClientByID(Object id) throws Exception {

		return conseillerClientDao.searchClientByID(id);
	}

	public List<ConseillerClientTest> Lists() throws Exception {

		return conseillerClientDao.Lists();
	}

	public List<ConseillerClientTest> searchByConseiller(String conseiller, Object val) throws Exception {
		return conseillerClientDao.searchByConseiller(conseiller, val);
	}

	public List<ConseillerClientTest> searchInRange(int firstResult, int maxResults) throws Exception {

		return conseillerClientDao.searchInRange(firstResult, maxResults);
	}

	public long count() throws Exception {

		return conseillerClientDao.count();
	}

}
