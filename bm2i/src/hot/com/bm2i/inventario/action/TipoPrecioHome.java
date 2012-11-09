package com.bm2i.inventario.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.inventario.model.TipoPrecio;

@Name("tipoPrecioHome")
public class TipoPrecioHome extends EntityHome<TipoPrecio> {

	public void setTipoPrecioId(Long id) {
		setId(id);
	}

	public Long getTipoPrecioId() {
		return (Long) getId();
	}

	@Override
	protected TipoPrecio createInstance() {
		TipoPrecio tipoPrecio = new TipoPrecio();
		return tipoPrecio;
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

	public TipoPrecio getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
