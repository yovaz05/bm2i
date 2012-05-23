package com.bm2i.venta.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	@Temporal(TemporalType.DATE)
	private Date closinDate;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Id
	@GeneratedValue(generator = "DiaTrabajoGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private Boolean isClosed;

	private Boolean isOpen;

	private String observacion;

	@OneToMany(mappedBy = "", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<CajaPermiso> permisos;

	@OneToOne
	private Persona supervisor;

	public DiaTrabajo() {

	}

	public void finalize() throws Throwable {

	}
}// end DiaTrabajo