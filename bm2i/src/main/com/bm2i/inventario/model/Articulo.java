package com.bm2i.inventario.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

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
@NamedQueries(value = {
		@NamedQuery(name = "Articulo.findByCodigoNombre", query = "select a from Articulo a where "
				+ "lower(a.nombre) like lower(concat(:criteria, '%')) or "
				+ "lower(a.codigoBarra) like lower(concat(:criteria, '%')) "
				+ "order by a.nombre"),
		@NamedQuery(name = "Articulo.findByCodigoBarra", query = "select a from Articulo a where "
				+ "lower(a.codigoBarra) like lower(:criteria) "
				+ "order by a.nombre"),
		@NamedQuery(name = "Articulo.findByNombre", query = "select a from Articulo a where "
				+ "lower(a.nombre) = lower(:nombre) " + "order by a.nombre"),
		@NamedQuery(name = "Articulo.listarExistencias", query = "select a from Articulo a "
				+ "order by a.cantidad desc"),
		@NamedQuery(name = "Articulo.findByCriteria", query = "select a from Articulo a where "
				+ "lower(a.codigoBarra) like lower(concat(:codigoBarra,'%')) or "
				+ "lower(a.nombre) like lower(concat('%',:nombre,'%')) or "
				+ "lower(a.ubicacion) like lower(concat(:ubicacion,'%')) "
				+ "order by a.nombre desc") })
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

	private Boolean isCalculatedIva;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "currentPrecio_id")
	private Precio currentPrecio;

	/*
	 * @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL)
	 * 
	 * @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	 */
	@OneToMany(mappedBy = "articulo", cascade = { CascadeType.ALL })
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@OrderBy("fecha")
	private List<Precio> precios;

	@OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<Generico> genericos;

	@OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<Lote> lotes;

	@OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<Punto> puntos;

	private BigDecimal punto;

	/*
	 * @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch =
	 * FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "punto_id") private Punto punto;
	 */

	@Transient
	private BigDecimal pvpCorrecto;
	
	@Transient
	private Precio precio;

	public Articulo() {
		// this.currentPrecio = new Precio();
		precios = new ArrayList<Precio>();
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
		this.nombre = nombre.toUpperCase();
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

	public Boolean getIsCalculatedIva() {
		return isCalculatedIva;
	}

	public void setIsCalculatedIva(Boolean isCalculatedIva) {
		this.isCalculatedIva = isCalculatedIva;
	}

	public void add(Precio precio) {
		if (!this.precios.contains(precio)) {
			precio.setArticulo(this);
			this.precios.add(precio);
		}
	}

	public void remove(Precio precio) {
		this.precios.remove(precio);
	}

	public Precio getCurrentPrecio() {
		return currentPrecio;
	}

	public void setCurrentPrecio(Precio currentPrecio) {
		this.currentPrecio = currentPrecio;
	}

	public List<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}

	public BigDecimal getPvpCorrecto() {
		return pvpCorrecto;
	}

	public void setPvpCorrecto(BigDecimal pvpCorrecto) {
		this.pvpCorrecto = pvpCorrecto;
	}

	public BigDecimal getPunto() {
		return punto;
	}

	public void setPunto(BigDecimal punto) {
		this.punto = punto;
	}

	public Precio getPrecio() {
		return precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}

}// end Articulo