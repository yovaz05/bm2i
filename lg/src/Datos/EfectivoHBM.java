/*
 * EfectivoHBM.java
 *
 * Created on 29 de septiembre de 2006, 10:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Efectivo;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class EfectivoHBM extends HibernateDAO{
    
    /** Creates a new instance of EfectivoHBM */
    public EfectivoHBM() {
    }
         public List lista(){
        Criteria crit = session.createCriteria(Efectivo.class);     
        crit.addOrder(Order.asc("id"));
        return crit.list();
    }
    public Efectivo busca(String cedula){
        Criteria crit = session.createCriteria(Efectivo.class);
        crit.add(Restrictions.eq("cedula",cedula));
        if(crit.list().size()>1){
            System.out.println("no hay ususario");
            return null;
        }
        else{
            return (Efectivo)crit.uniqueResult();
        }
    }
}
