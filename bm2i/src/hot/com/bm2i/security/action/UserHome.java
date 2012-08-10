package com.bm2i.security.action;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.action.ResidentHome;
import com.bm2i.comun.model.Persona;
import com.bm2i.security.Role;
import com.bm2i.security.Usuario;

@Name("userHome")
public class UserHome extends EntityHome<Usuario> {

	@In(create = true)
	PasswordManager passwordManager;
	private Persona persona = new Persona();

	@In(create = true)
	ResidentHome residentHome;

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
		if (this.getInstance().getId() != null) {
			persona = this.getInstance().getPersona();
			if (persona == null) {
				persona = new Persona();
			}
		}
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

	/*
	 * @Override public String persist() { String pass = password.trim();
	 * //getInstance().setPassword(passwordManager.hash(pass));
	 * 
	 * return super.persist(); }
	 * 
	 * @Override public String update() { String pass = password.trim();
	 * //getInstance().setPassword(passwordManager.hash(pass));
	 * 
	 * return super.update(); }
	 */

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

	public void buscarCedula() {
		Query q = this.getEntityManager().createNamedQuery(
				"Persona.findPersonaByCedula");
		q.setParameter("cedula", this.persona.getNumeroIdentificacion());

		if (q.getResultList().size() > 0) {
			this.persona = (Persona) q.getSingleResult();

			Query q2 = this.getEntityManager().createNamedQuery(
					"Usuario.findUsuarioByPersona");
			q2.setParameter("persona", this.persona);

			if (q2.getResultList().size() > 0) {
				this.setInstance((Usuario) q2.getSingleResult());
			}
		}
		System.out.println("===================== " + q.getResultList().size()
				+ "    " + this.persona.getNumeroIdentificacion());

	}

	@Override
	public String persist() {
		this.persona.setNombre(this.persona.toString());
		this.getInstance().setPersona(persona);
		return super.persist();
	}

	@Override
	public String update() {
		this.persona.setNombre(this.persona.toString());
		this.getInstance().setPersona(persona);
		return super.update();
	}

	@Override
	public String remove() {
		// TODO Auto-generated method stub
		/*
		 * this.getInstance().setPersona(null); this.persona = new Persona();
		 */
		return super.remove();
	}

}
