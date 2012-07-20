package com.bm2i.venta.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import com.bm2i.comun.model.TipoComprobante;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:38
 */
@Entity
@TableGenerator(name = "ComprobanteVentaGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "ComprobanteVenta", initialValue = 1, allocationSize = 1)
public class ComprobanteVenta {

	@Id
	@GeneratedValue(generator = "ComprobanteVentaGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private Integer numero;

	@Column(length = 25)
	private String guiaRemision;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private BigDecimal descuento;

	private Boolean isAnulado;

	private BigDecimal iva;

	private BigDecimal subTotal;

	private BigDecimal subTotalCero;

	private BigDecimal subTotalIva;

	private BigDecimal valorTotal;

	@Column(length = 15)
	private String hora;

	private Boolean desgloceImpuesto;

	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<ItemComprobanteVenta> items;

	@ManyToOne
	@JoinColumn(name = "pago_id")
	private Pago pago;

	@ManyToOne
	@JoinColumn(name = "tipoComprobante_id")
	private TipoComprobante tipoComprobante;

	@ManyToOne
	private Resident resident;

	public ComprobanteVenta() {
		items = new ArrayList<ItemComprobanteVenta>();
		fecha = new Date();
		hora = new SimpleDateFormat("HH:mm").format(new Date());
		desgloceImpuesto = new Boolean(false);
		//iniciarItemsCompra();
		descuento = new BigDecimal(0);
		iva = new BigDecimal(0);
		subTotal = new BigDecimal(0);
		subTotalCero = new BigDecimal(0);
		subTotalIva = new BigDecimal(0);
		valorTotal = new BigDecimal(0);
	}

	public void iniciarItemsCompra() {
		for (int i = 0; i < 10; i++) {
			ItemComprobanteVenta itemLocal = new ItemComprobanteVenta();
			this.items.add(itemLocal);
		}
	}

	public void finalize() throws Throwable {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getGuiaRemision() {
		return guiaRemision;
	}

	public void setGuiaRemision(String guiaRemision) {
		this.guiaRemision = guiaRemision;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public Boolean getIsAnulado() {
		return isAnulado;
	}

	public void setIsAnulado(Boolean isAnulado) {
		this.isAnulado = isAnulado;
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

	public List<ItemComprobanteVenta> getItems() {
		return items;
	}

	public void setItems(List<ItemComprobanteVenta> items) {
		this.items = items;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public TipoComprobante getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(TipoComprobante tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public void add(ItemComprobanteVenta item) {
		if (!this.items.contains(item)) {
			this.items.add(item);
			item.setVenta(this);
		}
	}

	public void remove(ItemComprobanteVenta item) {
		boolean removed = this.items.remove(item);
		if (removed)
			item.setVenta(null);
	}

	public Boolean getDesgloceImpuesto() {
		return desgloceImpuesto;
	}

	public void setDesgloceImpuesto(Boolean desgloceImpuesto) {
		this.desgloceImpuesto = desgloceImpuesto;
	}
}// end ComprobanteVenta