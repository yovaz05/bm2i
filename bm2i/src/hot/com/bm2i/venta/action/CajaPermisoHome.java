package com.bm2i.venta.action;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.action.PersonaHome;
import com.bm2i.comun.model.Persona;
import com.bm2i.venta.model.Caja;
import com.bm2i.venta.model.CajaPermiso;
import com.bm2i.venta.model.DiaTrabajo;
import com.bm2i.venta.model.RegistroDinero;

@Name("cajaPermisoHome")
public class CajaPermisoHome extends EntityHome<CajaPermiso> {

	@In(create = true)
	CajaHome cajaHome;
	@In(create = true)
	PersonaHome personaHome;
	@In(create = true)
	DiaTrabajoHome diaTrabajoHome;

	public void setCajaPermisoId(Long id) {
		setId(id);
	}

	public Long getCajaPermisoId() {
		return (Long) getId();
	}

	@Override
	protected CajaPermiso createInstance() {
		CajaPermiso cajaPermiso = new CajaPermiso();
		return cajaPermiso;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Caja caja = cajaHome.getDefinedInstance();
		if (caja != null) {
			getInstance().setCaja(caja);
		}
		Persona cajero = personaHome.getDefinedInstance();
		if (cajero != null) {
			getInstance().setCajero(cajero);
		}
		DiaTrabajo diaTrabajo = diaTrabajoHome.getDefinedInstance();
		if (diaTrabajo != null) {
			getInstance().setDiaTrabajo(diaTrabajo);
		}
	}

	public boolean isWired() {
		return true;
	}

	public CajaPermiso getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<RegistroDinero> getRegistros() {
		return getInstance() == null ? null : new ArrayList<RegistroDinero>(
				getInstance().getRegistros());
	}

}
