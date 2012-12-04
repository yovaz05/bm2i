/*
 * TarjetasHBM.java
 *
 * Created on 2 de abril de 2007, 14:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Horario;
import beans.Tarjetas;
import hibernate.HibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class TarjetasHBM extends HibernateDAO{
    
    /** Creates a new instance of TarjetasHBM */
    public TarjetasHBM() {
    }
   public List lista3(Horario hora){
        Criteria crit = session.createCriteria(Tarjetas.class);
      //  crit.setMaxResults(150);
         if ( hora!=null)
           // crit.add(Restrictions.eq("agencia",age));
            crit.add(Restrictions.eq("horario",hora));
        //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
    }
   public Tarjetas buscar(String nombre, Horario hora) {
        Criteria crit = session.createCriteria(Tarjetas.class);
        crit.add(Restrictions.eq("nombre",nombre));
         crit.add(Restrictions.eq("horario",hora));
            if(crit.list().size()>1)
            return null;
        else
            return (Tarjetas)crit.uniqueResult();
    }
   
}
