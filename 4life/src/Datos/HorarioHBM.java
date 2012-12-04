/*
 * HorarioHBM.java
 *
 * Created on 27 de septiembre de 2006, 15:38
 */
package Datos;

import java.io.*;
import java.net.*;
import beans.Horario;
import beans.Usuario;
import hibernate.HibernateDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import java.util.Date;

/**
 *
 * @author ANtro
 * @version
 */
public class HorarioHBM extends HibernateDAO {

    public HorarioHBM() {
    }

    public List lista() {
        Criteria crit = session.createCriteria(Usuario.class);
        crit.addOrder(Order.asc("id"));
        return crit.list();
    }

    public Horario busca(Usuario user, Boolean se) {
        Criteria crit = session.createCriteria(Horario.class);
        crit.add(Restrictions.eq("usuario", user));
        crit.add(Restrictions.eq("secion", se));
        if (crit.list().size() > 1) {
            System.out.println("no hay ususario");
            return null;
        } else {
            return (Horario) crit.uniqueResult();
        }
    }

    public List lista2(Boolean se) {
        Criteria crit = session.createCriteria(Horario.class);
        crit.add(Restrictions.eq("secion", se));
        return crit.list();
    }

    public Horario buscar(Boolean ses) {
        Criteria crit = session.createCriteria(Horario.class);
        crit.add(Restrictions.eq("secion", ses));
        //crit.add(Restrictions.eq("fechaFin",dia));
        if (crit.list().size() > 1) {
            return null;
        } else {
            return (Horario) crit.uniqueResult();
        }
    }

    public Horario bus(Horario ses) {
        Criteria crit = session.createCriteria(Horario.class);
        crit.add(Restrictions.eq("id_Horario", ses.getId_Horario()));
        //crit.add(Restrictions.eq("fechaFin",dia));
        if (crit.list().size() > 1) {
            return null;
        } else {
            return (Horario) crit.uniqueResult();
        }
    }

    public List lista(Usuario so) {
        Criteria crit = session.createCriteria(Horario.class);
        crit.add(Restrictions.eq("usuario", so));
        crit.add(Restrictions.eq("fechaFin", null));
        return crit.list();
    }

    public Object getVer(Usuario so) {
        Criteria crit = session.createCriteria(Horario.class);
        //crit.setMaxResults(150);
        crit.add(Restrictions.eq("usuario", so));
        crit.add(Restrictions.eq("fechaFin", null));
        try {
            return crit.uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List lista4(Date hora, Date anul, Usuario bb) {
        Criteria crit = session.createCriteria(Horario.class);
        if (hora != null && anul != null && bb != null) {
            System.out.println("no es nada  nulo");
            crit.add(Restrictions.between("fechaInicio", hora, anul));
            crit.add(Restrictions.eq("usuario", bb));
            return crit.list();

        } else {
            System.out.println("todo es nulo");
            return null;
        }

    }
}
