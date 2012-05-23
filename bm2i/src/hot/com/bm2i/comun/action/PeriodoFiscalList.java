package com.bm2i.comun.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.comun.model.PeriodoFiscal;

@Name("periodoFiscalList")
public class PeriodoFiscalList extends EntityQuery<PeriodoFiscal> {

	private static final String EJBQL = "select periodoFiscal from PeriodoFiscal periodoFiscal";

	private static final String[] RESTRICTIONS = {"lower(periodoFiscal.nombre) like lower(concat(#{periodoFiscalList.periodoFiscal.nombre},'%'))",};

	private PeriodoFiscal periodoFiscal = new PeriodoFiscal();

	public PeriodoFiscalList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public PeriodoFiscal getPeriodoFiscal() {
		return periodoFiscal;
	}
}
