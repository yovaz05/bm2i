package com.bm2i.security.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.security.Usuario;

@Name("userList")
public class UserList extends EntityQuery<Usuario> {

	private static final String EJBQL = "select user from Usuario user";

	private static final String[] RESTRICTIONS = {
			"lower(user.name) like lower(concat(#{userList.user.name},'%'))",
			 };

	private Usuario user = new Usuario();

	public UserList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	@Override
	public String getRestrictionLogicOperator() {
		return "or";
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	/*
	 * public Usuario getUsuario() { return user; }
	 */
}
