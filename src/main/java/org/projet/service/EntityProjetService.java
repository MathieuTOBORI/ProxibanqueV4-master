package org.projet.service;

import java.util.List;

public interface EntityProjetService<E> {
	public void add(E c) throws Exception;

	public void edit(E c) throws Exception;

	public void delete(Object idClient) throws Exception;

	public E searchClientByID(Object id) throws Exception;

	public List<E> Lists() throws Exception;

	public List<E> searchByConseiller(String conseiller, Object val) throws Exception;

	public List<E> searchInRange(int firstResult, int maxResults) throws Exception;

	long count() throws Exception;

}
