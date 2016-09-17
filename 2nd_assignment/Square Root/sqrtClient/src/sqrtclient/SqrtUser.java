/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqrtclient;

import java.math.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry; 
import sqrtserver.ISquareRoot;

public class SqrtUser {
    public static void main(String args[]) {
        
        try {
            double s2;
            int s1=25;
            Registry registry = LocateRegistry.getRegistry();
            ISquareRoot remoteSqrt = (ISquareRoot) Naming.lookup("sqrt");
            s2=remoteSqrt.getSquare(s1);
            System.out.println("The square root of " + s1 + " is " + s2);
        } catch (Exception e) {e.printStackTrace();;}
    }
}
