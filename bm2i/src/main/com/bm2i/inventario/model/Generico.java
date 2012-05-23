package com.bm2i.inventario.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:38
 */
@Entity
@TableGenerator(name = "GenericoGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Generico", initialValue = 1, allocationSize = 1)
public class Generico {

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Id
	@GeneratedValue(generator = "GenericoGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private Boolean isActive;

	@OneToOne
	private Articulo generico;

	public Generico() {

	}

	public void finalize() throws Throwable {

	}
}// end Generico