package com.bm2i.venta.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bm2i.inventario.model.Articulo;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:39
 */
@Entity
@TableGenerator(name = "ItemComprobanteVentaGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "ItemComprobanteVenta", initialValue = 1, allocationSize = 1)
public class ItemComprobanteVenta {

	private int cantidad;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Id
	@GeneratedValue(generator = "ItemComprobanteVentaGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private BigDecimal vTotal;

	private BigDecimal vUnitario;

	@ManyToOne
	@JoinColumn
	private Articulo articulo;

	public ItemComprobanteVenta() {

	}

	public void finalize() throws Throwable {

	}
}// end ItemComprobanteVenta