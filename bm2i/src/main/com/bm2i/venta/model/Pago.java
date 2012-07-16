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
@TableGenerator(name = "PagoGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Pago", initialValue = 1, allocationSize = 1)
public class Pago {

	@Id
	@GeneratedValue(generator = "PagoGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private BigDecimal cambio;

	private BigDecimal efectivo;

	private BigDecimal total;

	@ManyToOne
	@JoinColumn(name = "tipoPago_id")
	private TipoPago tipoPago;

	public Pago() {

	}

	public void finalize() throws Throwable {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCambio() {
		return cambio;
	}

	public void setCambio(BigDecimal cambio) {
		this.cambio = cambio;
	}

	public BigDecimal getEfectivo() {
		return efectivo;
	}

	public void setEfectivo(BigDecimal efectivo) {
		this.efectivo = efectivo;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}
}// end Pago