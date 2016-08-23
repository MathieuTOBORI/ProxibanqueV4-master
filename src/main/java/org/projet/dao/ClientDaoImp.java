package org.projet.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javassist.bytecode.SignatureAttribute.TypeVariable;

@Repository("daoClient")
public class ClientDaoImp<Client> implements IClientDAO<Client> {

	@PersistenceContext(unitName = "persistenceUnit")
	protected EntityManager entityManager;

	protected Client instance;
	private Class<Client> entityClass;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Client getInstance() {
		return instance;
	}

	public void setInstance(Client instance) {
		this.instance = instance;
	}

	@SuppressWarnings("unchecked")
	public Class<Client> getEntityClass() throws Exception {
		if (entityClass == null) {
			Type type = getClass().getGenericSuperclass();
			if (type instanceof ParameterizedType) {
				ParameterizedType paramType = (ParameterizedType) type;
				if (paramType.getActualTypeArguments().length == 2) {
					if (paramType.getActualTypeArguments()[1] instanceof TypeVariable) {
						throw new IllegalArgumentException("Can't find class using reflection");
					} else {
						entityClass = (Class<Client>) paramType.getActualTypeArguments()[1];
					}
				} else {
					entityClass = (Class<Client>) paramType.getActualTypeArguments()[0];
				}
			} else {
				throw new Exception("Can't find class using reflection");
			}
		}
		return entityClass;
	}
	
	public void setEntityClass(Class<Client> entityClass) {
		this.entityClass = entityClass;
	}
	@Transactional(readOnly = true)
	public void addClient(Object c) throws Exception {
		getEntityManager().persist(c);

	}
	@Transactional(readOnly = true)
	public void editClient(Object c) throws Exception {
		getEntityManager().merge(c);

	}
	@Transactional(readOnly = true)
	public void deleteClient(Object idClient) throws Exception {
		getEntityManager().remove((Client) getEntityManager().find(getEntityClass(), idClient));

	}
	@Transactional(readOnly = true)
	public Client searchClientByID(Object id) throws Exception {
		return (Client) getEntityManager().find(getEntityClass(), id);
	}
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Client> ListClients() throws Exception {
		return getEntityManager().createQuery("Select t from " + getEntityClass().getSimpleName() + " t")
				.getResultList();
	}
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Client> searchByConseiller(String conseiller, Object val) throws Exception {
		return (List<Client>) getEntityManager()
				.createQuery("select x from " + getEntityClass().getSimpleName() + " x where x." + conseiller + " = ?1")
				.setParameter(1, val).getResultList();
	}
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Client> searchInRange(int firstResult, int maxResults) throws Exception {
		return getEntityManager().createQuery("Select t from " + getEntityClass().getSimpleName() + " t")
				.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}

	public long count() throws Exception {
		return (Long) getEntityManager().createQuery("Select count(t) from " + getEntityClass().getSimpleName() + " t")
				.getSingleResult();
	}

}
