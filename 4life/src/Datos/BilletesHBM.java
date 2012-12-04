/*
 * BilletesHBM.java
 *
 * Created on 10 de enero de 2007, 03:09 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Billetes;
import beans.Horario;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class BilletesHBM extends HibernateDAO{
    
    /** Creates a new instance of BilletesHBM */
    public BilletesHBM() {
    }
   public List lista3(Horario hora){
        Criteria crit = session.createCriteria(Billetes.class);
        if ( hora!=null)
                  crit.add(Restrictions.eq("horario",hora));
                  return crit.list();
    }  
    public List lista(Horario hora, Boolean a){
        
        Criteria crit = session.createCriteria(Billetes.class);
        if ( hora!=null)
                  crit.add(Restrictions.eq("horario",hora));
                  crit.add(Restrictions.eq("cierre1",a));
   return crit.list();
    }

    
    public List lista9(Horario hora, Boolean a, Boolean b){
        
        Criteria crit = session.createCriteria(Billetes.class);
        if ( hora!=null)
                  crit.add(Restrictions.eq("horario",hora));
                  crit.add(Restrictions.eq("adelanto",a));
                  crit.add(Restrictions.eq("cierre1",b));
   return crit.list();
    }
    
    
    
    
    public Billetes busca(Horario hora, Boolean b){
        Criteria crit = session.createCriteria(Billetes.class);
        crit.add(Restrictions.eq("horario",hora));
        crit.add(Restrictions.eq("cieere1",b));
        
        if(crit.list().size()>1){
            System.out.println("no hay ");
            return null;
        }
        else{
            return (Billetes)crit.uniqueResult();
        }
 }
    
}
