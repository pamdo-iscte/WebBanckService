package demo;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

public class WebBankService {
	private List<ClientAccount> clientsDB;
	private List<String> possible_currency;
	private Conversion converter;
	private String appoitementCurrency = "EUR";


	public WebBankService(List<ClientAccount> clientsDB) throws ServiceException, RemoteException {

		this.clientsDB = clientsDB;
		this.converter= new Conversion();
		this.possible_currency = converter.getCurrencyList();
	}

	public WebBankService() throws ServiceException, RemoteException {

		this.clientsDB = new ArrayList<ClientAccount>();
		this.converter= new Conversion();
		this.possible_currency = converter.getCurrencyList();
	}

	public void addClient(ClientAccount clientAccount) {
		clientsDB.add(clientAccount);
	}

	public void removeClient(ClientAccount clientAccount) {
		clientsDB.remove(clientAccount);
	}


	private ClientAccount findClient( int client_id) {
		ClientAccount foundClient = null;


		for (ClientAccount client : clientsDB) {
			if (client.getId() == client_id) {
				foundClient = client;
				break; 
			}
		}


		if (foundClient == null){
			// Handle case when client_id is not found
			System.out.println("Client with ID " + client_id + " not found");
		}
		return foundClient;
	}


	private double convertCurrency(double cost, String clientCurrency) throws RemoteException, ServiceException {

		if(possible_currency.contains(clientCurrency)) {
			return converter.convert(cost, appoitementCurrency,clientCurrency);	

		}
		else {
			throw new IllegalArgumentException("CURRENCY IS NOT available");
		}

	}

	public void makePayment(int client_id, double cost) throws RemoteException, ServiceException {
		ClientAccount foundClient = findClient(client_id);
		double newCost = convertCurrency(cost,foundClient.getCurrency());
		foundClient.removeFunds(newCost);

	}













}
