package com.bm2i.comun.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.comun.model.Institucion;

@Name("institucionList")
public class InstitucionList extends EntityQuery<Institucion> {

	private static final String EJBQL = "select institucion from Institucion institucion";

	private static final String[] RESTRICTIONS = {
			"lower(institucion.direccion) like lower(concat(#{institucionList.institucion.direccion},'%'))",
			"lower(institucion.fax) like lower(concat(#{institucionList.institucion.fax},'%'))",
			"lower(institucion.nombre) like lower(concat(#{institucionList.institucion.nombre},'%'))",
			"lower(institucion.ruc) like lower(concat(#{institucionList.institucion.ruc},'%'))",
			"lower(institucion.slogan) like lower(concat(#{institucionList.institucion.slogan},'%'))",
			"lower(institucion.telefono) like lower(concat(#{institucionList.institucion.telefono},'%'))",};

	private Institucion institucion = new Institucion();

	public InstitucionList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Institucion getInstitucion() {
		return institucion;
	}
}
