/*
 * UsuarioHBM.java
 *
 * Created on 20 de septiembre de 2006, 12:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import beans.Usuario;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**p
 *
 * @author ANtro
 */
public class UsuarioHBM extends HibernateDAO{
    
    /** Creates a new instance of UsuarioHBM */
    public UsuarioHBM() {
    }
    
    public List lista(){
        Criteria crit = session.createCriteria(Usuario.class);     
        crit.addOrder(Order.asc("id"));
        return crit.list();
    }
 

    
    
  public Usuario buscar(String nombre,String clave) {
        Criteria crit = session.createCriteria(Usuario.class);
        crit.add(Restrictions.eq("loguin",nombre));
         crit.add(Restrictions.eq("password",clave));
        if(crit.list().size()>1)
            return null;
        else
            return (Usuario)crit.uniqueResult();
    }
  
  
    public Usuario getuser(String nombre,String cla){
        Criteria crit = session.createCriteria(Usuario.class);
        if (nombre!=null)
            crit.add(Restrictions.eq("loguin",nombre));
        if (cla !=null)
            crit.add(Restrictions.eq("password",cla));
        
        if(crit.list().size()>1)
            return null;
        else        
            return (Usuario)crit.uniqueResult();
    }
    
    
    
    
}
