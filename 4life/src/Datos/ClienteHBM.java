/*
 * ClienteHBM.java
 *
 * Created on 29 de septiembre de 2006, 13:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Datos;

import beans.Cliente;
import beans.Cliente;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ClienteHBM extends HibernateDAO {

    /**
     * Creates a new instance of ClienteHBM
     */
    public ClienteHBM() {
    }

    public List lista() {
        Criteria crit = session.createCriteria(Cliente.class);
        crit.addOrder(Order.asc("cedularuc"));
        return crit.list();
    }

    public List<Cliente> buscarNombres(String nombre) {
        Criteria crit = session.createCriteria(Cliente.class);
        crit.add(Restrictions.like("nombre", nombre + "%"));
        return crit.list();
    }

    public Cliente buscarCodigoCliente(String codigo) {
        Criteria crit = session.createCriteria(Cliente.class);
        crit.add(Restrictions.eq("codigocliente", codigo));
        if (crit.list().size() > 1) {
            return null;
        } else {
            return (Cliente) crit.uniqueResult();
        }
    }

    public Cliente buscaCedula(String cedula) {
        Criteria crit = session.createCriteria(Cliente.class);
        crit.add(Restrictions.eq("cedularuc", cedula));
        if (crit.list().size() > 1) {
            return null;
        } else {
            return (Cliente) crit.uniqueResult();
        }
    }
}
