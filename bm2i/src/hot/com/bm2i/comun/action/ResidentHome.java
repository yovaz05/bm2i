package com.bm2i.comun.action;

import java.util.ArrayList;
import java.util.Arrays;
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
		// List<TipoIdentificacion> identificationTypes = new
		// ArrayList<TipoIdentificacion>();
		/*
		 * if (residentType.equalsIgnoreCase("Persona")) {
		 * identificationTypes.add(TipoIdentificacion.CEDULA);
		 * identificationTypes.add(TipoIdentificacion.PASAPORTE); } else {
		 * identificationTypes.add(TipoIdentificacion.RUC); }
		 * getInstance().setTipoIdentificacion(identificationTypes.get(0));
		 */
		// return identificationTypes;
		return Arrays.asList(TipoIdentificacion.values());
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

}
