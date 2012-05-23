package com.bm2i.comun.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.comun.model.Direccion;

@Name("direccionList")
public class DireccionList extends EntityQuery<Direccion> {

	private static final String EJBQL = "select direccion from Direccion direccion";

	private static final String[] RESTRICTIONS = {
			"lower(direccion.calle) like lower(concat(#{direccionList.direccion.calle},'%'))",
			"lower(direccion.cuidad) like lower(concat(#{direccionList.direccion.cuidad},'%'))",
			"lower(direccion.numero) like lower(concat(#{direccionList.direccion.numero},'%'))",
			"lower(direccion.pais) like lower(concat(#{direccionList.direccion.pais},'%'))",
			"lower(direccion.telefonoCedular) like lower(concat(#{direccionList.direccion.telefonoCedular},'%'))",
			"lower(direccion.telefonoFijo) like lower(concat(#{direccionList.direccion.telefonoFijo},'%'))",};

	private Direccion direccion = new Direccion();

	public DireccionList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Direccion getDireccion() {
		return direccion;
	}
}
