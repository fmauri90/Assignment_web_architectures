/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notebookserver;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.LinkedList;

/**
 *
 * @author maurizio
 */
public class Notebook implements INotebook{
    
    public LinkedList<String> str = new LinkedList<>(); //create a list of strings
    public void add(String s) throws RemoteException { //add a string
        str.add(s);
    }
    
    public void read() throws RemoteException { //read a string
        for(String s:str){
            System.out.println(s);
        }
    }
}
