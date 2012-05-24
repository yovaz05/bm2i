package com.bm2i.comun.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.comun.model.Resident;

@Name("residentList")
public class ResidentList extends EntityQuery<Resident> {

	private static final String EJBQL = "select resident from Resident resident";

	private static final String[] RESTRICTIONS = {
			"lower(resident.nombre) like lower(concat(#{residentList.criteria},'%'))",
			"lower(resident.numeroIdentificacion) like lower(concat(#{residentList.criteria},'%'))", };

	// private Resident resident = new Persona();
	String criteria;

	public ResidentList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	@Override
	public String getRestrictionLogicOperator() {
		return "or";
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
}
