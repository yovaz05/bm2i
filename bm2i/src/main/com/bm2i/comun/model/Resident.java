package com.bm2i.comun.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import com.bm2i.compra.model.ComprobanteCompra;
import com.bm2i.venta.model.ComprobanteVenta;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:39
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "residentType", discriminatorType = DiscriminatorType.STRING, length = 1)
@TableGenerator(name = "ResidentGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Resident", initialValue = 1, allocationSize = 1)
@NamedQueries(value = {
		@NamedQuery(name = "Resident.findByIdentificationNumber", query = "select resident from Resident resident where "
				+ "resident.numeroIdentificacion like :identificationNumber"),
		@NamedQuery(name = "Resident.findByCriteria", query = "select resident from Resident resident where "
				+ "resident.numeroIdentificacion like concat(:criteria,'%') or "
				+ "lower(resident.nombre) like lower(concat(:criteria, '%')) "
				+ "order by resident.nombre") })
public abstract class Resident {

	@Id
	@GeneratedValue(generator = "ResidentGenerator", strategy = GenerationType.TABLE)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private TipoIdentificacion tipoIdentificacion;

	@Column(length = 15)
	private String numeroIdentificacion;

	@Column(length = 50)
	private String nombre;

	@Column(length = 60)
	private String nombreComercial;

	@Column(length = 50)
	private String email;

	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	@OneToMany(mappedBy = "resident", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<ComprobanteVenta> comprobantesVenta;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	private Direccion currentDireccion;

	@OneToMany(mappedBy = "resident", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, fetch = FetchType.LAZY)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<Direccion> direcciones;

	@OneToMany(mappedBy = "preveedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<ComprobanteCompra> comprobantesCompra;

	public Resident() {
		comprobantesCompra = new ArrayList<ComprobanteCompra>();
		direcciones = new ArrayList<Direccion>();
		comprobantesVenta = new ArrayList<ComprobanteVenta>();
		this.currentDireccion = new Direccion();
		this.add(currentDireccion);
	}

	public void finalize() throws Throwable {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<ComprobanteVenta> getComprobantesVenta() {
		return comprobantesVenta;
	}

	public void setComprobantesVenta(List<ComprobanteVenta> comprobantesVenta) {
		this.comprobantesVenta = comprobantesVenta;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public List<ComprobanteCompra> getComprobantesCompra() {
		return comprobantesCompra;
	}

	public void setComprobantesCompra(List<ComprobanteCompra> comprobantesCompra) {
		this.comprobantesCompra = comprobantesCompra;
	}

	public Direccion getCurrentDireccion() {
		return currentDireccion;
	}

	public void setCurrentDireccion(Direccion currentDireccion) {
		this.currentDireccion = currentDireccion;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public void add(Direccion address) {
		if (!this.direcciones.contains(address)) {
			this.direcciones.add(address);
		}
	}

	public void remove(Direccion address) {
		this.direcciones.remove(address);
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Resident)) {
			return false;
		}
		Resident other = (Resident) object;

		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
}// end Resident