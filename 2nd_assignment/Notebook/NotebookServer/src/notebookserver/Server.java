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

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote{
    public void sign(INotebook n) throws RemoteException;
}
