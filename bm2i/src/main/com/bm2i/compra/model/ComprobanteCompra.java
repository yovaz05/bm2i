package com.bm2i.compra.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import com.bm2i.comun.model.Resident;
import com.bm2i.inventario.model.Inventario;
import com.bm2i.venta.model.TipoPago;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:38
 */
@Entity
@TableGenerator(name = "ComprobanteCompraGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "ComprobanteCompra", initialValue = 1, allocationSize = 1)
public class ComprobanteCompra {

	private BigDecimal descuento;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String guiaRemision;

	@Id
	@GeneratedValue(generator = "ComprobanteCompraGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private Boolean isPayed;

	private BigDecimal iva;

	private BigDecimal subTotal;

	private BigDecimal subTotalCero;

	private BigDecimal subTotalIva;

	private BigDecimal valorTotal;

	@OneToMany(mappedBy = "", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<ItemComprobanteCompra> items;

	@OneToMany(mappedBy = "", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<Inventario> kardexs;

	@OneToOne
	private TipoPago tipoPago;
	
	@ManyToOne
	private Resident preveedor;

	public ComprobanteCompra() {

	}

	public void finalize() throws Throwable {

	}
}// end ComprobanteCompra