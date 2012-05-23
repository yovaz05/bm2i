package com.bm2i.compra.action;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.compra.model.ComprobanteCompra;
import com.bm2i.compra.model.ItemComprobanteCompra;
import com.bm2i.inventario.action.ArticuloHome;
import com.bm2i.inventario.model.Articulo;

@Name("itemComprobanteCompraHome")
public class ItemComprobanteCompraHome
		extends
			EntityHome<ItemComprobanteCompra> {

	@In(create = true)
	ArticuloHome articuloHome;
	@In(create = true)
	ComprobanteCompraHome comprobanteCompraHome;

	public void setItemComprobanteCompraId(Long id) {
		setId(id);
	}

	public Long getItemComprobanteCompraId() {
		return (Long) getId();
	}

	@Override
	protected ItemComprobanteCompra createInstance() {
		ItemComprobanteCompra itemComprobanteCompra = new ItemComprobanteCompra();
		return itemComprobanteCompra;
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
		ComprobanteCompra compra = comprobanteCompraHome.getDefinedInstance();
		if (compra != null) {
			getInstance().setCompra(compra);
		}
	}

	public boolean isWired() {
		return true;
	}

	public ItemComprobanteCompra getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
