package com.bm2i.inventario.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:39
 */
@Entity
@TableGenerator(name = "PrecioGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Precio", initialValue = 1, allocationSize = 1)
@NamedQueries(value = { @NamedQuery(name = "Precio.findByTipoPrecio", query = "select p from Precio p where "
		+ "p.isActive = :isActive and " + "p.tipoPrecio = :tipoPrecio and p.articulo = :articulo") })
public class Precio {

	@Id
	@GeneratedValue(generator = "PrecioGenerator", strategy = GenerationType.TABLE)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private BigDecimal costo;

	private Boolean isActive;

	private BigDecimal pvp;

	private BigDecimal utilidad;

	@ManyToOne
	private Inventario inventario;

	@ManyToOne
	private Articulo articulo;

	@ManyToOne
	@JoinColumn(name = "ganancia_id")
	private Ganancia ganancia;

	@ManyToOne
	@JoinColumn(name = "tipoPrecio_id")
	private TipoPrecio tipoPrecio;

	public Precio() {
		costo = new BigDecimal(0);
		pvp = new BigDecimal(0);
		utilidad = new BigDecimal(0);
		fecha = new Date();
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

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public BigDecimal getPvp() {
		return pvp;
	}

	public void setPvp(BigDecimal pvp) {
		this.pvp = pvp;
	}

	public BigDecimal getUtilidad() {
		return utilidad;
	}

	public void setUtilidad(BigDecimal utilidad) {
		this.utilidad = utilidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Ganancia getGanancia() {
		return ganancia;
	}

	public void setGanancia(Ganancia ganancia) {
		this.ganancia = ganancia;
	}

	public void realizarCalculo() {
		if (ganancia != null) {
			double costo = this.costo.doubleValue();
			double utilidad = ganancia.getPorcentaje().doubleValue();
			double total = costo + (costo * utilidad / 100);
			BigDecimal pvp = new BigDecimal(total);
			pvp = pvp.setScale(2, RoundingMode.HALF_UP);
			this.setPvp(pvp);
		}
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public TipoPrecio getTipoPrecio() {
		return tipoPrecio;
	}

	public void setTipoPrecio(TipoPrecio tipoPrecio) {
		this.tipoPrecio = tipoPrecio;
	}

}// end Precio