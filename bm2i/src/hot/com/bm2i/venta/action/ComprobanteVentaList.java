package com.bm2i.venta.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.venta.model.ComprobanteVenta;

@Name("comprobanteVentaList")
public class ComprobanteVentaList extends EntityQuery<ComprobanteVenta> {

	private static final String EJBQL = "select comprobanteVenta from ComprobanteVenta comprobanteVenta";

	private static final String[] RESTRICTIONS = {"lower(comprobanteVenta.guiaRemision) like lower(concat(#{comprobanteVentaList.comprobanteVenta.guiaRemision},'%'))",};

	private ComprobanteVenta comprobanteVenta = new ComprobanteVenta();

	public ComprobanteVentaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ComprobanteVenta getComprobanteVenta() {
		return comprobanteVenta;
	}
}
