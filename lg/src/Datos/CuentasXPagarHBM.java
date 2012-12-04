/*
 * CuentasXPagarHBM.java
 *
 * Created on 7 de noviembre de 2006, 1:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.CuentasXPagar;
import beans.Horario;
import hibernate.HibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CuentasXPagarHBM extends HibernateDAO{
    
    /** Creates a new instance of CuentasXPagarHBM */
    public CuentasXPagarHBM() {
    }
    public List lista3(Horario hora, Boolean pago){
        Criteria crit = session.createCriteria(CuentasXPagar.class);
          if ( hora!=null)
              crit.add(Restrictions.eq("horario",hora));
             crit.add(Restrictions.eq("pagado",pago));
       return crit.list();
    }
    
    
    public List lista9(Horario hora, Boolean pago){
        Criteria crit = session.createCriteria(CuentasXPagar.class);
          if ( hora!=null)
              crit.add(Restrictions.eq("horario",hora));
             crit.add(Restrictions.eq("mt",pago));
       return crit.list();
    }
    
    
    
    public List lista6(Horario hora,Boolean giro){
        Criteria crit = session.createCriteria(CuentasXPagar.class);
          if ( hora!=null)
              crit.add(Restrictions.eq("horario",hora));
              crit.add(Restrictions.eq("giros",giro));
           return crit.list();
    }
    
    
    public CuentasXPagar busca(String clav){
        Criteria crit = session.createCriteria(CuentasXPagar.class);
        crit.add(Restrictions.eq("ordenar",clav));
        if(crit.list().size()>1){
            System.out.println("no hay nada");
            return null;
        }
        else{
            return (CuentasXPagar)crit.uniqueResult();
        }
    }
    public CuentasXPagar busca2(String clav){
        Criteria crit = session.createCriteria(CuentasXPagar.class);
        crit.add(Restrictions.eq("envio",clav));
        if(crit.list().size()>1){
            System.out.println("no hay nada");
            return null;
        }
        else{
            return (CuentasXPagar)crit.uniqueResult();
        }
    }
    
    public List lista(String clav){
        Criteria crit = session.createCriteria(CuentasXPagar.class);
        crit.add(Restrictions.eq("nombre",clav));
        return crit.list();
    }
    public List lista2(int clav){
        Criteria crit = session.createCriteria(CuentasXPagar.class);
        crit.add(Restrictions.eq("id_XPagar",clav));
        return crit.list();
    }
     public List lista3(String clav){
        Criteria crit = session.createCriteria(CuentasXPagar.class);
        crit.add(Restrictions.eq("envio",clav));
        return crit.list();
    }
     public List lista4(Date hora, Date anul){
        Criteria crit = session.createCriteria(CuentasXPagar.class);
        if ( hora!=null && anul!=null )
            crit.add( Restrictions.between("fechaLlegada",hora,anul));
                     
           return crit.list();
           } 
     
     
}
