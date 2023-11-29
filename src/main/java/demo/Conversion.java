package demo;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import javax.xml.rpc.ServiceException;

import FxtopAPI.FxtopServicesLocator;
import FxtopAPI.FxtopServicesPortType;

public class Conversion {
	private FxtopServicesPortType service;

	public Conversion() throws ServiceException {
		service = new FxtopServicesLocator().getFxtopServicesPort();
	}


	public double convert(double eur,String original_currency,String final_currency) throws RemoteException, ServiceException{
		return Double.parseDouble(service.convert(new Double(eur).toString(), original_currency, final_currency, "", "", "").getResultAmount());

	}

	public List<String> getCurrencyList() throws RemoteException {
		String[] currencyArray = service.listCurrencies("", "").split("/");
		List<String> currencyList = Arrays.asList(currencyArray);
		return currencyList;
	}



}
