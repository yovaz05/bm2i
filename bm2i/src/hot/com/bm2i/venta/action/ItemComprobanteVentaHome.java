package com.bm2i.venta.action;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.inventario.action.ArticuloHome;
import com.bm2i.inventario.model.Articulo;
import com.bm2i.venta.model.ComprobanteVenta;
import com.bm2i.venta.model.ItemComprobanteVenta;

@Name("itemComprobanteVentaHome")
public class ItemComprobanteVentaHome extends EntityHome<ItemComprobanteVenta> {

	@In(create = true)
	ArticuloHome articuloHome;
	@In(create = true)
	ComprobanteVentaHome comprobanteVentaHome;

	public void setItemComprobanteVentaId(Long id) {
		setId(id);
	}

	public Long getItemComprobanteVentaId() {
		return (Long) getId();
	}

	@Override
	protected ItemComprobanteVenta createInstance() {
		ItemComprobanteVenta itemComprobanteVenta = new ItemComprobanteVenta();
		return itemComprobanteVenta;
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
		ComprobanteVenta venta = comprobanteVentaHome.getDefinedInstance();
		if (venta != null) {
			getInstance().setVenta(venta);
		}
	}

	public boolean isWired() {
		return true;
	}

	public ItemComprobanteVenta getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
