package com.bm2i.venta.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.venta.model.TipoPago;

@Name("tipoPagoHome")
public class TipoPagoHome extends EntityHome<TipoPago> {

	public void setTipoPagoId(Long id) {
		setId(id);
	}

	public Long getTipoPagoId() {
		return (Long) getId();
	}

	@Override
	protected TipoPago createInstance() {
		TipoPago tipoPago = new TipoPago();
		return tipoPago;
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

	public TipoPago getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
