

package Datos;

import beans.Horario;
import beans.Otros;
import hibernate.HibernateDAO;
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
}