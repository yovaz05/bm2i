package com.bm2i.venta.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.venta.model.CajaPermiso;

@Name("cajaPermisoList")
public class CajaPermisoList extends EntityQuery<CajaPermiso> {

	private static final String EJBQL = "select cajaPermiso from CajaPermiso cajaPermiso";

	private static final String[] RESTRICTIONS = {};

	private CajaPermiso cajaPermiso = new CajaPermiso();

	public CajaPermisoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public CajaPermiso getCajaPermiso() {
		return cajaPermiso;
	}
}
