package com.bm2i.venta.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
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

import com.bm2i.inventario.model.Articulo;
import com.bm2i.inventario.model.Precio;
import com.bm2i.security.Usuario;



@Entity
@TableGenerator(name = "RegistroVentaGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "RegistroVenta", initialValue = 1, allocationSize = 1)
@NamedQueries(value = {
		@NamedQuery(name = "RegistroVenta.findByFecha", query = "select rv from RegistroVenta rv where "
				+ "rv.fecha = :fecha " + "order by rv.hora"),
		@NamedQuery(name = "RegistroVenta.addByFecha", query = "select sum(rv.total) from RegistroVenta rv where "
				+ "rv.fecha = :fecha") })
public class RegistroVenta {

	@Id
	@GeneratedValue(generator = "RegistroVentaGenerator", strategy = GenerationType.TABLE)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(length = 10)
	private String hora;

	private Integer cantidad;
	private BigDecimal subTotal;
	private BigDecimal total;

	@ManyToOne
	@JoinColumn(name = "articulo_id")
	Articulo articulo;

	@ManyToOne
	@JoinColumn(name = "precio_id")
	Precio precio;

	@ManyToOne
	@JoinColumn(name = "user_id")
	Usuario user;

	public RegistroVenta() {
		fecha = new Date();
		hora = new SimpleDateFormat("HH:mm").format(new Date());
		cantidad = new Integer(1);
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

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	/*
	 * public BigDecimal getTotal() { return Total; }
	 * 
	 * public void setTotal(BigDecimal total) { Total = total; }
	 */

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Precio getPrecio() {
		return precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
