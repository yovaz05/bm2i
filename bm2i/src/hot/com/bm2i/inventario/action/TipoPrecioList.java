package com.bm2i.inventario.action;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.bm2i.inventario.model.TipoPrecio;

@Name("tipoPrecioList")
public class TipoPrecioList extends EntityQuery<TipoPrecio> {
	

	private static final String EJBQL = "select tipoPrecio from TipoPrecio tipoPrecio";

	private static final String[] RESTRICTIONS = {"lower(tipoPrecio.nombre) like lower(concat(#{tipoPrecioList.tipoPrecio.nombre},'%'))",};

	private TipoPrecio tipoPrecio = new TipoPrecio();
	private String nombre;

	public TipoPrecioList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public TipoPrecio getTipoPrecio() {
		return tipoPrecio;
	}

	public void setTipoPrecio(TipoPrecio tipoPrecio) {
		this.tipoPrecio = tipoPrecio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
