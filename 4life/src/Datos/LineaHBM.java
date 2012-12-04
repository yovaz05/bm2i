/*
 * AgenciaHBM.java
 *
 * Created on 29 de septiembre de 2006, 13:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Linea;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class LineaHBM extends HibernateDAO{
    
    /** Creates a new instance of AgenciaHBM */
    public LineaHBM() {
    }
    public List lista(){
        Criteria crit = session.createCriteria(Linea.class);
        crit.addOrder(Order.asc("nombre"));
        return crit.list();
    }
   
    public Linea buscar(String nombre) {
        Criteria crit = session.createCriteria(Linea.class);
        crit.add(Restrictions.eq("nombre",nombre));
            if(crit.list().size()>1)
            return null;
        else
            return (Linea)crit.uniqueResult();
    }
    
    public Linea buscarCl(String nombre) {
        Criteria crit = session.createCriteria(Linea.class);
        crit.add(Restrictions.eq("codigo",nombre));
            if(crit.list().size()>1)
            return null;
        else
            return (Linea)crit.uniqueResult();
    }
    
    
    
    
    public Linea busca(String cedula){
        Criteria crit = session.createCriteria(Linea.class);
        crit.add(Restrictions.eq("codigo",cedula));
        if(crit.list().size()>1){
            System.out.println("no hay ususario");
            return null;
        }
        else{
         //   System.out.println("si hay");
            return (Linea)crit.uniqueResult();
        }
    }
    
}
