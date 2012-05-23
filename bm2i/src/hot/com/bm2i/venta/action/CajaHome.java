package com.bm2i.venta.action;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.venta.model.Caja;
import com.bm2i.venta.model.CajaPermiso;
import com.bm2i.venta.model.Sucursal;

@Name("cajaHome")
public class CajaHome extends EntityHome<Caja> {

	@In(create = true)
	SucursalHome sucursalHome;

	public void setCajaId(Long id) {
		setId(id);
	}

	public Long getCajaId() {
		return (Long) getId();
	}

	@Override
	protected Caja createInstance() {
		Caja caja = new Caja();
		return caja;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Sucursal sucursal = sucursalHome.getDefinedInstance();
		if (sucursal != null) {
			getInstance().setSucursal(sucursal);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Caja getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<CajaPermiso> getPermisos() {
		return getInstance() == null ? null : new ArrayList<CajaPermiso>(
				getInstance().getPermisos());
	}

}
