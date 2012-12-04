/*
 * FloresHBM.java
 *
 * Created on 23 de octubre de 2006, 03:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Flores;
import beans.Horario;
import hibernate.HibernateDAO;
import java.util.List;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class FloresHBM extends HibernateDAO{
    
    /** Creates a new instance of FloresHBM */
    public FloresHBM() {
    }
    public Flores busca(String clav){
        Criteria crit = session.createCriteria(Flores.class);
        crit.add(Restrictions.eq("clave",clav));
        if(crit.list().size()>1){
            System.out.println("no hay giro");
            return null;
        }
        else{
            return (Flores)crit.uniqueResult();
        }
    } 
    
    public List lista3(Horario hora){
        Criteria crit = session.createCriteria(Flores.class);
      //  crit.setMaxResults(150);
         if ( hora!=null)
           // crit.add(Restrictions.eq("agencia",age));
            crit.add(Restrictions.eq("horario",hora));
            crit.addOrder(Order.asc("id_Flores"));
        return crit.list();
    }
    public List lista2(){
        Criteria crit = session.createCriteria(Flores.class);
      //  crit.setMaxResults(150);
       crit.addOrder(Order.asc("id_Flores"));
        return crit.list();
    }
      public List lista4(Date hora, Date anul){
        Criteria crit = session.createCriteria(Flores.class);
        if ( hora!=null && anul!=null )
            crit.add( Restrictions.between("fechaLlegada",hora,anul));
                     
           return crit.list();
           } 
    
}
