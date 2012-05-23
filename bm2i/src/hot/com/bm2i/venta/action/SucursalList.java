package com.bm2i.venta.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.venta.model.Sucursal;

@Name("sucursalList")
public class SucursalList extends EntityQuery<Sucursal> {

	private static final String EJBQL = "select sucursal from Sucursal sucursal";

	private static final String[] RESTRICTIONS = {"lower(sucursal.nombre) like lower(concat(#{sucursalList.sucursal.nombre},'%'))",};

	private Sucursal sucursal = new Sucursal();

	public SucursalList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Sucursal getSucursal() {
		return sucursal;
	}
}
