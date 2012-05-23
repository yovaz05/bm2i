package com.bm2i.inventario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Linea {

	private String codigo;

	private String detalle;

	@Id
	@GeneratedValue(generator = "LineaGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private String nombre;

	public Linea() {

	}

	public void finalize() throws Throwable {

	}
}// end Linea