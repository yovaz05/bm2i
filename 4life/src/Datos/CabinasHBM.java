/*
 * CabinasHBM.java
 *
 * Created on 8 de noviembre de 2006, 23:44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Horario;
import beans.Cabinas;
import hibernate.HibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CabinasHBM extends HibernateDAO{
    
    /** Creates a new instance of CabinasHBM */
    public CabinasHBM() {
    }
    
     public List lista3(Horario hora){
        Criteria crit = session.createCriteria(Cabinas.class);
      //  crit.setMaxResults(150);
         if ( hora!=null)
           // crit.add(Restrictions.eq("agencia",age));
            crit.add(Restrictions.eq("horario",hora));
        //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
    }
      public List lista4(Date hora, Date anul){
        Criteria crit = session.createCriteria(Cabinas.class);
        if ( hora!=null && anul!=null )
            crit.add( Restrictions.between("fechaLlegada",hora,anul));
                     
           return crit.list();
           } 
}
