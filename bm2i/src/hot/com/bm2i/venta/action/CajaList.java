package com.bm2i.venta.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.venta.model.Caja;

@Name("cajaList")
public class CajaList extends EntityQuery<Caja> {

	private static final String EJBQL = "select caja from Caja caja";

	private static final String[] RESTRICTIONS = {"lower(caja.nombre) like lower(concat(#{cajaList.caja.nombre},'%'))",};

	private Caja caja = new Caja();

	public CajaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Caja getCaja() {
		return caja;
	}
}
