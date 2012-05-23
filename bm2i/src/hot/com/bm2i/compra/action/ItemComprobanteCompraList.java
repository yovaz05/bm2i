package com.bm2i.compra.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.compra.model.ItemComprobanteCompra;

@Name("itemComprobanteCompraList")
public class ItemComprobanteCompraList
		extends
			EntityQuery<ItemComprobanteCompra> {

	private static final String EJBQL = "select itemComprobanteCompra from ItemComprobanteCompra itemComprobanteCompra";

	private static final String[] RESTRICTIONS = {};

	private ItemComprobanteCompra itemComprobanteCompra = new ItemComprobanteCompra();

	public ItemComprobanteCompraList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ItemComprobanteCompra getItemComprobanteCompra() {
		return itemComprobanteCompra;
	}
}
