package edu.dio.lesson10;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Vladimir V. Kravchenko on 02.06.2014.
 */
public class ServiceServer extends UnicastRemoteObject implements ServiceInterface {
    private int servicePort=1000;
    private String serviceHost="localhost";
    private Registry registry;

    public ServiceServer() throws RemoteException {
        registry = LocateRegistry.createRegistry(servicePort);
        registry.rebind("serviceServer", this);
    }

    @Override
    public String retrieveStringData(String param) throws RemoteException {
        return "Some String with "+param;
    }

    public static void main(String[] args) {
        try {
            ServiceServer serviceServer = new ServiceServer();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
