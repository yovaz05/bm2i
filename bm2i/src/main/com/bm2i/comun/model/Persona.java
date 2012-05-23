package com.bm2i.comun.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import com.bm2i.security.Usuario;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:39
 */
@Entity
@DiscriminatorValue(value = "N")
@NamedQueries(value = {
		@NamedQuery(name = "Persona.findPersona", query = "SELECT p FROM Persona p WHERE lower(p.numeroIdentificacion) LIKE lower(concat(:criteria,'%')) or lower(p.apellidos) like lower(concat(:criteria,'%'))"),
		@NamedQuery(name = "Persona.findByCriteria", query = "select p from Persona p where "
				+ "lower(p.apellidos) like lower(concat(:criteria, '%')) or "
				+ "lower(p.numeroIdentificacion) like lower(concat(:criteria, '%')) ") })
public class Persona extends Resident {

	@Column(length = 50)
	private String nombres;

	@Column(length = 50)
	private String apellidos;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private Boolean isDiscapacitado;

	@Column(length = 20)
	private String numeroDiscapacidad;

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private Genero genero;

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private EstadoCivil estadoCivil;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@JoinColumn(name = "user_id")
	private Usuario user;

	
	public Persona() {

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getIsDiscapacitado() {
		return isDiscapacitado;
	}

	public void setIsDiscapacitado(Boolean isDiscapacitado) {
		this.isDiscapacitado = isDiscapacitado;
	}

	public String getNumeroDiscapacidad() {
		return numeroDiscapacidad;
	}

	public void setNumeroDiscapacidad(String numeroDiscapacidad) {
		this.numeroDiscapacidad = numeroDiscapacidad;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
}// end Persona