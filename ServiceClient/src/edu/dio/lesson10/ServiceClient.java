package edu.dio.lesson10;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Vladimir V. Kravchenko on 02.06.2014.
 */
public class ServiceClient {
    public static void main(String[] args) {
        ServiceInterface serviceServer = null;
        Registry registry;
        String serverHost="localhost";
        String serverPort="1000";
        try {
            registry = LocateRegistry.getRegistry(serverHost, Integer.parseInt(serverPort));
            serviceServer = (ServiceInterface) registry.lookup("serviceServer");
            String result = serviceServer.retrieveStringData("data");
            System.out.println(result);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}
