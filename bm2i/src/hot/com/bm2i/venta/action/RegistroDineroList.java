package com.bm2i.venta.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.venta.model.RegistroDinero;

@Name("registroDineroList")
public class RegistroDineroList extends EntityQuery<RegistroDinero> {

	private static final String EJBQL = "select registroDinero from RegistroDinero registroDinero";

	private static final String[] RESTRICTIONS = {};

	private RegistroDinero registroDinero = new RegistroDinero();

	public RegistroDineroList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public RegistroDinero getRegistroDinero() {
		return registroDinero;
	}
}
