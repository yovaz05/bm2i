package com.bm2i.venta.action;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.venta.model.Pago;
import com.bm2i.venta.model.TipoPago;

@Name("pagoHome")
public class PagoHome extends EntityHome<Pago> {

	@In(create = true)
	TipoPagoHome tipoPagoHome;

	public void setPagoId(Long id) {
		setId(id);
	}

	public Long getPagoId() {
		return (Long) getId();
	}

	@Override
	protected Pago createInstance() {
		Pago pago = new Pago();
		return pago;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		TipoPago tipoPago = tipoPagoHome.getDefinedInstance();
		if (tipoPago != null) {
			//getInstance().setTipoPago(tipoPago);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Pago getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
