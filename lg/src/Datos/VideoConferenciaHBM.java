/*
 * VideoConferenciaHBM.java
 *
 * Created on 22 de noviembre de 2006, 23:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.VideoConferencia;
import beans.Horario;
import hibernate.HibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class VideoConferenciaHBM extends HibernateDAO{
    
    /** Creates a new instance of VideoConferenciaHBM */
    public VideoConferenciaHBM() {
    }
    
    public List lista2(){
        Criteria crit = session.createCriteria(VideoConferencia.class);
      //  crit.setMaxResults(150);
       crit.addOrder(Order.asc("id_Video"));
        return crit.list();
    }
    
    
    public List lista3(Horario hora){
        Criteria crit = session.createCriteria(VideoConferencia.class);
      //  crit.setMaxResults(150);
         if ( hora!=null)
           // crit.add(Restrictions.eq("agencia",age));
            crit.add(Restrictions.eq("horario",hora));
        crit.addOrder(Order.asc("id_Video"));
        return crit.list();
    }
    public List lista4(Date hora, Date anul){
        Criteria crit = session.createCriteria(VideoConferencia.class);
        if ( hora!=null && anul!=null )
            crit.add( Restrictions.between("fechaLlegada",hora,anul));
                     
           return crit.list();
           } 
    
}
