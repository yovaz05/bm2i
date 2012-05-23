package com.bm2i.inventario.action;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.inventario.model.Articulo;
import com.bm2i.inventario.model.Ganancia;
import com.bm2i.inventario.model.Precio;

@Name("precioHome")
public class PrecioHome extends EntityHome<Precio> {

	@In(create = true)
	ArticuloHome articuloHome;
	@In(create = true)
	GananciaHome gananciaHome;

	public void setPrecioId(Long id) {
		setId(id);
	}

	public Long getPrecioId() {
		return (Long) getId();
	}

	@Override
	protected Precio createInstance() {
		Precio precio = new Precio();
		return precio;
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
		Ganancia ganancia = gananciaHome.getDefinedInstance();
		if (ganancia != null) {
			getInstance().setGanancia(ganancia);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Precio getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
