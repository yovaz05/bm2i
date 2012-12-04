/*
 * PagoTHBM.java
 *
 * Created on 7 de noviembre de 2006, 19:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.PagoT;
import beans.Horario;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class PagoTHBM extends HibernateDAO{
    
    /** Creates a new instance of PagoTHBM */
    public PagoTHBM() {
    }
   public List lista3(Horario hora){
        Criteria crit = session.createCriteria(PagoT.class);
      //  crit.setMaxResults(150);
         if ( hora!=null)
           // crit.add(Restrictions.eq("agencia",age));
            crit.add(Restrictions.eq("horario",hora));
        //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
    } 
}
