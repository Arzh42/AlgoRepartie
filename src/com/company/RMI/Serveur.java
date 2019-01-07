package com.company.RMI;

import javax.naming.directory.InitialDirContext;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Serveur {

	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws AlreadyBoundException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		MaClasse mc = new MaClasse();
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        registry.bind("rmi://localhost:1099/coucou", mc);

	}

}
