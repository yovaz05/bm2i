package com.bm2i.comun.action;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.model.Impuesto;
import com.bm2i.comun.model.TipoComprobante;
import com.bm2i.comun.model.TipoComprobateImpuesto;

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

	public List<TipoComprobateImpuesto> getTipoComprobateImpuestos() {
		return getInstance() == null ? null
				: new ArrayList<TipoComprobateImpuesto>(getInstance().getTipoComprobateImpuestos());
	}

	public void addImpuesto(Impuesto imp) {
		TipoComprobateImpuesto tipoComprobanteImpuesto = new TipoComprobateImpuesto();
		tipoComprobanteImpuesto.setImpuesto(imp);
		this.getInstance().add(tipoComprobanteImpuesto);
	}

	public void removeImpuesto(TipoComprobateImpuesto tipoComprobanteImpuesto) {
		this.getInstance().remove(tipoComprobanteImpuesto);
	}

}
