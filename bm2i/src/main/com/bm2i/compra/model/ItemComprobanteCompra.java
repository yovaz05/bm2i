package com.bm2i.compra.model;

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

import com.bm2i.inventario.model.Articulo;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:39
 */
@Entity
@TableGenerator(name = "ItemComprobanteCompraGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "ItemComprobanteCompra", initialValue = 1, allocationSize = 1)
public class ItemComprobanteCompra {

	private Integer cantidad;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Id
	@GeneratedValue(generator = "ItemComprobanteCompraGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private BigDecimal vTotal;

	private BigDecimal vUnitario;

	@OneToOne
	private Articulo articulo;

	public ItemComprobanteCompra() {

	}

	public void finalize() throws Throwable {

	}
}// end ItemComprobanteCompra