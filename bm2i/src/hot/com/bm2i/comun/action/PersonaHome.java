package com.bm2i.comun.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.model.Persona;

@Name("personaHome")
public class PersonaHome extends EntityHome<Persona> {

	public void setPersonaId(Long id) {
		setId(id);
	}

	public Long getPersonaId() {
		return (Long) getId();
	}

	@Override
	protected Persona createInstance() {
		Persona persona = new Persona();
		return persona;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Persona getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
