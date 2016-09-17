/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notebookclient;

/**
 *
 * @author maurizio
 */

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import notebookserver.Notebook;
import notebookserver.INotebook;
import notebookserver.Server;


public class NotebookUser {
    public static void main(String[] args) {
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try{
            Registry registry = LocateRegistry.getRegistry(0);
            Server s1 = (Server) registry.lookup("s1");
            Server s2 = (Server) registry.lookup("s2");
            INotebook inote = new Notebook();
            Remote r = (INotebook) UnicastRemoteObject.exportObject(inote, 0);
            s1.sign(inote);
            s2.sign(inote);
            for (String s:((Notebook)inote).str){
                System.out.println(s);
            }
            UnicastRemoteObject.unexportObject(inote, true);
        } catch (Exception e) {
            System.err.println("Compute exception:");
            e.printStackTrace();
        }
    }
    
}
