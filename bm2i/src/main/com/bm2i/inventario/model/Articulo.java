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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cascade;

import com.bm2i.venta.model.ItemComprobanteVenta;

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

	private Integer cantidad;

	private String codigoBarra;

	private BigDecimal currentCosto;

	private String descripcion;

	private Integer existenciaMax;

	private Integer existenciaMin;

	@Id
	@GeneratedValue(generator = "ArticuloGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private String nombre;

	private String ubicacion;

	private String unidad;

	@OneToMany(mappedBy = "", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<ItemComprobanteVenta> items;

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private TipoArticulo tipoArticulo;

	@OneToMany(mappedBy = "", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<Precio> precios;

	@OneToOne
	private Linea linea;

	@OneToMany(mappedBy = "", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<Generico> genericos;

	public Articulo() {

	}

	public void finalize() throws Throwable {

	}
}// end Articulo