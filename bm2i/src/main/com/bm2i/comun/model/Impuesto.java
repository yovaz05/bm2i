package com.bm2i.comun.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:39
 */
@Entity
@TableGenerator(name = "ImpuestoGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Impuesto", initialValue = 1, allocationSize = 1)
public class Impuesto {

	@Id
	@GeneratedValue(generator = "ImpuestoGenerator", strategy = GenerationType.TABLE)
	private Long id;

	@Column(length = 30)
	private String nombre;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Boolean isActive;

	@OneToMany(mappedBy = "impuesto", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<TasaImpuesto> tasas;

	@ManyToOne
	TipoComprobante tipoComprobante;

	public Impuesto() {

	}

	public void finalize() throws Throwable {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<TasaImpuesto> getTasas() {
		return tasas;
	}

	public void setTasas(List<TasaImpuesto> tasas) {
		this.tasas = tasas;
	}

	public TipoComprobante getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(TipoComprobante tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}
}// end Impuesto