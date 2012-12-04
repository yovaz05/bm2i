/*
 * ClientesHBM.java
 *
 * Created on 21 de septiembre de 2006, 18:31
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;
import beans.Clientes;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author ANtro
 */
public class ClientesHBM extends HibernateDAO{
    
    /** Creates a new instance of ClientesHBM */
    public ClientesHBM() {
    }
       public List lista(){
        Criteria crit = session.createCriteria(Clientes.class);     
        crit.addOrder(Order.asc("id"));
        return crit.list();
    }
    public Clientes busca(String cedula){
        Criteria crit = session.createCriteria(Clientes.class);
        crit.add(Restrictions.eq("cedula",cedula));
        if(crit.list().size()>1){
            System.out.println("no hay ususario");
            return null;
        }
        else{
            return (Clientes)crit.uniqueResult();
        }
    }
}
