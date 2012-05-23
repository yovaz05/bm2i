package com.bm2i.comun.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.comun.model.SystemParameter;

@Name("systemParameterList")
public class SystemParameterList extends EntityQuery<SystemParameter> {

	private static final String EJBQL = "select systemParameter from SystemParameter systemParameter";

	private static final String[] RESTRICTIONS = {
			"lower(systemParameter.nombre) like lower(concat(#{systemParameterList.systemParameter.nombre},'%'))",
			"lower(systemParameter.className) like lower(concat(#{systemParameterList.systemParameter.className},'%'))",
			"lower(systemParameter.descripcion) like lower(concat(#{systemParameterList.systemParameter.descripcion},'%'))",
			"lower(systemParameter.valor) like lower(concat(#{systemParameterList.systemParameter.valor},'%'))",};

	private SystemParameter systemParameter = new SystemParameter();

	public SystemParameterList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public SystemParameter getSystemParameter() {
		return systemParameter;
	}
}
