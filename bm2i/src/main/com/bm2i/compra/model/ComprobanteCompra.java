package com.bm2i.compra.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import com.bm2i.comun.model.Resident;
import com.bm2i.venta.model.TipoPago;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:38
 */
@Entity
@TableGenerator(name = "ComprobanteCompraGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "ComprobanteCompra", initialValue = 1, allocationSize = 1)
public class ComprobanteCompra {

	@Id
	@GeneratedValue(generator = "ComprobanteCompraGenerator", strategy = GenerationType.TABLE)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String guiaRemision;

	private BigDecimal descuento;

	private Integer numero;

	private Boolean isPayed;

	private BigDecimal iva;

	private BigDecimal subTotal;

	private BigDecimal subTotalCero;

	private BigDecimal subTotalIva;

	private BigDecimal valorTotal;

	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<ItemComprobanteCompra> items;

	@ManyToOne
	@JoinColumn(name = "tipoPago_id")
	private TipoPago tipoPago;

	@ManyToOne
	private Resident preveedor;

	public ComprobanteCompra() {

	}

	public void finalize() throws Throwable {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getGuiaRemision() {
		return guiaRemision;
	}

	public void setGuiaRemision(String guiaRemision) {
		this.guiaRemision = guiaRemision;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Boolean getIsPayed() {
		return isPayed;
	}

	public void setIsPayed(Boolean isPayed) {
		this.isPayed = isPayed;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getSubTotalCero() {
		return subTotalCero;
	}

	public void setSubTotalCero(BigDecimal subTotalCero) {
		this.subTotalCero = subTotalCero;
	}

	public BigDecimal getSubTotalIva() {
		return subTotalIva;
	}

	public void setSubTotalIva(BigDecimal subTotalIva) {
		this.subTotalIva = subTotalIva;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ItemComprobanteCompra> getItems() {
		return items;
	}

	public void setItems(List<ItemComprobanteCompra> items) {
		this.items = items;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public Resident getPreveedor() {
		return preveedor;
	}

	public void setPreveedor(Resident preveedor) {
		this.preveedor = preveedor;
	}
}// end ComprobanteCompra