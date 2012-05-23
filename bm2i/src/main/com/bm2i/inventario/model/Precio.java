package com.bm2i.inventario.model;

import java.math.BigDecimal;
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
 * @created 23-May-2012 10:53:39
 */
@Entity
@TableGenerator(name = "PrecioGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Precio", initialValue = 1, allocationSize = 1)
public class Precio {

	private BigDecimal costo;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Id
	@GeneratedValue(generator = "PrecioGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private Boolean isActive;

	private BigDecimal pvp;

	private BigDecimal utilidad;

	@OneToOne
	private Ganancia ganancia;

	public Precio() {

	}

	public void finalize() throws Throwable {

	}
}// end Precio