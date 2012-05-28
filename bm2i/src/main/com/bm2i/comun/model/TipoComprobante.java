package com.bm2i.comun.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cascade;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:39
 */
@Entity
@TableGenerator(name = "TipoComprobanteGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "TipoComprobante", initialValue = 1, allocationSize = 1)
public class TipoComprobante {

	@Id
	@GeneratedValue(generator = "TipoComprobanteGenerator", strategy = GenerationType.TABLE)
	private Long id;

	@Column(length = 50)
	private String nombre;

	@Column(length = 50)
	private String descripcion;

	private Boolean isActive;

	/*
	 * @OneToMany(mappedBy = "tipoComprobante", cascade = CascadeType.ALL)
	 * 
	 * @Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	 */

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "impuesto_id")
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@OrderBy("nombre")
	private List<Impuesto> impuestos;

	public TipoComprobante() {
		impuestos = new ArrayList<Impuesto>();
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

	public List<Impuesto> getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(List<Impuesto> impuestos) {
		this.impuestos = impuestos;
	}

	public void add(Impuesto impuesto) {
		if (!this.impuestos.contains(impuesto)) {
			this.impuestos.add(impuesto);
		}
	}

	public void remove(Impuesto impuesto) {
		this.impuestos.remove(impuesto);
	}

}// end TipoComprobante