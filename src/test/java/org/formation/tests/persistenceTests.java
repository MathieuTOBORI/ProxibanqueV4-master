package org.formation.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.formation.dao.ItemsDao;
import org.formation.dao.OrdersDao;
import org.formation.model.Item;
import org.formation.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.projet.beans.ClientTest;
import org.projet.beans.CompteBancaire;
import org.projet.beans.ConseillerClientTest;
import org.projet.dao.IClientDao;
import org.projet.dao.IConseillerClientDAO;
import org.projet.dao.impl.EntityProjetDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class persistenceTests {

	
	// On a un fichier persistance
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	IConseillerClientDAO conseillerClientDAO;

	@Autowired
	IClientDao clientDao;

	@Test
	@Transactional
	public void testDaoImpl() throws Exception {
		// assertEquals(1, itemDao.count());
		ClientTest client = new ClientTest();
		clientDao.add(client);
//		assertNotNull(client);
		assertEquals(1, clientDao.count());
	}

	@Test
	@Transactional
	public void testDaoServices() throws Exception {
		// assertEquals(1, orderDao.count());
		 ConseillerClientTest   conseillerClient= new ConseillerClientTest();
		 conseillerClient.getListeClients().add(new ClientTest());
		 conseillerClientDAO.add(conseillerClient);
		assertEquals(1, conseillerClientDAO.count());
	}

	@Test
	@Transactional
	public void testSaveOrderWithItems() throws Exception {
		// assertNotNull(order.getId());
		ConseillerClientTest   conseillerClient= new ConseillerClientTest();
		 conseillerClient.getListeClients().add(new ClientTest());
		 conseillerClientDAO.add(conseillerClient);
			entityManager.flush();
		assertNotNull(conseillerClient.getIdConseilelr());

	}
	
	@Test
	@Transactional
	public void testSaveAndGet() throws Exception {
		 ConseillerClientTest   conseillerClient= new ConseillerClientTest();
		 conseillerClient.getListeClients().add(new ClientTest());
		 entityManager.persist(conseillerClient);
		 entityManager.flush();
		 // Otherwise the query returns the existing order (and we didn't set 	 the
		 // parent in the item)...
		 entityManager.clear();
		 ConseillerClientTest conseillerClient2 = (ConseillerClientTest) entityManager.find(ConseillerClientTest.class, conseillerClient.getIdConseilelr());
		 assertEquals(1, conseillerClient2.getListeClients().size());
//		 assertEquals(conseillerClient2, conseillerClient2.getListeClients().iterator().next().getClass());
	}
//
//	@Test
//	@Transactional
//	public void testSaveAndFind() throws Exception {
		// Order order = new Order();
		// Item item = new Item();
		// item.setProduct("foo");
		// order.getItems().add(item);
		// entityManager.persist(order);
		// entityManager.flush();
		// // Otherwise the query returns the existing order (and we didn't set
		// the
		// // parent in the item)...
		// entityManager.clear();
		// Order other = (Order) entityManager
		// .createQuery(
		// "select o from Order o join o.items i where i.product=:product")
		// .setParameter("product", "foo").getSingleResult();
		// assertEquals(1, other.getItems().size());
		// assertEquals(other, other.getItems().iterator().next().getOrder());
//	}


}
