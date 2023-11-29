package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface ITeacher extends Remote {

	public void addStudentToWaitingList(IStudent student, String subject) throws RemoteException;

	public void removeStudentFromWaitingList(IStudent student, String subject) throws RemoteException;

	public String to_string() throws RemoteException;

	public String getName() throws RemoteException;
	
	public IAppointment getAppointment(String appString) throws RemoteException;
}
