package com.bm2i.comun.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:38
 */
@Entity
@DiscriminatorValue(value = "J")
public class EntidadLegal extends Resident {

	@Column(length = 15)
	private String codigo;

	@Temporal(TemporalType.DATE)
	private Date fechaConstitucion;

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private TipoEntidadLegal tipoEntidadLegal;

	public EntidadLegal() {

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaConstitucion() {
		return fechaConstitucion;
	}

	public void setFechaConstitucion(Date fechaConstitucion) {
		this.fechaConstitucion = fechaConstitucion;
	}

	public TipoEntidadLegal getTipoEntidadLegal() {
		return tipoEntidadLegal;
	}

	public void setTipoEntidadLegal(TipoEntidadLegal tipoEntidadLegal) {
		this.tipoEntidadLegal = tipoEntidadLegal;
	}
}// end EntidadLegal