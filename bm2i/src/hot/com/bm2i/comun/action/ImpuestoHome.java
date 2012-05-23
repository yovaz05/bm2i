package com.bm2i.comun.action;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.model.Impuesto;
import com.bm2i.comun.model.TasaImpuesto;
import com.bm2i.comun.model.TipoComprobante;

@Name("impuestoHome")
public class ImpuestoHome extends EntityHome<Impuesto> {

	@In(create = true)
	TipoComprobanteHome tipoComprobanteHome;

	public void setImpuestoId(Long id) {
		setId(id);
	}

	public Long getImpuestoId() {
		return (Long) getId();
	}

	@Override
	protected Impuesto createInstance() {
		Impuesto impuesto = new Impuesto();
		return impuesto;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		TipoComprobante tipoComprobante = tipoComprobanteHome
				.getDefinedInstance();
		if (tipoComprobante != null) {
			getInstance().setTipoComprobante(tipoComprobante);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Impuesto getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<TasaImpuesto> getTasas() {
		return getInstance() == null ? null : new ArrayList<TasaImpuesto>(
				getInstance().getTasas());
	}

}
