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

import com.bm2i.compra.model.ComprobanteCompra;
import com.bm2i.venta.model.ComprobanteVenta;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:39
 */
@Entity
@TableGenerator(name = "InventarioGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Inventario", initialValue = 1, allocationSize = 1)
public class Inventario {

	private Integer cantidad;

	private BigDecimal costo;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Id
	@GeneratedValue(generator = "InventarioGenerator", strategy = GenerationType.TABLE)
	private Long id;
	/**
	 * compra, venta, devolucion o otra cosa se cree
	 */

	private Long id_evento;

	@OneToOne
	private Articulo articulo;

	@OneToOne
	private ComprobanteCompra compCompra;

	@OneToOne
	private ComprobanteVenta compVenta;

	@OneToOne
	private TipoRegistro tipoRegistro;

	public Inventario() {

	}

	public void finalize() throws Throwable {

	}
}// end Inventario