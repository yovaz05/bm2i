/*
 * CodigoAgenciaHBM.java
 *
 * Created on 20 de octubre de 2006, 04:33 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Agencia;
import beans.CodigoAgencia;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CodigoAgenciaHBM extends HibernateDAO{
    
    /** Creates a new instance of CodigoAgenciaHBM */
    public CodigoAgenciaHBM() {
    }
    
    public List lista(Agencia socio){
        Criteria crit = session.createCriteria(CodigoAgencia.class);
      //  crit.setMaxResults(150);
         if (socio!=null)
            crit.add(Restrictions.eq("agencia",socio));
        //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
    }
   public List lista2(){
        Criteria crit = session.createCriteria(CodigoAgencia.class);
      //  crit.setMaxResults(150);
        // if (socio!=null)
          //  crit.add(Restrictions.eq("agencia",socio));
        //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
    } 
   
    public CodigoAgencia busca(Agencia age){
        Criteria crit = session.createCriteria(CodigoAgencia.class);
        crit.add(Restrictions.eq("agencia",age));
        if(crit.list().size()>1){
            System.out.println("no hay ususario");
            return null;
        }
        else{
            System.out.println("si hay");
            return (CodigoAgencia)crit.uniqueResult();
        }
    }
}
