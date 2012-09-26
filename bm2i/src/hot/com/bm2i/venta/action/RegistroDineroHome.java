package com.bm2i.venta.action;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.venta.model.CajaPermiso;
import com.bm2i.venta.model.ComprobanteVenta;
import com.bm2i.venta.model.RegistroDinero;


@Name("registroDineroHome")
public class RegistroDineroHome extends EntityHome<RegistroDinero> {

	@In(create = true)
	CajaPermisoHome cajaPermisoHome;
	@In(create = true)
	ComprobanteVentaHome comprobanteVentaHome;

	public void setRegistroDineroId(Long id) {
		setId(id);
	}

	public Long getRegistroDineroId() {
		return (Long) getId();
	}

	@Override
	protected RegistroDinero createInstance() {
		RegistroDinero registroDinero = new RegistroDinero();
		return registroDinero;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		CajaPermiso cajaPermiso = cajaPermisoHome.getDefinedInstance();
		if (cajaPermiso != null) {
			getInstance().setCajaPermiso(cajaPermiso);
		}
		ComprobanteVenta compVenta = comprobanteVentaHome.getDefinedInstance();
		if (compVenta != null) {
			getInstance().setCompVenta(compVenta);
		}
	}

	public boolean isWired() {
		return true;
	}

	public RegistroDinero getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
