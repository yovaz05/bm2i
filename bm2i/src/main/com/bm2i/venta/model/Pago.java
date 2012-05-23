package com.bm2i.venta.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:39
 */
@Entity
@TableGenerator(name = "PagoGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Pago", initialValue = 1, allocationSize = 1)
public class Pago {

	private BigDecimal cambio;

	private BigDecimal efectivo;

	@Id
	@GeneratedValue(generator = "PagoGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private BigDecimal total;

	@OneToOne
	private TipoPago tipoPago;

	public Pago() {

	}

	public void finalize() throws Throwable {

	}
}// end Pago