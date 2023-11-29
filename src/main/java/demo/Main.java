package demo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import interfaces.ITutoringServer;



public class Main {

	public static void main(String[] args) throws RemoteException, ServiceException, MalformedURLException, NotBoundException {
		ClientAccount a= new ClientAccount(0, "ZE", "USD", 5);
		ClientAccount b= new ClientAccount(1, "DEIZER", "EUR", 0);
		WebBankService web= new WebBankService();
		web.addClient(a);
		web.addClient(b);
		web.makePayment(0, 3); 
		
		ITutoringServer server = (ITutoringServer) Naming.lookup("TutoringPlatform");
		System.out.println(server);
	
		// TODO Auto-generated method stub

	}

}
