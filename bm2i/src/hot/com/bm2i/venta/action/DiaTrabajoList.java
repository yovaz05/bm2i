package com.bm2i.venta.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.venta.model.DiaTrabajo;

@Name("diaTrabajoList")
public class DiaTrabajoList extends EntityQuery<DiaTrabajo> {

	private static final String EJBQL = "select diaTrabajo from DiaTrabajo diaTrabajo";

	private static final String[] RESTRICTIONS = {"lower(diaTrabajo.observacion) like lower(concat(#{diaTrabajoList.diaTrabajo.observacion},'%'))",};

	private DiaTrabajo diaTrabajo = new DiaTrabajo();

	public DiaTrabajoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public DiaTrabajo getDiaTrabajo() {
		return diaTrabajo;
	}
}
