package com.bm2i.security.action;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.model.Persona;
import com.bm2i.security.Role;
import com.bm2i.security.Usuario;

@Name("userHome")
public class UserHome extends EntityHome<Usuario> {

	@In(create = true)
	PasswordManager passwordManager;
	private Persona persona = new Persona();
	private String password;

	public void setUserId(Long id) {
		setId(id);
	}

	public Long getUserId() {
		return (Long) getId();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	protected Usuario createInstance() {
		Usuario user = new Usuario();
		return user;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Usuario getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Role> getRoles() {
		return getInstance() == null ? null : new ArrayList<Role>(getInstance()
				.getRoles());
	}

	public List<Role> searchRoleByName(Object suggest) {
		String q = "SELECT role FROM Role role WHERE LOWER(role.name)LIKE CONCAT(LOWER(:suggest),'%'))";
		Query e = this.getEntityManager().createQuery(q);
		e.setParameter("suggest", (String) suggest);
		return (List<Role>) e.getResultList();
	}

	public void addRole(Role role) {
		getInstance().add(role);
	}

	public void removeRole(Role role) {
		getInstance().remove(role);
	}

	/*@Override
	public String persist() {
		String pass = password.trim();
		//getInstance().setPassword(passwordManager.hash(pass));

		return super.persist();
	}

	@Override
	public String update() {
		String pass = password.trim();
		//getInstance().setPassword(passwordManager.hash(pass));

		return super.update();
	}*/

	@SuppressWarnings("unchecked")
	public List<Persona> findPersona(Object suggest) {
		String pref = (String) suggest;
		Query query = this.getEntityManager().createNamedQuery(
				"Persona.findByCriteria");
		query.setParameter("criteria", pref);
		return query.getResultList();
	}

	public void cargarPersona(Persona persona) {
		if (persona != null) {
			this.persona = persona;
			this.getInstance().setPersona(persona);
		}
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}