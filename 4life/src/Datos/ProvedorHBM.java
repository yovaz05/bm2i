/*
 * ProvedorHBM.java
 *
 * Created on 11 de enero de 2007, 20:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Provedor;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ProvedorHBM extends HibernateDAO{
    
     
     
    public ProvedorHBM() {
    }
      public List lista(){
        Criteria crit = session.createCriteria(Provedor.class);     
        //crit.addOrder(Order.asc("id"));
        return crit.list();
    }
}
