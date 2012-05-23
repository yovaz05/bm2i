package com.bm2i.compra.action;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.compra.model.ComprobanteCompra;
import com.bm2i.compra.model.ItemComprobanteCompra;
import com.bm2i.comun.action.ResidentHome;
import com.bm2i.comun.model.Resident;
import com.bm2i.venta.action.TipoPagoHome;
import com.bm2i.venta.model.TipoPago;

@Name("comprobanteCompraHome")
public class ComprobanteCompraHome extends EntityHome<ComprobanteCompra> {

	@In(create = true)
	ResidentHome residentHome;
	@In(create = true)
	TipoPagoHome tipoPagoHome;

	public void setComprobanteCompraId(Long id) {
		setId(id);
	}

	public Long getComprobanteCompraId() {
		return (Long) getId();
	}

	@Override
	protected ComprobanteCompra createInstance() {
		ComprobanteCompra comprobanteCompra = new ComprobanteCompra();
		return comprobanteCompra;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Resident preveedor = residentHome.getDefinedInstance();
		if (preveedor != null) {
			getInstance().setPreveedor(preveedor);
		}
		TipoPago tipoPago = tipoPagoHome.getDefinedInstance();
		if (tipoPago != null) {
			getInstance().setTipoPago(tipoPago);
		}
	}

	public boolean isWired() {
		return true;
	}

	public ComprobanteCompra getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ItemComprobanteCompra> getItems() {
		return getInstance() == null
				? null
				: new ArrayList<ItemComprobanteCompra>(getInstance().getItems());
	}

}
