package com.bm2i.comun.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.comun.model.Persona;
import com.bm2i.comun.model.Resident;

@Name("residentList")
public class ResidentList extends EntityQuery<Resident> {

	private static final String EJBQL = "select resident from Resident resident";

	private static final String[] RESTRICTIONS = {
			"lower(resident.email) like lower(concat(#{residentList.resident.email},'%'))",
			"lower(resident.nombre) like lower(concat(#{residentList.resident.nombre},'%'))",
			"lower(resident.numeroIdentificacion) like lower(concat(#{residentList.resident.numeroIdentificacion},'%'))",};

	private Resident resident = new Persona();

	public ResidentList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Resident getResident() {
		return resident;
	}
}
