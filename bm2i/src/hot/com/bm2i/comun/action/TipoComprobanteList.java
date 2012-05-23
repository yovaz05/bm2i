package com.bm2i.comun.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.comun.model.TipoComprobante;

@Name("tipoComprobanteList")
public class TipoComprobanteList extends EntityQuery<TipoComprobante> {

	private static final String EJBQL = "select tipoComprobante from TipoComprobante tipoComprobante";

	private static final String[] RESTRICTIONS = {
			"lower(tipoComprobante.descripcion) like lower(concat(#{tipoComprobanteList.tipoComprobante.descripcion},'%'))",
			"lower(tipoComprobante.nombre) like lower(concat(#{tipoComprobanteList.tipoComprobante.nombre},'%'))",};

	private TipoComprobante tipoComprobante = new TipoComprobante();

	public TipoComprobanteList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public TipoComprobante getTipoComprobante() {
		return tipoComprobante;
	}
}
