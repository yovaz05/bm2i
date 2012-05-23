package com.bm2i.venta.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.venta.model.Pago;

@Name("pagoList")
public class PagoList extends EntityQuery<Pago> {

	private static final String EJBQL = "select pago from Pago pago";

	private static final String[] RESTRICTIONS = {};

	private Pago pago = new Pago();

	public PagoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Pago getPago() {
		return pago;
	}
}
