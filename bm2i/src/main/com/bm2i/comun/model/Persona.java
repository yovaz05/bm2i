package com.bm2i.comun.model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
	
	public static final String YEAR = "YEAR";
	public static final String MONTH = "MONTH";
	public static final String DATE = "DATE";

	@Column(length = 50)
	private String nombres;

	@Column(length = 50)
	private String apellidos;

	@Temporal(TemporalType.DATE)
	private Date birthDay;

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

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	
	public Map<String, Integer> getAge(){
		Calendar now = Calendar.getInstance();
		
		Calendar birthDay = Calendar.getInstance();
		birthDay.setTime(this.birthDay);
		
		if (birthDay.after(now))
			return null;

	    Integer year = now.get(Calendar.YEAR);
	    Integer month = now.get(Calendar.MONTH);
	    Integer day = now.get(Calendar.DATE);
	        
	    // PARA LOS DIAS
	    if (day < birthDay.get(Calendar.DATE)){
	    	int ndays = now.getActualMaximum(Calendar.DAY_OF_MONTH);
	        day = (day + ndays) - birthDay.get(Calendar.DATE);
	        // como pedi un mes dias tengo que devolver al mes actual
	        month--;
	    }else
	    	day = day - birthDay.get(Calendar.DATE);
	        
	    if (month < birthDay.get(Calendar.MONTH)){
	    	month = (month + 12) - birthDay.get(Calendar.MONTH);
	        // como pedi un anio en meses tengo que devolver al anio actual
	        year--;
	    }else
	    	month = month - birthDay.get(Calendar.MONTH);
	        
	    if (year > birthDay.get(Calendar.YEAR)){
	        //now.add(Calendar.YEAR, -(birthDate.get(Calendar.YEAR)));
	        year = year - birthDay.get(Calendar.YEAR);
	    }else{
	    	year = 0;
	    }	    
	    //return new GregorianCalendar(year, month, day);
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    map.put(YEAR, year);
	    map.put(MONTH, month);
	    map.put(DATE, day);
	    
	    return map;
	}
	
	public String getAgeToString(){
		Map<String, Integer> ageFull = this.getAge();
		if (ageFull != null){
			Integer year = ageFull.get(YEAR);
		    Integer month = ageFull.get(MONTH);
		    Integer day = ageFull.get(DATE);
		    
			StringBuffer dateStr = new StringBuffer(year + " a\u00f1o(s), " );
	        dateStr.append(month + " mes(es), " +  day + " d\u00eda(s)");
	        return dateStr.toString();
		}else{
			return "Aun no ha nacido...";
		}
		
	}
	
	@Override
	public String toString() {
		return this.getApellidos().toUpperCase() + " " + this.getNombres().toUpperCase();
	}
}// end Persona