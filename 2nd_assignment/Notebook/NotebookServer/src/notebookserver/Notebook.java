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

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.LinkedList;

public class Notebook implements INotebook{
    public LinkedList<String> str = new LinkedList<>();
    public void add(String s) throws RemoteException {
        str.add(s);
    }
    public void read() throws RemoteException {
        for(String s:str){
            System.out.println(s);
        }
    }
}
