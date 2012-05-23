package com.bm2i.inventario.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.inventario.model.Ganancia;

@Name("gananciaList")
public class GananciaList extends EntityQuery<Ganancia> {

	private static final String EJBQL = "select ganancia from Ganancia ganancia";

	private static final String[] RESTRICTIONS = {"lower(ganancia.nombre) like lower(concat(#{gananciaList.ganancia.nombre},'%'))",};

	private Ganancia ganancia = new Ganancia();

	public GananciaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Ganancia getGanancia() {
		return ganancia;
	}
}
