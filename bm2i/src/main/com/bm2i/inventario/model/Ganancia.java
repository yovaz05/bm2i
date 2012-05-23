package com.bm2i.inventario.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:38
 */
@Entity
@TableGenerator(name = "GananciaGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Ganancia", initialValue = 1, allocationSize = 1)
public class Ganancia {

	@Id
	@GeneratedValue(generator = "GananciaGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private Boolean isActive;

	private BigDecimal porcentaje;

	public Ganancia() {

	}

	public void finalize() throws Throwable {

	}
}// end Ganancia