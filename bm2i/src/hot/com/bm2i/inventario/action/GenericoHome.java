package com.bm2i.inventario.action;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.inventario.model.Articulo;
import com.bm2i.inventario.model.Generico;

@Name("genericoHome")
public class GenericoHome extends EntityHome<Generico> {

	@In(create = true)
	ArticuloHome articuloHome;

	public void setGenericoId(Long id) {
		setId(id);
	}

	public Long getGenericoId() {
		return (Long) getId();
	}

	@Override
	protected Generico createInstance() {
		Generico generico = new Generico();
		return generico;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Articulo articulo = articuloHome.getDefinedInstance();
		if (articulo != null) {
			getInstance().setArticulo(articulo);
		}
		Articulo generico = articuloHome.getDefinedInstance();
		if (generico != null) {
			getInstance().setGenerico(generico);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Generico getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
