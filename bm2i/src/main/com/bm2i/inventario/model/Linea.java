package com.bm2i.inventario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;

/**
 * lapices cuadernos libros cosas asi
 * 
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:39
 */
@Entity
@TableGenerator(name = "LineaGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Linea", initialValue = 1, allocationSize = 1)
@NamedQueries(value = { @NamedQuery(name = "Linea.findAll", query = "select l from Linea l order by l.nombre") })
public class Linea {

	@Id
	@GeneratedValue(generator = "LineaGenerator", strategy = GenerationType.TABLE)
	private Long id;

	@Column(length = 30)
	private String nombre;

	@Column(length = 30)
	private String codigo;

	@Column(length = 100)
	private String detalle;

	public Linea() {

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
		this.nombre = nombre.toUpperCase();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo.toUpperCase();
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
}// end Linea