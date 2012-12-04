
package Datos;

import beans.Horario;
import beans.Remplazo;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import hibernate.HibernateDAO;

public class RemplazoHBM extends HibernateDAO{
    
    /** Creates a new instance of RemplazoHBM */
    public RemplazoHBM() {
    }
    
    public List lista2(Horario ho){
        Criteria crit = session.createCriteria(Remplazo.class);     
         crit.add(Restrictions.eq("horario" ,ho));
         crit.addOrder(Order.asc("id_Remplazo"));
        return crit.list();
    } 
}
