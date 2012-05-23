package com.bm2i.comun.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.comun.model.TasaImpuesto;

@Name("tasaImpuestoList")
public class TasaImpuestoList extends EntityQuery<TasaImpuesto> {

	private static final String EJBQL = "select tasaImpuesto from TasaImpuesto tasaImpuesto";

	private static final String[] RESTRICTIONS = {};

	private TasaImpuesto tasaImpuesto = new TasaImpuesto();

	public TasaImpuestoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public TasaImpuesto getTasaImpuesto() {
		return tasaImpuesto;
	}
}
