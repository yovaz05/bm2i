package com.bm2i.venta.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;
import javax.persistence.Query;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.core.Interpolator;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.international.StatusMessage.Severity;

import com.bm2i.comun.action.PersonaHome;
import com.bm2i.comun.model.Persona;
import com.bm2i.security.action.UserSession;
import com.bm2i.venta.model.Caja;
import com.bm2i.venta.model.CajaPermiso;
import com.bm2i.venta.model.DiaTrabajo;
import com.bm2i.venta.model.RegistroDinero;
import com.bm2i.venta.model.Sucursal;

@Name("cajaPermisoHome")
public class CajaPermisoHome extends EntityHome<CajaPermiso> {

	@In
	UserSession userSession;

	@In(create = true)
	CajaHome cajaHome;
	@In(create = true)
	PersonaHome personaHome;
	@In(create = true)
	DiaTrabajoHome diaTrabajoHome;

	private Sucursal sucursal;
	private Caja caja;
	
	@In(create = true)
	private FacesMessages facesMessages;

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
		cargarAperturaCaja();
	}
	
	
	public void wireCierre() {
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
		//cargarAperturaCaja();
		cargarCajaParaCierre();
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

	public void recargarDiaTrabajo() {
		System.out.println("Recargar Dia de Trabajo ");
		Date currentDate = new Date();
		Query query = getEntityManager().createNamedQuery(
				"DiaTrabajo.findCurrent");
		query.setParameter("fActual", currentDate);
		List<DiaTrabajo> list = query.getResultList();
		if (list.size() > 0) {
			DiaTrabajo diaTrabajo = list.get(0);
			this.userSession.setDiaTrabajo(diaTrabajo);
			System.out.println("sssssssssss "+diaTrabajo.getId());
		}
	}

	@Override
	public String persist() {
		if (sucursal != null) {
			if (caja != null) {
				if (userSession.getDiaTrabajo() != null) {
					this.getInstance().setCaja(caja);
					this.getInstance().setHoraOpening(
							new SimpleDateFormat("HH:mm").format(new Date()));
					this.getInstance().setCajero(userSession.getPersona());
					System.out
							.println("disq entra a guardar la apertura de caja");
					return super.persist();
				} else {
					System.out.println("entra a no hay dia de trabajo");
					facesMessages.addFromResourceBundle(Severity.ERROR,
							"#{messages['diaTrabajo.noOpen']}");		
					return null;
				}
			} else {
				facesMessages.addFromResourceBundle(Severity.ERROR,
				"#{messages['caja.seleccionaunacaja']}");
				/*String message = Interpolator.instance().interpolate(
						"", new Object[0]);
				throw new ValidatorException(new FacesMessage(message));*/
				return null;
			}
		} else {
			// return null;
			/*String message = Interpolator.instance().interpolate(
					"#{messages['caja.seleccionaunacaja']}", new Object[0]);
			throw new ValidatorException(new FacesMessage(message));*/
			facesMessages.addFromResourceBundle(Severity.ERROR,
			"#{messages['caja.seleccionaunacaja']}");
			return null;
		}
	}

	@Override
	public String update() {
		if (sucursal != null) {
			if (caja != null) {
				this.getInstance().setCaja(caja);

				this.getInstance().setCajero(userSession.getPersona());
				return super.persist();
			} else {
				String message = Interpolator.instance().interpolate(
						"#{messages['caja.seleccionaunacaja']}", new Object[0]);
				throw new ValidatorException(new FacesMessage(message));
				// return null;
			}
		} else {
			// return null;
			String message = Interpolator.instance().interpolate(
					"#{messages['caja.seleccionaunacaja']}", new Object[0]);
			throw new ValidatorException(new FacesMessage(message));
		}
	}

	public void cargarAperturaCaja() {
		Query q = this.getEntityManager().createNamedQuery(
				"CajaPermiso.findCurrent");
		q.setParameter("fechaApertura", new Date());
		q.setParameter("cajero", userSession.getPersona());
		if (q.getResultList().size() > 0) {
			this.setInstance((CajaPermiso) q.getSingleResult());
			System.out
					.println("=======>>>> entra a cargar la paertura de caja");
		}
	}
	
	public void cargarCajaParaCierre() {
		Query q = this.getEntityManager().createNamedQuery(
				"CajaPermiso.findCurrent");
		q.setParameter("fechaApertura", new Date());
		q.setParameter("cajero", userSession.getPersona());
		if (q.getResultList().size() > 0) {
			this.setInstance((CajaPermiso) q.getSingleResult());
			this.sucursal=this.getInstance().getCaja().getSucursal();
			System.out
					.println("=======>>>> entra a cargar la paertura de caja");
		}
	}

	public List<Sucursal> getSucursales() {
		Query q = this.getEntityManager().createNamedQuery("Sucursal.findAll");
		if (q.getResultList().size() > 0) {
			this.sucursal = (Sucursal) q.getResultList().get(0);
		}
		return q.getResultList();
	}

	public void evtCargarCajas() {
		System.out.println("=======>>>> entra a cargar cajas");
		getCajas();
	}

	public List<Caja> getCajas() {
		if (sucursal != null) {
			Query q = this.getEntityManager().createNamedQuery(
					"Caja.findBySucursal");
			q.setParameter("sucursal", this.sucursal);
			if (q.getResultList().size() > 0) {
				this.caja = (Caja) q.getResultList().get(0);
			}
			return q.getResultList();
		} else {
			System.out.println("=======>>>> es nulo cargar cajas");
		}
		return null;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

}
