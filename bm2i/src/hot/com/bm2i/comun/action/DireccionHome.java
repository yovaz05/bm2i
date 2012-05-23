package com.bm2i.comun.action;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.model.Direccion;
import com.bm2i.comun.model.Resident;

@Name("direccionHome")
public class DireccionHome extends EntityHome<Direccion> {

	@In(create = true)
	ResidentHome residentHome;

	public void setDireccionId(Long id) {
		setId(id);
	}

	public Long getDireccionId() {
		return (Long) getId();
	}

	@Override
	protected Direccion createInstance() {
		Direccion direccion = new Direccion();
		return direccion;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Resident resident = residentHome.getDefinedInstance();
		if (resident != null) {
			getInstance().setResident(resident);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Direccion getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
