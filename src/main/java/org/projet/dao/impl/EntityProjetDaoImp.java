package org.projet.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.projet.dao.IEntityProjetDao;


import org.springframework.transaction.annotation.Transactional;

import javassist.bytecode.SignatureAttribute.TypeVariable;



public class EntityProjetDaoImp<E> implements IEntityProjetDao<E> {

	@PersistenceContext(unitName = "persistenceUnit")
	protected EntityManager entityManager;

	protected E instance;
	private Class<E> entityClass;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public E getInstance() {
		return instance;
	}

	public void setInstance(E instance) {
		this.instance = instance;
	}

	@SuppressWarnings("unchecked")
	public Class<E> getEntityClass() throws Exception {
		if (entityClass == null) {
			Type type = getClass().getGenericSuperclass();
			if (type instanceof ParameterizedType) {
				ParameterizedType paramType = (ParameterizedType) type;
				if (paramType.getActualTypeArguments().length == 2) {
					if (paramType.getActualTypeArguments()[1] instanceof TypeVariable) {
						throw new IllegalArgumentException("Can't find class using reflection");
					} else {
						entityClass = (Class<E>) paramType.getActualTypeArguments()[1];
					}
				} else {
					entityClass = (Class<E>) paramType.getActualTypeArguments()[0];
				}
			} else {
				throw new Exception("Can't find class using reflection");
			}
		}
		return entityClass;
	}
	
	public void setEntityClass(Class<E> entityClass) {
		this.entityClass = entityClass;
	}
	@Transactional
	public void add(E c) throws HibernateException {
		getEntityManager().persist(c);

	}
	@Transactional
	public void edit(E c) throws HibernateException {
		getEntityManager().merge(c);

	}
	@Transactional
	public void delete(Object idClient) throws Exception {
		getEntityManager().remove((E) getEntityManager().find(getEntityClass(), idClient));

	}
	@Transactional(readOnly = true)
	public E searchClientByID(Object id) throws Exception {
		return (E) getEntityManager().find(getEntityClass(), id);
	}
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<E> Lists() throws Exception {
		return getEntityManager().createQuery("Select t from " + getEntityClass().getSimpleName() + " t")
				.getResultList();
	}
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<E> searchByConseiller(String conseiller, Object val) throws Exception {
		return (List<E>) getEntityManager()
				.createQuery("select x from " + getEntityClass().getSimpleName() + " x where x." + conseiller + " = ?1")
				.setParameter(1, val).getResultList();
	}
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<E> searchInRange(int firstResult, int maxResults) throws Exception {
		return getEntityManager().createQuery("Select t from " + getEntityClass().getSimpleName() + " t")
				.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}

	public long count() throws Exception {
		return (Long) getEntityManager().createQuery("Select count(t) from " + getEntityClass().getSimpleName() + " t")
				.getSingleResult();
	}

}
