package com.bm2i.venta.action;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.comun.action.ResidentHome;
import com.bm2i.comun.action.TipoComprobanteHome;
import com.bm2i.comun.model.Impuesto;
import com.bm2i.comun.model.Resident;
import com.bm2i.comun.model.TasaImpuesto;
import com.bm2i.comun.model.TipoComprobante;
import com.bm2i.inventario.model.Articulo;
import com.bm2i.venta.model.ComprobanteVenta;
import com.bm2i.venta.model.ItemComprobanteVenta;
import com.bm2i.venta.model.Pago;

@Name("comprobanteVentaHome")
public class ComprobanteVentaHome extends EntityHome<ComprobanteVenta> {

	@In(create = true)
	PagoHome pagoHome;
	@In(create = true)
	ResidentHome residentHome;
	@In(create = true)
	TipoComprobanteHome tipoComprobanteHome;
	
	TasaImpuesto ti;

	private Integer maxRows = new Integer(10);

	public void setComprobanteVentaId(Long id) {
		setId(id);
	}

	public Long getComprobanteVentaId() {
		return (Long) getId();
	}

	@Override
	protected ComprobanteVenta createInstance() {
		ComprobanteVenta comprobanteVenta = new ComprobanteVenta();
		return comprobanteVenta;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Pago pago = pagoHome.getDefinedInstance();
		if (pago != null) {
			getInstance().setPago(pago);
		}
		Resident resident = residentHome.getDefinedInstance();
		if (resident != null) {
			getInstance().setResident(resident);
		}
		TipoComprobante tipoComprobante = tipoComprobanteHome
				.getDefinedInstance();
		if (tipoComprobante != null) {
			getInstance().setTipoComprobante(tipoComprobante);
		}
	}

	public boolean isWired() {
		return true;
	}

	public ComprobanteVenta getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ItemComprobanteVenta> getItems() {
		return getInstance() == null ? null
				: new ArrayList<ItemComprobanteVenta>(getInstance().getItems());
	}

	/*public void generarItem() {
		System.out.println("======>>>>>>>>>> entra a cargar los items");
		if (this.getInstance().getItems().size() <= maxRows) {
			ItemComprobanteVenta itemLocal = new ItemComprobanteVenta();
			this.instance.add(itemLocal);
		} else {

		}
		// calculoComprobanteVenta();
	}*/

	public Integer getMaxRows() {
		return maxRows;
	}

	public void setMaxRows(Integer maxRows) {
		this.maxRows = maxRows;
	}

	public void buscarCodigoBarra(ItemComprobanteVenta itemLocal) {
		if (itemLocal.getCodigoBarra() != null) {
			if (!itemLocal.getCodigoBarra().equals("")) {
				Query q = this.getEntityManager().createNamedQuery(
						"Articulo.findByCodigoBarra");
				q.setParameter("criteria", itemLocal.getCodigoBarra());
				if (q.getResultList().size() > 0) {
					System.out.println("entra a asignar");
					Articulo art=(Articulo) q.getResultList().get(0);
					itemLocal.setArticulo(art);
					itemLocal.setvUnitario(art.getCurrentPrecio().getPvp());
					itemLocal.setvUnitario(art.getCurrentPrecio().getCosto());
				}
			}
		}
	}
	
	public void editarValoresItem(ItemComprobanteVenta it) {
		double costo = it.getvUnitario().doubleValue();
		double pvp = it.getvUnitario().doubleValue();
		int cantidad = it.getCantidad();
		double pvpTotal = pvp * cantidad;
		BigDecimal totalbd = new BigDecimal(pvpTotal);
		totalbd = totalbd.setScale(2, RoundingMode.HALF_UP);
		it.setvTotal(null);
		it.setvTotal(totalbd);
		if (it.getConPerdida()) {
			it.setIsValid(new Boolean(true));
		} else {
			if (pvp > costo) {
				it.setIsValid(new Boolean(true));
			} else {
				it.setIsValid(new Boolean(false));
			}
		}
		//calculoComprobanteVenta();
	}
	
	public void calculoComprobanteVenta() {
		identificarDesgloce();
		double subTotalIva = 0;
		double subTotalCero = 0;
		double subTotal = 0;
		double iva = 0;
		double total = 0;
		for (ItemComprobanteVenta it : this.getInstance().getItems()) {
			if (this.getInstance().getDesgloceImpuesto()) {
				/*if (it.getArticulo().getIva()) {
					subTotalIva = subTotalIva + it.getvTotal().doubleValue();
				} else {
					subTotalCero = subTotalCero + it.getvTotal().doubleValue();
				}*/
			}
			// total = total + it.getvTotal().doubleValue();
			System.out.println("=====el total ======>>>>>>> " + total);
		}
		/*
		 * / ////// BigDecimal subTotalIvabd = new BigDecimal(subTotalIva);
		 * subTotalIvabd = subTotalIvabd.setScale(2, RoundingMode.HALF_UP);
		 * this.getInstance().setSubTotalIva(subTotalIvabd); // //// BigDecimal
		 * subTotalCerobd = new BigDecimal(subTotalCero); subTotalCerobd =
		 * subTotalCerobd.setScale(2, RoundingMode.HALF_UP);
		 * this.getInstance().setSubTotalCero(subTotalCerobd); // ////
		 * BigDecimal totalbd = new BigDecimal(total); totalbd =
		 * totalbd.setScale(2, RoundingMode.HALF_UP);
		 * this.getInstance().setValorTotal(totalbd);
		 * 
		 * this.pagoHome.getInstance().setTotal(totalbd);
		 */

		// this.getInstance().getPago().setTotal(totalbd);
	}

	/**
	 * identifica si es necesario hacer desgloce y de cuanto es el impuesto IVA
	 */
	public void identificarDesgloce() {
		TipoComprobante tc = null;
		if (this.getInstance().getTipoComprobante() != null) {
			tc = this.getInstance().getTipoComprobante();
		} else {
			Query q1 = this.getEntityManager().createNamedQuery(
					"TipoComprobante.findById");
			q1.setParameter("id", new Long(3));
			tc = (TipoComprobante) q1.getResultList().get(0);
			this.getInstance().setTipoComprobante(tc);
		}
		if (tc != null) {
			Query q = this.getEntityManager().createNamedQuery(
					"Impuesto.findByTipoComprobante");
			q.setParameter("tipoComprobante", tc);
			Impuesto impuesto = null;
			if (q.getResultList().size() > 0) {
				impuesto = (Impuesto) q.getResultList().get(0);
				this.getInstance().setDesgloceImpuesto(new Boolean(true));
				if (impuesto != null) {
					Query q2 = this.getEntityManager().createNamedQuery(
							"TasaImpuesto.findByImpuestoActive");
					q2.setParameter("impuesto", impuesto);
					if (q2.getResultList().size() > 0) {
						ti = (TasaImpuesto) q2.getResultList().get(0);
						System.out.println("====> con desgloce de "
								+ ti.getValor());
					}
				}
			} else {
				this.getInstance().setDesgloceImpuesto(new Boolean(false));
				System.out.println("====> sin desgloce");
			}

		}
	}

	public TasaImpuesto getTi() {
		return ti;
	}

	public void setTi(TasaImpuesto ti) {
		this.ti = ti;
	}
	
}
