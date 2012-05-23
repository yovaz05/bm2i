package com.bm2i.inventario.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.inventario.model.Precio;

@Name("precioList")
public class PrecioList extends EntityQuery<Precio> {

	private static final String EJBQL = "select precio from Precio precio";

	private static final String[] RESTRICTIONS = {};

	private Precio precio = new Precio();

	public PrecioList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Precio getPrecio() {
		return precio;
	}
}
