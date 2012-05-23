package com.bm2i.action;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

import com.bm2i.comun.model.Persona;
import com.bm2i.security.Usuario;
import com.bm2i.security.action.UserSession;
import com.bm2i.venta.model.DiaTrabajo;

@Stateless
@Name("authenticator")
public class AuthenticatorBean implements Authenticator {
	@Logger
	private Log log;

	@In
	Identity identity;
	@In
	Credentials credentials;

	@In(create = true)
	UserSession userSession;

	@PersistenceContext
	private EntityManager entityManager;

	public boolean authenticate() {
		// slog.info("authenticating {0}", credentials.getUsername());
		// write your authentication logic here,
		// return true if the authentication was
		// successful, false otherwise

		/*
		 * if ("admin".equals(credentials.getUsername())) {
		 * identity.addRole("admin"); return true; } return false;
		 */

		return isUserValid();
	}

	@SuppressWarnings("unused")
	private Boolean isUserValid() {
		try {
			Query query = entityManager
					.createNamedQuery("Usuario.findByUsernameAndPassword");
			query.setParameter("name", credentials.getUsername());
			// query.setParameter("password",
			// passwordManager.hash(credentials.getPassword()));
			query.setParameter("password", credentials.getPassword());
			Usuario user = (Usuario) query.getSingleResult();
			if (user != null) {
				query = entityManager
						.createNamedQuery("Usuario.findPersonByUserId");
				query.setParameter("userId", user.getId());
				Persona persona = (Persona) query.getSingleResult();
				userSession.setUsuario(user);
				userSession.setPersona(persona);
				//initializeCurrentDiaTrabajo(persona);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void initializeCurrentDiaTrabajo(Persona persona) {
		Query query = entityManager
				.createNamedQuery("DiaTrabajo.findActiveByPersona");
		query.setParameter("persona", persona);
		query.setParameter("fecha", new Date());
		List<DiaTrabajo> list = query.getResultList();
		if (list.size() > 0) {
			DiaTrabajo dt = list.get(0);
			userSession.setDiaTrabajo(dt);
		}
	}

}
