package com.bm2i.venta.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.venta.model.ItemComprobanteVenta;

@Name("itemComprobanteVentaList")
public class ItemComprobanteVentaList extends EntityQuery<ItemComprobanteVenta> {

	private static final String EJBQL = "select itemComprobanteVenta from ItemComprobanteVenta itemComprobanteVenta";

	private static final String[] RESTRICTIONS = {};

	private ItemComprobanteVenta itemComprobanteVenta = new ItemComprobanteVenta();

	public ItemComprobanteVentaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ItemComprobanteVenta getItemComprobanteVenta() {
		return itemComprobanteVenta;
	}
}
