

package Datos;

import beans.Horario;
import beans.Otros;
import beans.Linea;
import hibernate.HibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class OtrosHBM extends HibernateDAO{
    
public OtrosHBM() {
}
    
public List lista(){
        Criteria crit = session.createCriteria(Otros.class);     
        crit.addOrder(Order.asc("nombre"));
        return crit.list();
}
          
public List lista3(Horario hora){
        Criteria crit = session.createCriteria(Otros.class);
        if ( hora!=null)
        crit.add(Restrictions.eq("horario",hora));
        return crit.list();
}
  public List lista2(Linea reg){
        Criteria crit = session.createCriteria(Otros.class);
      //  crit.setMaxResults(150);
         if ( reg!=null){
            crit.add(Restrictions.eq("linea",reg));
            return crit.list();
         }return null;
    }
   public List listarFecha(Date desde, Date hasta){
        Criteria crit = session.createCriteria(Otros.class);
        if ( desde!=null && hasta!=null )
        crit.add(Restrictions.between("fechaLlegada",desde,hasta));
        //crit.addOrder(Order.asc("fecha"));
        return crit.list();
        
    }
  
  
  
}
