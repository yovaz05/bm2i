package com.bm2i.comun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:38
 */
@Entity
@TableGenerator(name = "DireccionGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Direccion", initialValue = 1, allocationSize = 1)
public class Direccion {

	@Id
	@GeneratedValue(generator = "DireccionGenerator", strategy = GenerationType.TABLE)
	private Long id;

	@Column(length = 30)
	private String calle;

	@Column(length = 30)
	private String cuidad;

	@Column(length = 10)
	private String numero;

	@Column(length = 25)
	private String pais;

	@Column(length = 15)
	private String telefonoCedular;

	@Column(length = 15)
	private String telefonoFijo;
	
	@ManyToOne
	private Resident resident;

	public Direccion() {

	}

	public void finalize() throws Throwable {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCuidad() {
		return cuidad;
	}

	public void setCuidad(String cuidad) {
		this.cuidad = cuidad;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefonoCedular() {
		return telefonoCedular;
	}

	public void setTelefonoCedular(String telefonoCedular) {
		this.telefonoCedular = telefonoCedular;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}
}// end Direccion