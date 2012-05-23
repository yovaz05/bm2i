package com.bm2i.inventario.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cascade;

/**
 * aumentar el current precio
 * 
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:38
 */
@Entity
@TableGenerator(name = "ArticuloGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Articulo", initialValue = 1, allocationSize = 1)
public class Articulo {

	@Id
	@GeneratedValue(generator = "ArticuloGenerator", strategy = GenerationType.TABLE)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private TipoArticulo tipoArticulo;

	@ManyToOne
	@JoinColumn(name = "linea_id")
	private Linea linea;

	@Column(length = 30)
	private String codigoBarra;

	@Column(length = 60)
	private String nombre;

	private Integer cantidad;

	private BigDecimal currentCosto;

	@Column(length = 100)
	private String descripcion;

	private Integer existenciaMax;

	private Integer existenciaMin;

	@Column(length = 50)
	private String ubicacion;

	@Column(length = 30)
	private String unidad;

	@OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<Precio> precios;

	@OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<Generico> genericos;

	public Articulo() {

	}

	public void finalize() throws Throwable {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoArticulo getTipoArticulo() {
		return tipoArticulo;
	}

	public void setTipoArticulo(TipoArticulo tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getCurrentCosto() {
		return currentCosto;
	}

	public void setCurrentCosto(BigDecimal currentCosto) {
		this.currentCosto = currentCosto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getExistenciaMax() {
		return existenciaMax;
	}

	public void setExistenciaMax(Integer existenciaMax) {
		this.existenciaMax = existenciaMax;
	}

	public Integer getExistenciaMin() {
		return existenciaMin;
	}

	public void setExistenciaMin(Integer existenciaMin) {
		this.existenciaMin = existenciaMin;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public List<Precio> getPrecios() {
		return precios;
	}

	public void setPrecios(List<Precio> precios) {
		this.precios = precios;
	}

	public List<Generico> getGenericos() {
		return genericos;
	}

	public void setGenericos(List<Generico> genericos) {
		this.genericos = genericos;
	}
}// end Articulo