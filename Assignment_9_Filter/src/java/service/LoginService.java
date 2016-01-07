/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author maurizio
 */

import java.util.ArrayList;
import java.util.List;
import model.User;
import util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class LoginService {
      
    public boolean authenticate(String userId, String password){
        
        User user = getUserById(userId);
       
        
        if(user!=null && user.getUserId().equals(userId) && password.equals(password)){
            return true;
        } else{
            return false;
        }
    }
    
    public User getUserById(String userId){
        
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        User user = null;
        
        try{
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from User where USERID='"+userId+"'");
            user = (User)query.uniqueResult();

            tx.commit();            
        } catch(Exception e){
            if (tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally{
            session.close();
        }
        return user;
        
    }   
}
