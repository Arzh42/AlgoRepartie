package com.company.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MaClasse extends UnicastRemoteObject implements MonInterface {

	protected MaClasse() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void methode() throws RemoteException {
		System.out.println("coucou");
		
	}
	
}
