package com.bm2i.security.action;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityController;
import org.jboss.seam.log.Log;

import com.bm2i.comun.model.PeriodoFiscal;
import com.bm2i.comun.model.Persona;
import com.bm2i.security.Usuario;
import com.bm2i.venta.model.DiaTrabajo;

@Name("userSession")
@Scope(ScopeType.SESSION)
public class UserSession extends EntityController {

	private static final long serialVersionUID = 1L;

	@Logger
	Log logger;

	private PeriodoFiscal periodoFiscal;

	private Usuario usuario;
	private Persona persona;
	private DiaTrabajo diaTrabajo;

	public void setperiodoFiscal(PeriodoFiscal periodoFiscal) {
		this.periodoFiscal = periodoFiscal;
	}

	public PeriodoFiscal getperiodoFiscal() {
		return periodoFiscal;
	}

	@Observer(value = "org.jboss.seam.postCreate.userSession")
	public void initializeCurrentperiodoFiscal() {
		Date currentDate = new Date();
		Query query = getEntityManager().createNamedQuery(
				"PeriodoFiscal.findCurrent");
		query.setParameter("fActual", currentDate);
		List<PeriodoFiscal> list = query.getResultList();
		if (list.size() > 0) {
			periodoFiscal = list.get(0);
		}
	}

	@Observer(value = "org.jboss.seam.postCreate.userSession")
	public void initializeCurrentDiaTrabajo() {
		logger.info("Inicia el dia de trabajo");
		Date currentDate = new Date();
		Query query = getEntityManager().createNamedQuery(
				"DiaTrabajo.findCurrent");
		query.setParameter("fActual", currentDate);
		List<DiaTrabajo> list = query.getResultList();
		if (list.size() > 0) {
			diaTrabajo = list.get(0);
		} else {
			logger.fatal("=====>>>>> no existe dia de trabajo");
		}
	}

	@SuppressWarnings("unchecked")
	@Factory(value = "periodosFiscales")
	public List<PeriodoFiscal> findperiodoFiscals() {
		Query query = getEntityManager().createNamedQuery(
				"PeriodoFiscal.findAll");
		List<PeriodoFiscal> periodoFiscals = query.getResultList();
		return periodoFiscals;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public DiaTrabajo getDiaTrabajo() {
		return diaTrabajo;
	}

	public void setDiaTrabajo(DiaTrabajo diaTrabajo) {
		this.diaTrabajo = diaTrabajo;
	}

}
