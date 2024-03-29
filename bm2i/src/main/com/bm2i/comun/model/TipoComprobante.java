package com.bm2i.comun.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cascade;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:39
 */
@Entity
@TableGenerator(name = "TipoComprobanteGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "TipoComprobante", initialValue = 1, allocationSize = 1)
@NamedQueries(value = {
		@NamedQuery(name = "TipoComprobante.findAll", query = "select o from TipoComprobante o order by o.nombre"),
		@NamedQuery(name = "TipoComprobante.findById", query = "select o from TipoComprobante o where o.id = :id") })
public class TipoComprobante {

	@Id
	@GeneratedValue(generator = "TipoComprobanteGenerator", strategy = GenerationType.TABLE)
	private Long id;

	@Column(length = 50)
	private String nombre;

	@Column(length = 50)
	private String descripcion;

	private Boolean isActive;

	@OneToMany(mappedBy = "tipoComprobante", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<TipoComprobateImpuesto> tipoComprobateImpuestos;

	public TipoComprobante() {
		tipoComprobateImpuestos = new ArrayList<TipoComprobateImpuesto>();
	}

	public void finalize() throws Throwable {

	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void add(TipoComprobateImpuesto tipoComprobateImpuesto) {

		if (!this.tipoComprobateImpuestos.contains(tipoComprobateImpuesto)) {
			this.tipoComprobateImpuestos.add(tipoComprobateImpuesto);
			tipoComprobateImpuesto.setTipoComprobante(this);
		}
	}

	public void remove(TipoComprobateImpuesto tipoComprobateImpuesto) {
		boolean removed = this.tipoComprobateImpuestos
				.remove(tipoComprobateImpuesto);
		if (removed) {
			tipoComprobateImpuesto.setTipoComprobante(null);
		}

	}

	public List<TipoComprobateImpuesto> getTipoComprobateImpuestos() {
		return tipoComprobateImpuestos;
	}

	public void setTipoComprobateImpuestos(
			List<TipoComprobateImpuesto> tipoComprobateImpuestos) {
		this.tipoComprobateImpuestos = tipoComprobateImpuestos;
	}

}// end TipoComprobante