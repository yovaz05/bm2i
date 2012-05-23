package com.bm2i.inventario.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.inventario.model.Generico;

@Name("genericoList")
public class GenericoList extends EntityQuery<Generico> {

	private static final String EJBQL = "select generico from Generico generico";

	private static final String[] RESTRICTIONS = {};

	private Generico generico = new Generico();

	public GenericoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Generico getGenerico() {
		return generico;
	}
}
