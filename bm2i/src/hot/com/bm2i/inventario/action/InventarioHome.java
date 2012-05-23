package com.bm2i.inventario.action;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.inventario.model.Articulo;
import com.bm2i.inventario.model.Inventario;
import com.bm2i.inventario.model.TipoRegistro;

@Name("inventarioHome")
public class InventarioHome extends EntityHome<Inventario> {

	@In(create = true)
	ArticuloHome articuloHome;
	@In(create = true)
	TipoRegistroHome tipoRegistroHome;

	public void setInventarioId(Long id) {
		setId(id);
	}

	public Long getInventarioId() {
		return (Long) getId();
	}

	@Override
	protected Inventario createInstance() {
		Inventario inventario = new Inventario();
		return inventario;
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
		TipoRegistro tipoRegistro = tipoRegistroHome.getDefinedInstance();
		if (tipoRegistro != null) {
			getInstance().setTipoRegistro(tipoRegistro);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Inventario getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
