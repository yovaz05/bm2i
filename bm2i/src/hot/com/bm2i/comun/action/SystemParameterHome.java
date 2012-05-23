package com.bm2i.comun.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.model.SystemParameter;

@Name("systemParameterHome")
public class SystemParameterHome extends EntityHome<SystemParameter> {

	public void setSystemParameterNombre(String id) {
		setId(id);
	}

	public String getSystemParameterNombre() {
		return (String) getId();
	}

	@Override
	protected SystemParameter createInstance() {
		SystemParameter systemParameter = new SystemParameter();
		return systemParameter;
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

	public SystemParameter getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
