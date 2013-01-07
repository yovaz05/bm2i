/*
 * AgenciaHBM.java
 *
 * Created on 29 de septiembre de 2006, 13:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Factura;
import beans.Horario;
import hibernate.HibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class FacturaHBM extends HibernateDAO{
    
    /** Creates a new instance of AgenciaHBM */
    public FacturaHBM() {
    }
    public List lista(){
        Criteria crit = session.createCriteria(Factura.class);     
      //  crit.addOrder(Order.asc("nombre"));
        return crit.list();
    }
   
    public Factura buscar(String num) {
        Criteria crit = session.createCriteria(Factura.class);
        crit.add(Restrictions.eq("numero",num));
            if(crit.list().size()>1)
            return null;
        else
            return (Factura)crit.uniqueResult();
    }
    
    public Factura buscarCl(String nombre) {
        Criteria crit = session.createCriteria(Factura.class);
        crit.add(Restrictions.eq("codigo",nombre));
            if(crit.list().size()>1)
            return null;
        else
            return (Factura)crit.uniqueResult();
    }
    
    
    
    
    public Factura buscaria(String cedula){
        Criteria crit = session.createCriteria(Factura.class);
        crit.add(Restrictions.eq("codigo",cedula));
        if(crit.list().size()>1){
            System.out.println("no hay ususario");
            return null;
        }
        else{
         //   System.out.println("si hay");
            return (Factura)crit.uniqueResult();
        }
    }
    
    public List lista2( Horario hora){
        Criteria crit = session.createCriteria(Factura.class);
          if ( hora!=null)
              crit.add(Restrictions.eq("horario",hora));
          return crit.list();
    }
    
    
    public List listarFecha(Date desde, Date hasta){
        Criteria crit = session.createCriteria(Factura.class);
        crit.add(Restrictions.between("fecha",desde,hasta));
        crit.addOrder(Order.asc("fecha"));
        return crit.list();
    }
    
}
