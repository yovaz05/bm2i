package com.bm2i.comun.action;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.model.Impuesto;
import com.bm2i.comun.model.TasaImpuesto;

@Name("tasaImpuestoHome")
public class TasaImpuestoHome extends EntityHome<TasaImpuesto> {

	@In(create = true)
	ImpuestoHome impuestoHome;

	public void setTasaImpuestoId(Long id) {
		setId(id);
	}

	public Long getTasaImpuestoId() {
		return (Long) getId();
	}

	@Override
	protected TasaImpuesto createInstance() {
		TasaImpuesto tasaImpuesto = new TasaImpuesto();
		return tasaImpuesto;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Impuesto impuesto = impuestoHome.getDefinedInstance();
		if (impuesto != null) {
			getInstance().setImpuesto(impuesto);
		}
	}

	public boolean isWired() {
		return true;
	}

	public TasaImpuesto getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
