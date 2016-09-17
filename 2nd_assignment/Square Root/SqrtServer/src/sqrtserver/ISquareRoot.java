/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqrtserver;

import java.rmi.*;


public interface ISquareRoot extends Remote{
    
    double getSquare(int a) throws RemoteException;
    
}
