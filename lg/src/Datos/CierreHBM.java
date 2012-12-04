/*
 * CierreHBM.java
 *
 * Created on 7 de noviembre de 2006, 21:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Cierre;
import beans.Horario;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CierreHBM extends HibernateDAO{
    
    /** Creates a new instance of CierreHBM */
    public CierreHBM() {
    }
    public List lista3(Horario hora){
        Criteria crit = session.createCriteria(Cierre.class);
        if ( hora!=null)
                  crit.add(Restrictions.eq("horario",hora));
                  return crit.list();
                  
                  
    } 
     public List lista(Horario hora, Boolean anul, Boolean cierr1){
        Criteria crit = session.createCriteria(Cierre.class);
        if ( hora!=null && anul!=null)
            crit.add(Restrictions.eq("horario",hora));
            crit.add(Restrictions.eq("ingreso",anul));
            crit.add(Restrictions.eq("cierre1",cierr1));
        return crit.list();
       
    }
     public List lista2(Horario hora, Boolean anul){
        Criteria crit = session.createCriteria(Cierre.class);
        if ( hora!=null && anul!=null)
            crit.add(Restrictions.eq("horario",hora));
            crit.add(Restrictions.eq("cierre1",anul));
        return crit.list();
       
    }
}
