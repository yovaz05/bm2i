package com.bm2i.inventario.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.inventario.model.TipoRegistro;

@Name("tipoRegistroList")
public class TipoRegistroList extends EntityQuery<TipoRegistro> {

	private static final String EJBQL = "select tipoRegistro from TipoRegistro tipoRegistro";

	private static final String[] RESTRICTIONS = {"lower(tipoRegistro.nombre) like lower(concat(#{tipoRegistroList.tipoRegistro.nombre},'%'))",};

	private TipoRegistro tipoRegistro = new TipoRegistro();

	public TipoRegistroList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public TipoRegistro getTipoRegistro() {
		return tipoRegistro;
	}
}
