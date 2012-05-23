package com.bm2i.inventario.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.inventario.model.Articulo;

@Name("articuloList")
public class ArticuloList extends EntityQuery<Articulo> {

	private static final String EJBQL = "select articulo from Articulo articulo";

	private static final String[] RESTRICTIONS = {
			"lower(articulo.codigoBarra) like lower(concat(#{articuloList.articulo.codigoBarra},'%'))",
			"lower(articulo.descripcion) like lower(concat(#{articuloList.articulo.descripcion},'%'))",
			"lower(articulo.nombre) like lower(concat(#{articuloList.articulo.nombre},'%'))",
			"lower(articulo.ubicacion) like lower(concat(#{articuloList.articulo.ubicacion},'%'))",
			"lower(articulo.unidad) like lower(concat(#{articuloList.articulo.unidad},'%'))",};

	private Articulo articulo = new Articulo();

	public ArticuloList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Articulo getArticulo() {
		return articulo;
	}
}
