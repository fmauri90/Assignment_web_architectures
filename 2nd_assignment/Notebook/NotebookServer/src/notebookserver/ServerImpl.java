/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notebookserver;

/**
 *
 * @author maurizio
 */

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServerImpl implements Server{
    private int number = 0;
    
    public ServerImpl(int number){
        this.number = number;
    }
    
    public static void main(String[] args) {
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Server engine = new ServerImpl(1);
            Server stub = (Server) UnicastRemoteObject.exportObject(engine, 0);
            Server engine2 = new ServerImpl(2);
            Server stub2 = (Server) UnicastRemoteObject.exportObject(engine2, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("s1", stub);
            registry.rebind("s2", stub2);
            System.out.println("s1 and s2 bound");
        } catch (Exception e){
            System.err.println("servers exception:");
            e.printStackTrace();
        }
    }
    
    @Override
    public void sign(INotebook n) throws RemoteException {
       n.add("s"+number);
    }
    
}
