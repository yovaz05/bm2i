package com.bm2i.inventario.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.inventario.model.Articulo;
import com.bm2i.inventario.model.Ganancia;
import com.bm2i.inventario.model.Generico;
import com.bm2i.inventario.model.Linea;
import com.bm2i.inventario.model.Precio;

@Name("articuloHome")
public class ArticuloHome extends EntityHome<Articulo> {

	@In(create = true)
	LineaHome lineaHome;

	public void setArticuloId(Long id) {
		setId(id);
	}

	public Long getArticuloId() {
		return (Long) getId();
	}

	@Override
	protected Articulo createInstance() {
		Articulo articulo = new Articulo();
		return articulo;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Linea linea = lineaHome.getDefinedInstance();
		if (linea != null) {
			getInstance().setLinea(linea);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Articulo getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Generico> getGenericos() {
		return getInstance() == null ? null : new ArrayList<Generico>(
				getInstance().getGenericos());
	}

	public List<Precio> getPrecios() {
		return getInstance() == null ? null : new ArrayList<Precio>(
				getInstance().getPrecios());
	}

	@SuppressWarnings("unchecked")
	public void generarListaPVP() {
		System.out.println("======>>>>> entra a generar");
		Query q = this.getEntityManager().createNamedQuery("Ganancia.findAll");
		List<Ganancia> ganancias = q.getResultList();
		List<Precio> preciosLocal = new ArrayList<Precio>();
		for (Ganancia g : ganancias) {
			System.out.println("======>>>>> valores "+g.getNombre());
			Precio p = new Precio();
			p.setArticulo(this.getInstance());
			p.setCosto(this.getInstance().getCurrentCosto());
			p.setFecha(new Date());
			p.setGanancia(g);
			p.setIsActive(true);
			p.realizarCalculo();
			preciosLocal.add(p);
		}
		this.getInstance().setPrecios(preciosLocal);
	}
	
	

}
