/*
 * MesHBM.java
 *
 * Created on 8 de octubre de 2006, 03:24 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Giro;
import beans.mes;
import beans.CodigoAgencia;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class MesHBM extends HibernateDAO{
    
    /** Creates a new instance of MesHBM */
    public MesHBM() {
    }
  
   public List lista2(){
        Criteria crit = session.createCriteria(mes.class);
      //  crit.setMaxResults(150);
        // if (socio!=null)
          //  crit.add(Restrictions.eq("agencia",socio));
        //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
    } 
   
   
}
