package edu.dio.lesson10;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Vladimir V. Kravchenko on 02.06.2014.
 */
public interface ServiceInterface extends Remote {
    public String retrieveStringData(String param) throws RemoteException;
}
