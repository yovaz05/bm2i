package com.bm2i.venta.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class TipoPago {

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Id
	@GeneratedValue(generator = "TipoPagoGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private String nombre;

	public TipoPago() {

	}

	public void finalize() throws Throwable {

	}
}// end TipoPago