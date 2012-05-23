package com.bm2i.comun.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.comun.model.Persona;

@Name("personaList")
public class PersonaList extends EntityQuery<Persona> {

	private static final String EJBQL = "select persona from Persona persona";

	private static final String[] RESTRICTIONS = {
			"lower(persona.apellidos) like lower(concat(#{personaList.persona.apellidos},'%'))",
			"lower(persona.nombres) like lower(concat(#{personaList.persona.nombres},'%'))",
			"lower(persona.numeroDiscapacidad) like lower(concat(#{personaList.persona.numeroDiscapacidad},'%'))",};

	private Persona persona = new Persona();

	public PersonaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Persona getPersona() {
		return persona;
	}
}
