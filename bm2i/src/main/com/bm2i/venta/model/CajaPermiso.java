package com.bm2i.venta.model;

import java.math.BigDecimal;
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
@TableGenerator(name = "CajaPermisoGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "CajaPermiso", initialValue = 1, allocationSize = 1)
public class CajaPermiso {

	private BigDecimal balanceInicial;

	@Temporal(TemporalType.DATE)
	private Date closingTime;

	@Id
	@GeneratedValue(generator = "CajaPermisoGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private Boolean isActive;

	@Temporal(TemporalType.DATE)
	private Date openingTime;

	@OneToOne
	private Persona cajero;

	@OneToMany(mappedBy = "", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<RegistroDinero> registros;

	public CajaPermiso() {

	}

	public void finalize() throws Throwable {

	}
}// end CajaPermiso