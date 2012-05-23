package com.bm2i.comun.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.model.Institucion;

@Name("institucionHome")
public class InstitucionHome extends EntityHome<Institucion> {

	public void setInstitucionId(Long id) {
		setId(id);
	}

	public Long getInstitucionId() {
		return (Long) getId();
	}

	@Override
	protected Institucion createInstance() {
		Institucion institucion = new Institucion();
		return institucion;
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

	public Institucion getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
