package com.bm2i.venta.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.venta.model.TipoPago;

@Name("tipoPagoList")
public class TipoPagoList extends EntityQuery<TipoPago> {

	private static final String EJBQL = "select tipoPago from TipoPago tipoPago";

	private static final String[] RESTRICTIONS = {"lower(tipoPago.nombre) like lower(concat(#{tipoPagoList.tipoPago.nombre},'%'))",};

	private TipoPago tipoPago = new TipoPago();

	public TipoPagoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}
}
