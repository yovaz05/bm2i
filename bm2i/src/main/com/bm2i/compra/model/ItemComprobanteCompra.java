package com.bm2i.compra.model;

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
@TableGenerator(name = "ItemComprobanteCompraGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "ItemComprobanteCompra", initialValue = 1, allocationSize = 1)
public class ItemComprobanteCompra {

	@Id
	@GeneratedValue(generator = "ItemComprobanteCompraGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private Integer cantidad;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private BigDecimal vUnitario;

	private BigDecimal vTotal;

	@ManyToOne
	@JoinColumn(name = "articulo_id")
	private Articulo articulo;

	@ManyToOne
	ComprobanteCompra compra;

	@Transient
	private Boolean isValid;
	@Transient
	private Boolean isCodigoBarraEnabled;
	@Transient
	private String codigoBarra;

	public ItemComprobanteCompra() {
		fecha = new Date();
		isValid = new Boolean(true);
		isCodigoBarraEnabled = new Boolean(true);
	}

	public void finalize() throws Throwable {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getvUnitario() {
		return vUnitario;
	}

	public void setvUnitario(BigDecimal vUnitario) {
		this.vUnitario = vUnitario;
	}

	public BigDecimal getvTotal() {
		return vTotal;
	}

	public void setvTotal(BigDecimal vTotal) {
		this.vTotal = vTotal;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public ComprobanteCompra getCompra() {
		return compra;
	}

	public void setCompra(ComprobanteCompra compra) {
		this.compra = compra;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public Boolean getIsCodigoBarraEnabled() {
		return isCodigoBarraEnabled;
	}

	public void setIsCodigoBarraEnabled(Boolean isCodigoBarraEnabled) {
		this.isCodigoBarraEnabled = isCodigoBarraEnabled;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
}// end ItemComprobanteCompra