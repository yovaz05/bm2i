package com.bm2i.venta.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.venta.model.RegistroVenta;

@Name("registroVentaList")
public class RegistroVentaList extends EntityQuery<RegistroVenta> {

	private static final String EJBQL = "select registroVenta from RegistroVenta registroVenta";

	private static final String[] RESTRICTIONS = {"lower(registroVenta.hora) like lower(concat(#{registroVentaList.registroVenta.hora},'%'))",};

	private RegistroVenta registroVenta = new RegistroVenta();

	public RegistroVentaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public RegistroVenta getRegistroVenta() {
		return registroVenta;
	}
}
