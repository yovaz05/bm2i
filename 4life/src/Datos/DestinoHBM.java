/*
 * DestinoHBM.java
 *
 * Created on 28 de septiembre de 2006, 16:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Destino;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class DestinoHBM extends HibernateDAO{
    
    /** Creates a new instance of DestinoHBM */
    public DestinoHBM() {
    }
    
   public List lista(){
        Criteria crit = session.createCriteria(Destino.class);     
        crit.addOrder(Order.asc("id"));
        return crit.list();
    }
    public Destino busca(String cedula){
        Criteria crit = session.createCriteria(Destino.class);
        crit.add(Restrictions.eq("cedula",cedula));
        if(crit.list().size()>1){
            System.out.println("no hay ususario");
            return null;
        }
        else{
            return (Destino)crit.uniqueResult();
        }
    } 
    
    
    
    
}
