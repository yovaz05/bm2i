package com.bm2i.venta.action;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.action.PersonaHome;
import com.bm2i.comun.model.Persona;
import com.bm2i.security.action.UserSession;
import com.bm2i.venta.model.CajaPermiso;
import com.bm2i.venta.model.DiaTrabajo;

@Name("diaTrabajoHome")
public class DiaTrabajoHome extends EntityHome<DiaTrabajo> {

	@In
	UserSession userSession;

	@In(create = true)
	PersonaHome personaHome;

	public void setDiaTrabajoId(Long id) {
		setId(id);
	}

	public Long getDiaTrabajoId() {
		return (Long) getId();
	}

	@Override
	protected DiaTrabajo createInstance() {
		DiaTrabajo diaTrabajo = new DiaTrabajo();
		return diaTrabajo;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Persona supervisor = personaHome.getDefinedInstance();
		if (supervisor != null) {
			getInstance().setSupervisor(supervisor);
		}
	}

	public boolean isWired() {
		return true;
	}

	public DiaTrabajo getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<CajaPermiso> getPermisos() {
		return getInstance() == null ? null : new ArrayList<CajaPermiso>(
				getInstance().getPermisos());
	}

	@Override
	public String persist() {
		this.getInstance().setSupervisor(userSession.getPersona());
		return super.persist();
	}

	@Override
	public String update() {
		this.getInstance().setSupervisor(userSession.getPersona());
		return super.update();
	}

}
