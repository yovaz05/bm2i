package com.bm2i.inventario.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.inventario.model.Inventario;

@Name("inventarioList")
public class InventarioList extends EntityQuery<Inventario> {

	private static final String EJBQL = "select inventario from Inventario inventario";

	private static final String[] RESTRICTIONS = {};

	private Inventario inventario = new Inventario();

	public InventarioList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Inventario getInventario() {
		return inventario;
	}
}
