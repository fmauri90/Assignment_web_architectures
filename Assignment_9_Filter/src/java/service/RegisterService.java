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

import model.User;
import util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RegisterService {
    
    public boolean register(User user){
        
        Session session = HibernateUtil.openSession();
        if(isUserExists(user)) return false;
        
        Transaction tx = null;
        try{
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(user);
            tx.commit();
        } catch(Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return true;
    }
    
    public boolean isUserExists(User user){
        
        Session session = HibernateUtil.openSession();
        boolean result = false;
        Transaction tx = null;
        
        try{
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from User where userId='"+user.getUserId()+"'");
            User u = (User)query.uniqueResult();
            tx.commit();
            if(u != null) result = true;
        }catch(Exception e){
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return result;
    } 
}