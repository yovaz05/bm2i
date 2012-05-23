package com.bm2i.inventario.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.inventario.model.Linea;

@Name("lineaHome")
public class LineaHome extends EntityHome<Linea> {

	public void setLineaId(Long id) {
		setId(id);
	}

	public Long getLineaId() {
		return (Long) getId();
	}

	@Override
	protected Linea createInstance() {
		Linea linea = new Linea();
		return linea;
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

	public Linea getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
