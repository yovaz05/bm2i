package com.bm2i.venta.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Sucursal {

	@Id
	@GeneratedValue(generator = "SucursalGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private String nombre;

	@OneToMany(mappedBy = "", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<Caja> cajas;

	public Sucursal() {

	}

	public void finalize() throws Throwable {

	}
}// end Sucursal