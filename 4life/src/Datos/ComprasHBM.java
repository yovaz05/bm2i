/*
 * ComprasHBM.java
 *
 * Created on 11 de enero de 2007, 19:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Horario;
import beans.Compras;
import beans.Provedor;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ComprasHBM extends HibernateDAO{
    
    /** Creates a new instance of ComprasHBM */
    public ComprasHBM() {
    }
   public List lista(){
        Criteria crit = session.createCriteria(Compras.class);     
        crit.addOrder(Order.asc("unidades"));
        return crit.list();
}
          
public List lista1(Horario hora){
        Criteria crit = session.createCriteria(Compras.class);
        if ( hora!=null)
        crit.add(Restrictions.eq("horario",hora));
        return crit.list();
}

public List lista12(Provedor prov){
        Criteria crit = session.createCriteria(Compras.class);
        if ( prov!=null)
        crit.add(Restrictions.eq("provedor",prov));
        return crit.list();
}


public List lista2(Boolean cre){
        Criteria crit = session.createCriteria(Compras.class);
        crit.add(Restrictions.eq("credito",cre));
        return crit.list();
}
}
