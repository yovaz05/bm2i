/*
 * HibernateDAO.java
 *
 * Created on 5 de marzo de 2006, 02:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package hibernate;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 *
 */
public class HibernateDAO {
 
    public static Session session = Configuracion.currentSession();
    public static Transaction tx = session.beginTransaction();
    
    public HibernateDAO(){
    }
    
     public boolean guardar(Object object) {
         try{
             if(!tx.isActive())
                 tx.begin();
             session.save(object);
             tx.commit();
         }
        catch (HibernateException he){
            he.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 
     * @param object 
     * @return 
     */
    public boolean eliminar(Object object) {
        try{
            if(!tx.isActive())
                tx.begin();
            session.delete(object);
            tx.commit();
        }
        catch (HibernateException he){
            return false;
        }
        return true;
    }

    /**
     * 
     * @param object 
     * @return 
     */
    public boolean actualizar(Object object) {
        try{
            if(!tx.isActive())
                tx.begin();
            session.update(object);
            tx.commit();
        }
        catch (HibernateException he){
            return false;
        }        
        return true;
    }
    public void cerrar(){
        Configuracion.closeSession();        
    }
}
