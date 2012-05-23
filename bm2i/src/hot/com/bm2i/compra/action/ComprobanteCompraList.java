package com.bm2i.compra.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.compra.model.ComprobanteCompra;

@Name("comprobanteCompraList")
public class ComprobanteCompraList extends EntityQuery<ComprobanteCompra> {

	private static final String EJBQL = "select comprobanteCompra from ComprobanteCompra comprobanteCompra";

	private static final String[] RESTRICTIONS = {"lower(comprobanteCompra.guiaRemision) like lower(concat(#{comprobanteCompraList.comprobanteCompra.guiaRemision},'%'))",};

	private ComprobanteCompra comprobanteCompra = new ComprobanteCompra();

	public ComprobanteCompraList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ComprobanteCompra getComprobanteCompra() {
		return comprobanteCompra;
	}
}
