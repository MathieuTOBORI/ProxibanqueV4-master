package org.projet.controleur;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.projet.beans.ClientTest;
import org.projet.beans.ConseillerClientTest;
import org.projet.service.IClientService;
import org.projet.service.IConseillerClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "conseillerClientController")
@ViewScoped
public class ConseillerClientController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	IConseillerClientService conseillerClientService;

	@Autowired
	IClientService clientService;
	private ConseillerClientTest beanConseiller;
	private ConseillerClientTest beanSelectConseiller;
	private List<ConseillerClientTest> listConseiller;
	private List<ConseillerClientTest> listSelectConseiller;
	private List<String> listClient;

	public void setClients(List<ClientTest> clients) {
	}

	@PostConstruct
	public void init() {
		refreshList();
	}

	public void refreshList() {
		this.beanConseiller = new ConseillerClientTest();
		this.beanSelectConseiller = new ConseillerClientTest();
		this.listConseiller = new ArrayList<ConseillerClientTest>();
		this.listSelectConseiller = new ArrayList<ConseillerClientTest>();
		this.listClient = new ArrayList<String>();
		try {
			this.listConseiller.addAll(conseillerClientService.Lists());
			this.listSelectConseiller.addAll(listConseiller);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void save() {
		try {

			for (String IdClient : listClient) {
				ClientTest client = new ClientTest();
				client = clientService.searchClientByID(Long.parseLong(IdClient));
				this.beanConseiller.getListeClients().add(client);
			}

			conseillerClientService.edit(this.beanConseiller);
			refreshList();
			notificationSuccess("Stocker dans la base de donné");
		} catch (Exception e) {
			notificationError(e, "Stocker dans la base de donné");
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			conseillerClientService.edit(this.beanConseiller);
			refreshList();
			notificationSuccess("Charger un client");
		} catch (Exception e) {
			notificationError(e, "Charger un client");
		}
	}

	public void delete() {
		try {
			clientService.delete(this.beanSelectConseiller.getIdConseilelr());
			refreshList();
			notificationSuccess("Supprimer un conseiller");
		} catch (Exception e) {
			notificationError(e, "Supprimer un conseiller");
		}
	}

	public void onCancel(RowEditEvent event) {
		refreshList();
	}

	public void reset() {
		refreshList();
		RequestContext.getCurrentInstance().reset("form1:panel");
	}

	public void notificationSuccess(String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Operation " + operation + " success");
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Success");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void notificationError(Exception e, String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Operation " + operation + " Error ", e);
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<ClientTest> getClients() {
		List<ClientTest> tmpList = new ArrayList<ClientTest>();
		try {
			tmpList.addAll(clientService.Lists());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmpList;
	}

	public IConseillerClientService getConseillerClientService() {
		return conseillerClientService;
	}

	public void setConseillerClientService(IConseillerClientService conseillerClientService) {
		this.conseillerClientService = conseillerClientService;
	}

	public IClientService getClientService() {
		return clientService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public ConseillerClientTest getBeanConseiller() {
		return beanConseiller;
	}

	public void setBeanConseiller(ConseillerClientTest beanConseiller) {
		this.beanConseiller = beanConseiller;
	}

	public ConseillerClientTest getBeanSelectConseiller() {
		return beanSelectConseiller;
	}

	public void setBeanSelectConseiller(ConseillerClientTest beanSelectConseiller) {
		this.beanSelectConseiller = beanSelectConseiller;
	}

	public List<ConseillerClientTest> getListConseiller() {
		return listConseiller;
	}

	public void setListConseiller(List<ConseillerClientTest> listConseiller) {
		this.listConseiller = listConseiller;
	}

	public List<ConseillerClientTest> getListSelectConseiller() {
		return listSelectConseiller;
	}

	public void setListSelectConseiller(List<ConseillerClientTest> listSelectConseiller) {
		this.listSelectConseiller = listSelectConseiller;
	}

	public List<String> getListClient() {
		return listClient;
	}

	public void setListClient(List<String> listClient) {
		this.listClient = listClient;
	}

}