/*
 * VentaProductosHBM.java
 *
 * Created on 23 de octubre de 2006, 18:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Otros;
import beans.Horario;
import beans.VentaProductos;
import hibernate.HibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class VentaProductosHBM extends HibernateDAO{
    
    /** Creates a new instance of VentaProductosHBM */
    public VentaProductosHBM() {
    }
    
    
    public List lista22(){
        Criteria crit = session.createCriteria(VentaProductos.class);
        crit.addOrder(Order.asc("nombre"));
        return crit.list();
    }
    public List lista(){
        Criteria crit = session.createCriteria(VentaProductos.class);     
        crit.setMaxResults(1500);
        return crit.list();
    } 
        
    public List lista(Otros otro){
        Criteria crit = session.createCriteria(VentaProductos.class);
            if (otro!=null)
            crit.add(Restrictions.eq("otros",otro));
         return crit.list();
    }
    
    public List lista7(Boolean bo){
        Criteria crit = session.createCriteria(VentaProductos.class);
             crit.add(Restrictions.eq("pagado",bo));
         return crit.list();
    }
    
    public List lista2( Horario hora){
        Criteria crit = session.createCriteria(VentaProductos.class);
          if ( hora!=null)
              crit.add(Restrictions.eq("horario",hora));
          return crit.list();
    }
    
     public VentaProductos vendido(Otros otro, Horario hora){
        Criteria crit = session.createCriteria(VentaProductos.class);
        if (otro!=null && hora!=null)
            crit.add(Restrictions.eq("otros",otro));
            crit.add(Restrictions.eq("horario",hora));
         if(crit.list().size()>1)
            return null;
        else
            return (VentaProductos)crit.uniqueResult();
    }
      public List lista4(Date hora, Date anul){
        Criteria crit = session.createCriteria(VentaProductos.class);
        if ( hora!=null && anul!=null )
            crit.add( Restrictions.between("fechasalida",hora,anul));
                     
           return crit.list();
           } 
      
      
      public List lista3( String nom, Boolean bo){
        Criteria crit = session.createCriteria(VentaProductos.class);
        crit.add(Restrictions.eq("nombre",nom));
        crit.add(Restrictions.eq("pagado",bo));
        return crit.list();
    }
      
    public List lista4( String ced, Boolean bo){
        Criteria crit = session.createCriteria(VentaProductos.class);
        crit.add(Restrictions.eq("cedula",ced));
        crit.add(Restrictions.eq("pagado",bo));
        return crit.list();
    }
    
    public List lista4( int ced, Boolean bo){
        Criteria crit = session.createCriteria(VentaProductos.class);
        crit.add(Restrictions.eq("id_Venta",ced));
        crit.add(Restrictions.eq("pagado",bo));
        return crit.list();
    }
    
    public List lista5(Boolean bo, Horario hora){
        Criteria crit = session.createCriteria(VentaProductos.class);
        crit.add(Restrictions.eq("pagado",bo));
        crit.add(Restrictions.eq("horario",hora));
        return crit.list();
    }
     public List lista8( String nom, Horario hora){
        Criteria crit = session.createCriteria(VentaProductos.class);
        crit.add(Restrictions.eq("nombre",nom));
       crit.add(Restrictions.eq("horario",hora));
        return crit.list();
    }
     
     public List lista9( String nfac, Horario hora){
        Criteria crit = session.createCriteria(VentaProductos.class);
       if (nfac!=null && hora!=null)
       crit.add(Restrictions.eq("nfactura",nfac));
       crit.add(Restrictions.eq("horario",hora));
        return crit.list();
    }
     
      public List lista10(String nfac){
        Criteria crit = session.createCriteria(VentaProductos.class);
        if (nfac!=null)
        crit.add(Restrictions.eq("nfactura",nfac));
        return crit.list();
    }
     
     public VentaProductos habiliatr(Integer in){
        Criteria crit = session.createCriteria(VentaProductos.class);
            if (in!=null)
            crit.add(Restrictions.eq("id_Venta",in));
            if(crit.list().size()>1)
            return null;
        else
            return (VentaProductos)crit.uniqueResult();
    }
}
