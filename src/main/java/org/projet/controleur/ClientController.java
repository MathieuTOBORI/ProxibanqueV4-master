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

import org.projet.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component(value="clientController")
@ViewScoped
public class ClientController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IClientService clientService;
	
	
	private ClientTest beanClient;
	private ClientTest beanSelectClient;
	private List<ClientTest> listClient;
	private List<ClientTest> listSelectClient;
	
	@PostConstruct
    public void init() {
		refreshList();
    }
	
	
	public void refreshList() {
		this.beanClient = new ClientTest();
		this.beanSelectClient = new ClientTest();
		this.listClient = new ArrayList<ClientTest>();
		this.listSelectClient = new ArrayList<ClientTest>();
		try {
			this.listClient.addAll(clientService.Lists());
			this.listSelectClient.addAll(listClient);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void save() {
		try {
		    
			clientService.add(this.beanClient);
			refreshList();
			notificationSuccess("Stocker un client");
		} catch (Exception e) {
			notificationError(e,"Stocker un client");
			e.printStackTrace();
		}
	}
	
	public void update() {
		try {
			clientService.edit(this.beanSelectClient);
			refreshList();
			notificationSuccess("Charger un client");
		} catch (Exception e) {
			notificationError(e,"Charger un client");
		}
	}
	
	public void delete() {
		try {
			clientService.delete(this.beanSelectClient.getId());
			refreshList();
			notificationSuccess("delete Client");
		} catch (Exception e) {
			notificationError(e,"delete Client");
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
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Operation "+operation+" success");
		FacesMessage msg = null;  
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Success"); 
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}


	public void notificationError(Exception e, String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Operation "+operation+" Error ",e);
		FacesMessage msg = null;  
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");  
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}
	
	
	
	public ClientTest getBeanClient() {
		return beanClient;
	}
	public void setBeanClient(ClientTest beanClient) {
		this.beanClient = beanClient;
	}
	public ClientTest getBeanSelectClient() {
		return beanSelectClient;
	}
	public void setBeanSelectClient(ClientTest beanSelectClient) {
		this.beanSelectClient = beanSelectClient;
	}
	public List<ClientTest> getListClient() {
		return listClient;
	}
	public void setListClient(List<ClientTest> listClient) {
		this.listClient = listClient;
	}
	public List<ClientTest> getListSelectClient() {
		return listSelectClient;
	}
	public void setListSelectClient(List<ClientTest> listSelectClient) {
		this.listSelectClient = listSelectClient;
	}
	public IClientService getClientService() {
		return clientService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}
	
}
