package com.bm2i.security.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.security.Action;
import com.bm2i.security.Permission;
import com.bm2i.security.Role;
import com.bm2i.security.Usuario;

@Name("roleHome")
public class RoleHome extends EntityHome<Role> {

	@In
	EntityManager entityManager;

	public void setRoleId(Long id) {
		setId(id);
	}

	public Long getRoleId() {
		return (Long) getId();
	}

	@Override
	protected Role createInstance() {
		Role role = new Role();
		return role;
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

	public Role getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public void addUser(Usuario user) {
		getInstance().add(user);
	}

	public void removeUser(Usuario user) {
		getInstance().remove(user);
	}

	public List<Usuario> getUsers() {
		return getInstance() == null ? null : new ArrayList<Usuario>(
				getInstance().getUsers());
	}

	public List<Usuario> searchUserByNameOrIdentifierOrResidentName(
			Object suggest) {
		String q = "SELECT user FROM Usuario user "
				+ "WHERE LOWER(user.name)LIKE CONCAT(LOWER(:suggest),'%') "
				+ " OR LOWER(user.person.nombre) LIKE CONCAT(lower(:suggest),'%') "
				+ " OR LOWER(user.person.identificationNumber) LIKE CONCAT(lower(:suggest),'%'))";
		Query e = entityManager.createQuery(q);
		e.setParameter("suggest", (String) suggest);
		return (List<Usuario>) e.getResultList();
	}

	public List<Action> searchActionByName(Object suggest) {
		String q = "SELECT a FROM Action a "
				+ "WHERE LOWER(a.name)LIKE CONCAT(LOWER(:suggest),'%') ";
		Query e = entityManager.createQuery(q);
		e.setParameter("suggest", (String) suggest);
		return (List<Action>) e.getResultList();
	}

	public void addAction(Action action) {
		Permission p = new Permission();
		p.setAction(action);
		p.setExpirationDate(new Date());
		getInstance().add(p);
	}

	public void removeAction(Permission p) {
		getInstance().remove(p);
	}

}
