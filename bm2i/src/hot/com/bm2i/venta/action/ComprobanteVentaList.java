package com.bm2i.venta.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.venta.model.ComprobanteVenta;

@Name("comprobanteVentaList")
public class ComprobanteVentaList extends EntityQuery<ComprobanteVenta> {

	private static final String EJBQL = "select comprobanteVenta from ComprobanteVenta comprobanteVenta";

	private static final String[] RESTRICTIONS = {
			"comprobanteVenta.numero = #{comprobanteVentaList.comprobanteVenta.numero}",
			"lower(comprobanteVenta.resident.nombre) like lower(concat('%',#{comprobanteVentaList.residentName}, '%'))", };

	private ComprobanteVenta comprobanteVenta = new ComprobanteVenta();
	private String residentName;

	public ComprobanteVentaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ComprobanteVenta getComprobanteVenta() {
		return comprobanteVenta;
	}

	public String getResidentName() {
		return residentName;
	}

	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}

	@Override
	public String getRestrictionLogicOperator() {
		return "or";
	}

}
