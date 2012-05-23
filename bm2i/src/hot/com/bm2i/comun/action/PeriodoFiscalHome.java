package com.bm2i.comun.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.model.PeriodoFiscal;

@Name("periodoFiscalHome")
public class PeriodoFiscalHome extends EntityHome<PeriodoFiscal> {

	public void setPeriodoFiscalId(Long id) {
		setId(id);
	}

	public Long getPeriodoFiscalId() {
		return (Long) getId();
	}

	@Override
	protected PeriodoFiscal createInstance() {
		PeriodoFiscal periodoFiscal = new PeriodoFiscal();
		return periodoFiscal;
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

	public PeriodoFiscal getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
