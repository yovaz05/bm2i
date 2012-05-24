package com.bm2i.inventario.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:38
 */
@Entity
@TableGenerator(name = "GananciaGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Ganancia", initialValue = 1, allocationSize = 1)
@NamedQueries(value = { @NamedQuery(name = "Ganancia.findAll", query = "select g from Ganancia g order by g.nombre") })
public class Ganancia {

	@Id
	@GeneratedValue(generator = "GananciaGenerator", strategy = GenerationType.TABLE)
	private Long id;

	@Column(length = 25)
	private String nombre;

	private Boolean isActive;

	private BigDecimal porcentaje;

	public Ganancia() {

	}

	public void finalize() throws Throwable {

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
		this.nombre = nombre;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public BigDecimal getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}
}// end Ganancia