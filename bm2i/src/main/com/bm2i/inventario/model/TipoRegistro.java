package com.bm2i.inventario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:40
 */
@Entity
@TableGenerator(name = "TipoRegistroGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "TipoRegistro", initialValue = 1, allocationSize = 1)
public class TipoRegistro {

	@Id
	@GeneratedValue(generator = "TipoRegistroGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private Boolean isActive;

	private String nombre;

	public TipoRegistro() {

	}

	public void finalize() throws Throwable {

	}
}// end TipoRegistro