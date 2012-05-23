package com.bm2i.comun.action;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.compra.model.ComprobanteCompra;
import com.bm2i.comun.model.Direccion;
import com.bm2i.comun.model.Persona;
import com.bm2i.comun.model.Resident;
import com.bm2i.venta.model.ComprobanteVenta;

@Name("residentHome")
public class ResidentHome extends EntityHome<Resident> {

	public void setResidentId(Long id) {
		setId(id);
	}

	public Long getResidentId() {
		return (Long) getId();
	}

	@Override
	protected Resident createInstance() {
		Resident resident = new Persona();
		return resident;
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

	public Resident getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ComprobanteCompra> getComprobantesCompra() {
		return getInstance() == null ? null : new ArrayList<ComprobanteCompra>(
				getInstance().getComprobantesCompra());
	}
	public List<ComprobanteVenta> getComprobantesVenta() {
		return getInstance() == null ? null : new ArrayList<ComprobanteVenta>(
				getInstance().getComprobantesVenta());
	}
	public List<Direccion> getDirecciones() {
		return getInstance() == null ? null : new ArrayList<Direccion>(
				getInstance().getDirecciones());
	}

}
