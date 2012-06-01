package com.bm2i.comun.action;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.model.Impuesto;
import com.bm2i.comun.model.TipoComprobante;

@Name("tipoComprobanteHome")
public class TipoComprobanteHome extends EntityHome<TipoComprobante> {

	// private Impuesto impuesto;

	public void setTipoComprobanteId(Long id) {
		setId(id);
	}

	public Long getTipoComprobanteId() {
		return (Long) getId();
	}

	@Override
	protected TipoComprobante createInstance() {
		TipoComprobante tipoComprobante = new TipoComprobante();
		return tipoComprobante;
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

	public TipoComprobante getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Impuesto> getImpuestos() {
		return getInstance() == null ? null : new ArrayList<Impuesto>(
				getInstance().getImpuestos());
	}

	public void addImpuesto(Impuesto impuesto) {

		this.getInstance().add(impuesto);

	}

	public void removeImpuesto(Impuesto impuesto) {
		this.getInstance().remove(impuesto);
	}

}
