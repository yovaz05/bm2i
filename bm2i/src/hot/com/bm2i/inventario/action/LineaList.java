package com.bm2i.inventario.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.inventario.model.Linea;

@Name("lineaList")
public class LineaList extends EntityQuery<Linea> {

	private static final String EJBQL = "select linea from Linea linea";

	private static final String[] RESTRICTIONS = {
			"lower(linea.codigo) like lower(concat(#{lineaList.linea.codigo},'%'))",
			"lower(linea.detalle) like lower(concat(#{lineaList.linea.detalle},'%'))",
			"lower(linea.nombre) like lower(concat(#{lineaList.linea.nombre},'%'))",};

	private Linea linea = new Linea();

	public LineaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Linea getLinea() {
		return linea;
	}
}
