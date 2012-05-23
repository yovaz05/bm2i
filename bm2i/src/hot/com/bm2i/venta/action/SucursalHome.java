package com.bm2i.venta.action;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.venta.model.Caja;
import com.bm2i.venta.model.Sucursal;

@Name("sucursalHome")
public class SucursalHome extends EntityHome<Sucursal> {

	public void setSucursalId(Long id) {
		setId(id);
	}

	public Long getSucursalId() {
		return (Long) getId();
	}

	@Override
	protected Sucursal createInstance() {
		Sucursal sucursal = new Sucursal();
		return sucursal;
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

	public Sucursal getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Caja> getCajas() {
		return getInstance() == null ? null : new ArrayList<Caja>(getInstance()
				.getCajas());
	}

}
