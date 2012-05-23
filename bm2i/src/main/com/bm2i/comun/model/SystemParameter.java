package com.bm2i.comun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:39
 */
@Entity
@TableGenerator(name = "SystemParameterGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "SystemParameter", initialValue = 1, allocationSize = 1)
public class SystemParameter {

	@Id
	@Column(length = 50)
	private String nombre;

	@Column(length = 50, nullable = false)
	private String className;

	@Column(length = 50, nullable = false)
	private String valor;

	@Column(length = 100)
	private String descripcion;

	public SystemParameter() {

	}

	public void finalize() throws Throwable {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}// end SystemParameter