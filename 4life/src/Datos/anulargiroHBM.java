/*
 * anulargiroHBM.java
 *
 * Created on 7 de marzo de 2007, 18:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Horario;
import beans.anulargiro;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class anulargiroHBM extends HibernateDAO{
    
    /** Creates a new instance of anulargiroHBM */
    public anulargiroHBM() {
    }
    public List lista(){
        Criteria crit = session.createCriteria(anulargiro.class);     
        crit.addOrder(Order.asc("id"));
        return crit.list();
    }
    
    public List lista2(Horario ho){
        Criteria crit = session.createCriteria(anulargiro.class);     
         crit.add(Restrictions.eq("horario" ,ho));
        crit.addOrder(Order.asc("id_anulargiro"));
        return crit.list();
    }
    
    public anulargiro busca(String cedula){
        Criteria crit = session.createCriteria(anulargiro.class);
        crit.add(Restrictions.eq("cedula",cedula));
        if(crit.list().size()>1){
            System.out.println("no hay ususario");
            return null;
        }
        else{
            return (anulargiro)crit.uniqueResult();
        }
    } 
}
