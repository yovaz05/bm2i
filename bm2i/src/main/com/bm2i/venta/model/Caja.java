package com.bm2i.venta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:38
 */
@Entity
@TableGenerator(name = "CajaGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Caja", initialValue = 1, allocationSize = 1)
public class Caja {

	@Id
	@GeneratedValue(generator = "CajaGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private String nombre;

	@OneToOne
	private CajaPermiso permisos;

	public Caja() {

	}

	public void finalize() throws Throwable {

	}
}// end Caja