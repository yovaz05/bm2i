package com.bm2i.comun.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.comun.model.Impuesto;

@Name("impuestoList")
public class ImpuestoList extends EntityQuery<Impuesto> {

	private static final String EJBQL = "select impuesto from Impuesto impuesto";

	private static final String[] RESTRICTIONS = {"lower(impuesto.nombre) like lower(concat(#{impuestoList.impuesto.nombre},'%'))",};

	private Impuesto impuesto = new Impuesto();

	public ImpuestoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Impuesto getImpuesto() {
		return impuesto;
	}
}
