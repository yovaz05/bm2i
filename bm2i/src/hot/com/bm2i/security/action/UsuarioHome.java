package com.bm2i.security.action;

import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.model.Persona;
import com.bm2i.security.Usuario;

@Name("usuarioHome")
public class UsuarioHome extends EntityHome<Usuario> {

	Persona persona = new Persona();

	public void setUsuarioId(Long id) {
		setId(id);
	}

	public Long getUsuarioId() {
		return (Long) getId();
	}

	@Override
	protected Usuario createInstance() {
		Usuario usuario = new Usuario();
		return usuario;
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

	public Usuario getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	/*
	 * public List<PagoCompra> getPagosCompra() { return getInstance() == null ?
	 * null : new ArrayList<PagoCompra>( getInstance().getPagosCompra()); }
	 * 
	 * public List<PagoVenta> getPagosVenta() { return getInstance() == null ?
	 * null : new ArrayList<PagoVenta>( getInstance().getPagosVenta()); }
	 */

	/*
	 * public List<PerfilUsuario> getPerfiles() { return getInstance() == null ?
	 * null : new ArrayList<PerfilUsuario>( getInstance().getPerfiles()); }
	 */

	/*@Factory("maritalStatuses")
	public List<TipoEstadoCivil> loadMaritalStatuses() {
		return Arrays.asList(TipoEstadoCivil.values());
	}

	@Factory("tipoTarjetID")
	public List<TipoTarjetaId> loadtipoTarjetID() {
		return Arrays.asList(TipoTarjetaId.values());
	}

	@Factory("genders")
	public List<TipoGenero> loadGenders() {
		return Arrays.asList(TipoGenero.values());
	}*/

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@SuppressWarnings("unchecked")
	public List<Persona> findPersona(Object suggest) {
		String pref = (String) suggest;
		Query query = this.getEntityManager().createNamedQuery(
				"Persona.findByCriteria");
		query.setParameter("criteria", pref);
		return query.getResultList();
	}

	public void cargarPersona(Persona persona) {
		if (persona != null) {
			this.persona = persona;
			this.getInstance().setPersona(persona);
		}
	}

}
