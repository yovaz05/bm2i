package com.bm2i.comun.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.comun.model.EntidadLegal;

@Name("entidadLegalList")
public class EntidadLegalList extends EntityQuery<EntidadLegal> {

	private static final String EJBQL = "select entidadLegal from EntidadLegal entidadLegal";

	private static final String[] RESTRICTIONS = {"lower(entidadLegal.codigo) like lower(concat(#{entidadLegalList.entidadLegal.codigo},'%'))",};

	private EntidadLegal entidadLegal = new EntidadLegal();

	public EntidadLegalList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public EntidadLegal getEntidadLegal() {
		return entidadLegal;
	}
}
