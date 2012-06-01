package com.bm2i.venta.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cascade;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:39
 */
@Entity
@TableGenerator(name = "SucursalGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Sucursal", initialValue = 1, allocationSize = 1)
@NamedQueries(value = { @NamedQuery(name = "Sucursal.findAll", query = "select s from Sucursal s order by s.nombre") })
public class Sucursal {

	@Id
	@GeneratedValue(generator = "SucursalGenerator", strategy = GenerationType.TABLE)
	private Long id;

	@Column(length = 30)
	private String nombre;

	@OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<Caja> cajas;

	public Sucursal() {
		cajas = new ArrayList<Caja>();
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
		this.nombre = nombre.toUpperCase();
	}

	public List<Caja> getCajas() {
		return cajas;
	}

	public void setCajas(List<Caja> cajas) {
		this.cajas = cajas;
	}

	public void add(Caja caja) {
		if (!this.cajas.contains(caja)) {
			this.cajas.add(caja);
			caja.setSucursal(this);
		}
	}

	public void remove(Caja caja) {
		boolean removed = this.cajas.remove(caja);
		if (removed)
			caja.setSucursal(null);
	}

}// end Sucursal