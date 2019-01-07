package com.company.RMI;

import java.rmi.*;

public interface MonInterface extends Remote {
	public void methode() throws RemoteException;
}
