package com.bm2i.venta.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:39
 */
@Entity
@TableGenerator(name = "RegistroDineroGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "RegistroDinero", initialValue = 1, allocationSize = 1)
public class RegistroDinero {

	@Id
	@GeneratedValue(generator = "RegistroDineroGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private Long cantidad;

	private BigDecimal total;

	@ManyToOne
	@JoinColumn(name = "comprVenta_id")
	private ComprobanteVenta compVenta;

	@ManyToOne
	private CajaPermiso cajaPermiso;

	public RegistroDinero() {

	}

	public void finalize() throws Throwable {

	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public ComprobanteVenta getCompVenta() {
		return compVenta;
	}

	public void setCompVenta(ComprobanteVenta compVenta) {
		this.compVenta = compVenta;
	}

	public CajaPermiso getCajaPermiso() {
		return cajaPermiso;
	}

	public void setCajaPermiso(CajaPermiso cajaPermiso) {
		this.cajaPermiso = cajaPermiso;
	}
}// end RegistroDinero