package com.bm2i.venta.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import com.bm2i.comun.model.Persona;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:38
 */
@Entity
@TableGenerator(name = "DiaTrabajoGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "DiaTrabajo", initialValue = 1, allocationSize = 1)
public class DiaTrabajo {

	@Id
	@GeneratedValue(generator = "DiaTrabajoGenerator", strategy = GenerationType.TABLE)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date openDate;

	@Temporal(TemporalType.DATE)
	private Date closinDate;

	private Boolean isClosed;

	private Boolean isOpen;

	private String observacion;

	@ManyToOne
	@JoinColumn(name = "supervisor_id")
	private Persona supervisor;

	@OneToMany(mappedBy = "diaTrabajo", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<CajaPermiso> permisos;

	public DiaTrabajo() {

	}

	public void finalize() throws Throwable {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getClosinDate() {
		return closinDate;
	}

	public void setClosinDate(Date closinDate) {
		this.closinDate = closinDate;
	}

	public Boolean getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;
	}

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Persona getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Persona supervisor) {
		this.supervisor = supervisor;
	}

	public List<CajaPermiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<CajaPermiso> permisos) {
		this.permisos = permisos;
	}
}// end DiaTrabajo