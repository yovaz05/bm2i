package com.bm2i.inventario.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.inventario.model.Ganancia;

@Name("gananciaHome")
public class GananciaHome extends EntityHome<Ganancia> {

	public void setGananciaId(Long id) {
		setId(id);
	}

	public Long getGananciaId() {
		return (Long) getId();
	}

	@Override
	protected Ganancia createInstance() {
		Ganancia ganancia = new Ganancia();
		return ganancia;
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

	public Ganancia getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
