package com.bm2i.inventario.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.inventario.model.TipoRegistro;

@Name("tipoRegistroHome")
public class TipoRegistroHome extends EntityHome<TipoRegistro> {

	public void setTipoRegistroId(Long id) {
		setId(id);
	}

	public Long getTipoRegistroId() {
		return (Long) getId();
	}

	@Override
	protected TipoRegistro createInstance() {
		TipoRegistro tipoRegistro = new TipoRegistro();
		return tipoRegistro;
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

	public TipoRegistro getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
