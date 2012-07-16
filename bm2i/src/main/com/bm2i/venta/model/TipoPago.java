package com.bm2i.venta.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:40
 */
@Entity
@TableGenerator(name = "TipoPagoGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "TipoPago", initialValue = 1, allocationSize = 1)
@NamedQueries(value = { @NamedQuery(name = "TipoPago.findAll", query = "select tp from TipoPago tp ") })
public class TipoPago {

	@Id
	@GeneratedValue(generator = "TipoPagoGenerator", strategy = GenerationType.TABLE)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(length = 30)
	private String nombre;

	public TipoPago() {
		fecha = new Date();
	}

	public void finalize() throws Throwable {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}
}// end TipoPago