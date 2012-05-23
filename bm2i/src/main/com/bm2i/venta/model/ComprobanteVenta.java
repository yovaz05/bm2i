package com.bm2i.venta.model;

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
import com.bm2i.comun.model.TipoComprobante;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:38
 */
@Entity
@TableGenerator(name = "ComprobanteVentaGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "ComprobanteVenta", initialValue = 1, allocationSize = 1)
public class ComprobanteVenta {

	private BigDecimal descuento;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String guiaRemision;

	@Id
	@GeneratedValue(generator = "ComprobanteVentaGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private Boolean isAnulado;

	private BigDecimal iva;

	private BigDecimal subTotal;

	private BigDecimal subTotalCero;

	private BigDecimal subTotalIva;

	private BigDecimal valorTotal;

	@OneToMany(mappedBy = "", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<ItemComprobanteVenta> items;

	@OneToOne
	private Pago pago;

	@OneToOne
	private TipoComprobante tipoComprobante;

	@OneToOne
	public RegistroDinero m_RegistroDinero;
	
	@ManyToOne
	private Resident resident;

	public ComprobanteVenta() {

	}

	public void finalize() throws Throwable {

	}
}// end ComprobanteVenta