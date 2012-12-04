/*
 * CreditoHBM.java
 *
 * Created on 12 de noviembre de 2006, 15:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Horario;
import beans.Credito;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CreditoHBM extends HibernateDAO{
    
    /** Creates a new instance of CreditoHBM */
    public CreditoHBM() {
    }
    
    public List lista(){
        Criteria crit = session.createCriteria(Credito.class);     
        crit.addOrder(Order.asc("nombre"));
        return crit.list();
}
          
public List lista3(Horario hora){
        Criteria crit = session.createCriteria(Credito.class);
        if ( hora!=null)
        crit.add(Restrictions.eq("horario",hora));
        return crit.list();
}
    
}
