/*
 * ChequesHBM.java
 *
 * Created on 29 de septiembre de 2006, 10:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Cheque;
import beans.Horario;
import hibernate.HibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ChequesHBM extends HibernateDAO{
    
    /** Creates a new instance of ChequesHBM */
public ChequesHBM() {
        
}
    
public List lista(){
        Criteria crit = session.createCriteria(Cheque.class);     
        crit.addOrder(Order.asc("id_Cheque"));
        return crit.list();
}
     
public Cheque busca(String cedula){
        Criteria crit = session.createCriteria(Cheque.class);
        crit.add(Restrictions.eq("cedula",cedula));
        if(crit.list().size()>1){
            System.out.println("no hay ususario");
            return null;
        }
        else{
            return (Cheque)crit.uniqueResult();
        }
 }

 public Cheque busca2(String che){
        Criteria crit = session.createCriteria(Cheque.class);
        crit.add(Restrictions.eq("numero",che));
        if(crit.list().size()>1){
        return null;
        }
        else{
            return (Cheque)crit.uniqueResult();
        }
    }
    
    
  public List lista3(Horario hora){
        Criteria crit = session.createCriteria(Cheque.class);
        if ( hora!=null)
        crit.add(Restrictions.eq("horario",hora));
        return crit.list();
 }
   
  public List lista4(Horario hora, Boolean bb, Boolean cierre){
        Criteria crit = session.createCriteria(Cheque.class);
        if ( hora!=null)
            crit.add(Restrictions.eq("horario",hora));
            crit.add(Restrictions.eq("protestado",bb));
             crit.add(Restrictions.eq("lgtrasmiter",cierre));
        return crit.list();
 }
   public List lista11(Horario hora, Boolean bb){
        Criteria crit = session.createCriteria(Cheque.class);
        if ( hora!=null)
            crit.add(Restrictions.eq("horario",hora));
            crit.add(Restrictions.eq("protestado",bb));
           
        return crit.list();
 }    
  
  
  
    public List lista7(Horario hora, Boolean bb){
        Criteria crit = session.createCriteria(Cheque.class);
        if ("giro"!=null)
        crit.add(Restrictions.eq("horario",hora));
        crit.add(Restrictions.eq("protestado",bb));
        return crit.list();
    } 
 
    public List lista8(Horario hora, Boolean bb){
        Criteria crit = session.createCriteria(Cheque.class);
        if ("giro"!=null)
        crit.add(Restrictions.eq("horario",hora));
        crit.add(Restrictions.eq("lgtrasmiter",bb));
        return crit.list();
    } 
     
    public List lista5(Date hora, Date anul){
        Criteria crit = session.createCriteria(Cheque.class);
        if ( hora!=null && anul!=null )
            crit.add( Restrictions.between("fecha",hora,anul));
                     
           return crit.list();
           } 
    
    public List lista9(Date hora, Date anul, Boolean a){
        Criteria crit = session.createCriteria(Cheque.class);
        if ( hora!=null && anul!=null )
            crit.add( Restrictions.between("fecha",hora,anul));
            crit.add(Restrictions.eq("protestado",a));         
           return crit.list();
           } 

     public List lista6(Date hora, Date anul, Boolean bb){
        Criteria crit = session.createCriteria(Cheque.class);
        if ( hora!=null && anul!=null )
            crit.add( Restrictions.between("fecha",hora,anul));
            crit.add(Restrictions.eq("protestado",bb));
                     
           return crit.list();
           } 
}
