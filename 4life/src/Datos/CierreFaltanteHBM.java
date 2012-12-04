/*
 * CierreFaltanteHBM.java
 *
 * Created on 8 de marzo de 2007, 15:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.CierreFaltante;
import beans.Horario;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CierreFaltanteHBM extends HibernateDAO{
    
    /** Creates a new instance of CierreFaltanteHBM */
    public CierreFaltanteHBM() {
    }
        public List lista(){
        Criteria crit = session.createCriteria(CierreFaltante.class);     
        crit.addOrder(Order.asc("nombre"));
        return crit.list();
    }

        public List lista3(Horario hora, Boolean b){
        Criteria crit = session.createCriteria(CierreFaltante.class);
      //  crit.setMaxResults(150);
         if ( hora!=null)
           // crit.add(Restrictions.eq("agencia",age));
            crit.add(Restrictions.eq("horario",hora));
            crit.add(Restrictions.eq("gmt",b));
        //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
    }
        
    
    public CierreFaltante busca(String cedula){
        Criteria crit = session.createCriteria(CierreFaltante.class);
        crit.add(Restrictions.eq("codigo",cedula));
        if(crit.list().size()>1){
            System.out.println("no hay ususario");
            return null;
        }
        else{
         //   System.out.println("si hay");
            return (CierreFaltante)crit.uniqueResult();
        }
    }
    
}
