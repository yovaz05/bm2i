package com.bm2i.inventario.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bm2i.compra.model.ComprobanteCompra;

@Entity
@TableGenerator(name = "LoteGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Lote", initialValue = 1, allocationSize = 1)
public class Lote {

	@Id
	@GeneratedValue(generator = "LoteGenerator", strategy = GenerationType.TABLE)
	private Long id;
	
	@Column(length = 30)
	private String numero;
	
	@Temporal(TemporalType.DATE)
	private Date fechaCaducidad;

	@ManyToOne
	@JoinColumn(name = "compra_id")
	private ComprobanteCompra compra;
	
	@ManyToOne
	private Articulo articulo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public ComprobanteCompra getCompra() {
		return compra;
	}

	public void setCompra(ComprobanteCompra compra) {
		this.compra = compra;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

}
