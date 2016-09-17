/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqrtserver;

import java.math.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;


public class SqrtImpl implements ISquareRoot{
   
    public static void main(String args[]){
        ISquareRoot sqrt;
        try {
            LocateRegistry.createRegistry(1099);
            sqrt = new SqrtImpl();
            ISquareRoot stub = (ISquareRoot)UnicastRemoteObject.exportObject(sqrt, 0); // pubblico l'oggetto
            Naming.bind("sqrt", (ISquareRoot) sqrt);
            System.out.println("Ready for RMI's");
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public double getSquare(int a) throws RemoteException {
        
        return Math.sqrt(a);
    }
}
