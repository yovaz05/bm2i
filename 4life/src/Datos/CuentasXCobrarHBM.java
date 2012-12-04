/*
 * CuentasXCobrarHBM.java
 *
 * Created on 6 de noviembre de 2006, 22:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.CuentasXCobrar;
import beans.Horario;
import hibernate.HibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CuentasXCobrarHBM extends HibernateDAO{
  
    /** Creates a new instance of CuentasXCobrarHBM */
    public CuentasXCobrarHBM() {
    }
    
    public List lista3(Horario hora, Boolean gir){
        Criteria crit = session.createCriteria(CuentasXCobrar.class);
        if ( hora!=null)
            crit.add(Restrictions.eq("horario",hora));
            crit.add(Restrictions.eq("giros",gir));
        
        return crit.list();
    }
    
    public List lista5(Horario hora){
        Criteria crit = session.createCriteria(CuentasXCobrar.class);
        if ( hora!=null)
            crit.add(Restrictions.eq("horario",hora));
      
        
        return crit.list();
    }
        
    public List lista4(Date hora, Date anul){
        Criteria crit = session.createCriteria(CuentasXCobrar.class);
        if ( hora!=null && anul!=null )
            crit.add( Restrictions.between("fecha",hora,anul));
                     
           return crit.list();
           }
}
