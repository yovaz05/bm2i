/*
 * GiroHBM.java
 *
 * Created on 29 de septiembre de 2006, 11:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Giro;
import beans.Agencia;
import beans.Remplazo;
import beans.Horario;
import hibernate.HibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class GiroHBM extends HibernateDAO{

    /** Creates a new instance of GiroHBM */
    public GiroHBM() {
    }
   public List lista(){
        Criteria crit = session.createCriteria(Giro.class);     
        crit.addOrder(Order.desc("id"));
        return crit.list();
    }
   
   public List lista2(Agencia age,Horario hora){
        Criteria crit = session.createCriteria(Giro.class);
      //  crit.setMaxResults(150);
         if ( hora!=null && age!=null)
            crit.add(Restrictions.eq("agencia",age));
            crit.add(Restrictions.eq("horario",hora));
            crit.addOrder(Order.desc("clave"));
        //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
       
    }
   public List lista3(Horario hora){
        Criteria crit = session.createCriteria(Giro.class);
      //  crit.setMaxResults(150);
         if ( hora!=null)
           // crit.add(Restrictions.eq("agencia",age));
            crit.add(Restrictions.eq("horario",hora));
        //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
    }
   
   public List lista4(Boolean remp){
       
        Criteria crit = session.createCriteria(Giro.class);
        if ("remplazo"!=null)
              //crit.addOrder(Order.asc("Id_Giro"));
            crit.add(Restrictions.eq("rem",remp));
        
     return crit.list();
    }
   
   public List lista27(Agencia age){
       
        Criteria crit = session.createCriteria(Giro.class);
        crit.add(Restrictions.eq("agencia",age));
        
     return crit.list();
    }
     
   public List lista5(Boolean anul){
        Criteria crit = session.createCriteria(Giro.class);
        if ( "anulado"!=null)
              //crit.addOrder(Order.asc("Id_Giro"));
            crit.add(Restrictions.eq("anulado",anul));
        
     return crit.list();
    }
   
    public List lista17(Boolean anul, Agencia age){
        Criteria crit = session.createCriteria(Giro.class);
        if (anul!=null&& age!=null)
              //crit.addOrder(Order.asc("Id_Giro"));
            crit.add(Restrictions.eq("anulado",anul));
            crit.add(Restrictions.eq("agencia",age));
        
     return crit.list();
    }
   
 public List lista6(Boolean pag){
        Criteria crit = session.createCriteria(Giro.class);
        if ( "pagado"!=null)
              //crit.addOrder(Order.asc("Id_Giro"));
            crit.add(Restrictions.eq("pagado",pag));
        
     return crit.list();
    }
 
   public Giro busca(String clav){
        Criteria crit = session.createCriteria(Giro.class);
        crit.add(Restrictions.eq("clave",clav));
        if(crit.list().size()>1){
            System.out.println("no hay giro");
            return null;
        }
        else{
            return (Giro)crit.uniqueResult();
        }
    }
   
   public Giro busca2(String cod){
        Criteria crit = session.createCriteria(Giro.class);
        crit.add(Restrictions.eq("codigo",cod));
        if(crit.list().size()>1){
            System.out.println("no hay giro");
            return null;
        }
        else{
            return (Giro)crit.uniqueResult();
        }
    }
   
public List lista7(Agencia age){
        Criteria crit = session.createCriteria(Giro.class);
      //  crit.setMaxResults(150);
         if ( age!=null)
           // crit.add(Restrictions.eq("agencia",age));
            crit.add(Restrictions.eq("agencia",age));
        //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
}

   public List lista8(Horario hora, Boolean anul, Agencia age){
        Criteria crit = session.createCriteria(Giro.class);
      //  crit.setMaxResults(150);
         if ( hora!=null && anul!=null)
            crit.add(Restrictions.eq("horario",hora));
            crit.add(Restrictions.eq("anulado",anul));
            crit.add(Restrictions.eq("agencia",age));
            crit.addOrder(Order.desc("clave"));
      //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
       
    }   
   public List lista19(Horario hora, Agencia age){
        Criteria crit = session.createCriteria(Giro.class);
      //  crit.setMaxResults(150);
         if ( hora!=null)
            crit.add(Restrictions.eq("horario",hora));
            crit.add(Restrictions.eq("agencia",age));
            crit.addOrder(Order.desc("clave"));
      //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
       
    } 
   
   public List lista18(Horario hora, Boolean anul){
        Criteria crit = session.createCriteria(Giro.class);
      //  crit.setMaxResults(150);
         if ( hora!=null && anul!=null)
            crit.add(Restrictions.eq("horario",hora));
            crit.add(Restrictions.eq("anulado",anul));
            crit.addOrder(Order.desc("clave"));
      //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
       
    }   
   
   
   
   
   
    public List lista9(Horario hora, Boolean anul){
        Criteria crit = session.createCriteria(Giro.class);
      //  crit.setMaxResults(150);
         if ( hora!=null && anul!=null)
            crit.add(Restrictions.eq("horario",hora));
            crit.add(Restrictions.eq("pagado",anul));
            crit.addOrder(Order.desc("clave"));
        //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
       
    }   
    
     public List lista10(Agencia age, Horario hora, Boolean anul){
        Criteria crit = session.createCriteria(Giro.class);
      //  crit.setMaxResults(150);
         if ( age!=null && hora!=null && anul!=null )
            crit.add(Restrictions.eq("agencia",age));
            crit.add(Restrictions.eq("horario",hora));
            crit.add(Restrictions.eq("anulado",anul));
            crit.addOrder(Order.desc("clave"));
        //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
       
    }   
     public List lista11(Horario hora, Boolean anul){
        Criteria crit = session.createCriteria(Giro.class);
      //  crit.setMaxResults(150);
         if ( hora!=null && anul!=null)
            crit.add(Restrictions.eq("horario",hora));
            crit.add(Restrictions.eq("rem",anul));
            crit.addOrder(Order.desc("clave"));
        //crit.addOrder(Order.asc("idCreditoMercaderia"));
        return crit.list();
       
    }  
     
      public List lista12(Date hora, Date anul, Agencia age){
        Criteria crit = session.createCriteria(Giro.class);
        if ( hora!=null && anul!=null && age!=null)
            crit.add( Restrictions.between("fechaLlegada",hora,anul));
            crit.add(Restrictions.eq("agencia",age));
            
         
           return crit.list();
           }  
      
    public List lista13(Date hora, Date anul, Agencia age, Boolean rem){
        Criteria crit = session.createCriteria(Giro.class);
        if ( hora!=null && anul!=null && age!=null && rem!=false)
            crit.add( Restrictions.between("fechaLlegada",hora,anul));
            crit.add(Restrictions.eq("agencia",age));
            crit.add(Restrictions.eq("rem",rem));
            
           
           return crit.list();
       
    }    
    public List lista14(Date hora, Date anul, Agencia age, Boolean rem){
        Criteria crit = session.createCriteria(Giro.class);
        if ( hora!=null && anul!=null && age!=null && rem!=false)
            crit.add( Restrictions.between("fechaLlegada",hora,anul));
            crit.add(Restrictions.eq("agencia",age));
            crit.add(Restrictions.eq("anulado",rem));
            
           
           return crit.list();
       
    }    
    
    public List lista15(Date hora, Date anul, Agencia age, Boolean rem){
        Criteria crit = session.createCriteria(Giro.class);
        if ( hora!=null && anul!=null && age!=null && rem!=false)
            crit.add( Restrictions.between("fechaLlegada",hora,anul));
            crit.add(Restrictions.eq("agencia",age));
            crit.add(Restrictions.eq("pagado",rem));
            
              return crit.list();
       
    }    
      public List lista16(Date hora, Date anul, Boolean rem){
        Criteria crit = session.createCriteria(Giro.class);
        if ( hora!=null && anul!=null && rem!=false)
            crit.add( Restrictions.between("fechaLlegada",hora,anul));
            crit.add(Restrictions.eq("pagado",rem));
            
              return crit.list();
       
    }  
    public List lista20(Date hora, Date anul, Agencia age){
        Criteria crit = session.createCriteria(Giro.class);
        if ( hora!=null && anul!=null && age!=null)
            crit.add( Restrictions.between("fechaLlegada",hora,anul));
            crit.add(Restrictions.eq("agencia",age));
            
              return crit.list();
       
    } 
    
}
