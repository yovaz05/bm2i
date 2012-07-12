package com.bm2i.venta.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
	@JoinColumn(name = "articulo_id")
	private Articulo articulo;

	@ManyToOne
	private ComprobanteVenta venta;

	private Boolean conPerdida;

	@Transient
	private Boolean isValid;
	@Transient
	private String codigoBarra;

	public ItemComprobanteVenta() {
		fecha = new Date();
		isValid = new Boolean(true);
		conPerdida = new Boolean(false);
	}

	public void finalize() throws Throwable {

	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getvTotal() {
		return vTotal;
	}

	public void setvTotal(BigDecimal vTotal) {
		this.vTotal = vTotal;
	}

	public BigDecimal getvUnitario() {
		return vUnitario;
	}

	public void setvUnitario(BigDecimal vUnitario) {
		this.vUnitario = vUnitario;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public ComprobanteVenta getVenta() {
		return venta;
	}

	public void setVenta(ComprobanteVenta venta) {
		this.venta = venta;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public Boolean getConPerdida() {
		return conPerdida;
	}

	public void setConPerdida(Boolean conPerdida) {
		this.conPerdida = conPerdida;
	}
}// end ItemComprobanteVenta