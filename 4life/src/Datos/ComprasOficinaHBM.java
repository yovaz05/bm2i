/*
 * ComprasOficinaHBM.java
 *
 * Created on 7 de noviembre de 2006, 14:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.ComprasOficina;
import beans.Horario;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ComprasOficinaHBM extends HibernateDAO{
    
    public ComprasOficinaHBM() {
   
    }
    
    public List lista3(Horario hora, Boolean a){
            Criteria crit = session.createCriteria(ComprasOficina.class);
            if ( hora!=null)
                 crit.add(Restrictions.eq("horario",hora));
                 crit.add(Restrictions.eq("gmt",a));
                 return crit.list();
                               }
    }
