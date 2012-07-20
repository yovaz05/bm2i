package com.bm2i.comun.action;

import java.util.ArrayList;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.compra.model.ComprobanteCompra;
import com.bm2i.comun.model.Direccion;
import com.bm2i.comun.model.EntidadLegal;
import com.bm2i.comun.model.EstadoCivil;
import com.bm2i.comun.model.Genero;
import com.bm2i.comun.model.Persona;
import com.bm2i.comun.model.Resident;
import com.bm2i.comun.model.TipoEntidadLegal;
import com.bm2i.comun.model.TipoIdentificacion;
import com.bm2i.venta.model.ComprobanteVenta;

@Name("residentHome")
public class ResidentHome extends EntityHome<Resident> {

	@In(create = true)
	DireccionHome direccionHome;
	private String residentType = "Persona";
	private Boolean panelNatural = new Boolean(true);

	public void setResidentId(Long id) {
		setId(id);
	}

	public Long getResidentId() {
		return (Long) getId();
	}

	@Override
	protected Resident createInstance() {
		Resident resident;
		if (residentType.equalsIgnoreCase("Persona")) {
			resident = new Persona();
		} else {
			resident = new EntidadLegal();
		}
		return resident;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}

	}

	public void wire() {
		getInstance();
		Direccion direccion = direccionHome.getDefinedInstance();
		if (direccion != null) {
			getInstance().setCurrentDireccion(direccion);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Resident getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ComprobanteCompra> getComprobantesCompra() {
		return getInstance() == null ? null : new ArrayList<ComprobanteCompra>(
				getInstance().getComprobantesCompra());
	}

	public List<ComprobanteVenta> getComprobantesVenta() {
		return getInstance() == null ? null : new ArrayList<ComprobanteVenta>(
				getInstance().getComprobantesVenta());
	}

	public List<Direccion> getDirecciones() {
		return getInstance() == null ? null : new ArrayList<Direccion>(
				getInstance().getDirecciones());
	}

	@Override
	public String persist() {
		if (residentType.equalsIgnoreCase("Persona")) {
			getInstance().setNombre(getInstance().toString());
		}
		return super.persist();
	}

	@Override
	public String update() {
		if (residentType.equalsIgnoreCase("Persona")) {
			getInstance().setNombre(getInstance().toString());
		}
		return super.update();
	}

	@Factory("genders")
	public List<Genero> loadGenders() {
		return Arrays.asList(Genero.values());
	}

	@Factory("maritalStatuses")
	public List<EstadoCivil> loadMaritalStatuses() {
		return Arrays.asList(EstadoCivil.values());

	}

	@Factory("legalEntityTypes")
	public List<TipoEntidadLegal> loadLegalEntityTypes() {
		return Arrays.asList(TipoEntidadLegal.values());
	}

	public List<TipoIdentificacion> getIdentificationTypes() {

		List<TipoIdentificacion> identificationTypes = new ArrayList<TipoIdentificacion>();
		identificationTypes = Arrays.asList(TipoIdentificacion.values());
		/*
		 * if (residentType.equalsIgnoreCase("Persona")) {
		 * identificationTypes.add(TipoIdentificacion.CEDULA);
		 * identificationTypes.add(TipoIdentificacion.PASAPORTE); } else {
		 * identificationTypes.add(TipoIdentificacion.RUC); }
		 * getInstance().setTipoIdentificacion(identificationTypes.get(0));
		 */
		// return identificationTypes;
		
		// getInstance().setTipoIdentificacion(identificationTypes.get(0));
		return identificationTypes;
	}

	public String getResidentType() {
		return residentType;
	}

	public void setResidentType(String residentType) {
		this.residentType = residentType;
	}

	public void addAddress() {
		Direccion address = new Direccion();
		this.getInstance().add(address);
		this.getInstance().setCurrentDireccion(address);
		// disableAddressControls = false;
	}

	public void crearReisdent() {
		if (this.getInstance().getTipoIdentificacion()
				.equals(TipoIdentificacion.CEDULA)) {
			this.setInstance(new Persona());
			this.getInstance().setTipoIdentificacion(TipoIdentificacion.CEDULA);
			panelNatural = new Boolean(true);
		}
		if (this.getInstance().getTipoIdentificacion()
				.equals(TipoIdentificacion.PASAPORTE)) {
			this.setInstance(new Persona());
			this.getInstance().setTipoIdentificacion(
					TipoIdentificacion.PASAPORTE);
			panelNatural = new Boolean(true);
		}
		if (this.getInstance().getTipoIdentificacion()
				.equals(TipoIdentificacion.RUC)) {
			this.setInstance(new EntidadLegal());
			this.getInstance().setTipoIdentificacion(TipoIdentificacion.RUC);
			panelNatural = new Boolean(false);
		}

		/*
		 * if (this.getInstance().getTipoIdentificacion()
		 * .equals(TipoIdentificacion.CEDULA) ||
		 * this.getInstance().getTipoIdentificacion()
		 * .equals(TipoIdentificacion.PASAPORTE)) { this.setInstance(new
		 * Persona()); if (this.getInstance().getTipoIdentificacion()
		 * .equals(TipoIdentificacion.CEDULA)) {
		 * this.getInstance().setTipoIdentificacion( TipoIdentificacion.CEDULA);
		 * } if (this.getInstance().getTipoIdentificacion()
		 * .equals(TipoIdentificacion.PASAPORTE)) {
		 * this.getInstance().setTipoIdentificacion(
		 * TipoIdentificacion.PASAPORTE); }
		 * System.out.println("========= crea persona"); panelNatural = new
		 * Boolean(true); } else {
		 * 
		 * }
		 */
	}

	public Boolean getPanelNatural() {
		return panelNatural;
	}

	public void setPanelNatural(Boolean panelNatural) {
		this.panelNatural = panelNatural;
	}

	public void buscarCliente() {
		String nid = this.getInstance().getNumeroIdentificacion();
		if (nid != null) {
			Query q = this.getEntityManager().createNamedQuery(
					"Resident.findByIdentificationNumber");
			q.setParameter("identificationNumber", nid);
			if (q.getResultList().size() > 0) {
				this.setInstance((Resident) q.getSingleResult());
			}
		}
	}

	public boolean savaOrUpdate() {
		if (this.getInstance().getNumeroIdentificacion() != null) {
			if (this.getInstance().getId() != null) {
				this.update();
				return true;
			} else {
				this.getInstance().setFechaRegistro(new Date());
				this.getInstance().getCurrentDireccion().setPais("ECUADOR");
				this.persist();
				return true;
			}
		} else {
			return false;
		}
	}
}
