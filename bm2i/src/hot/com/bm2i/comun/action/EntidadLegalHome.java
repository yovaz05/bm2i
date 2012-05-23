package com.bm2i.comun.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.model.EntidadLegal;

@Name("entidadLegalHome")
public class EntidadLegalHome extends EntityHome<EntidadLegal> {

	public void setEntidadLegalId(Long id) {
		setId(id);
	}

	public Long getEntidadLegalId() {
		return (Long) getId();
	}

	@Override
	protected EntidadLegal createInstance() {
		EntidadLegal entidadLegal = new EntidadLegal();
		return entidadLegal;
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

	public EntidadLegal getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
