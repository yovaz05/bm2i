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
import com.bm2i.comun.model.TipoComprobateImpuesto;
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

	private TasaImpuesto ti;
	private Integer maxRows = new Integer(10);
	private int actualRow;

	// para el panel de busqueda de articulos
	private List<Articulo> articulos;
	private List<ItemComprobanteVenta> itemAux = new ArrayList<ItemComprobanteVenta>();
	private String criteriaArticulo;

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
		if (itemAux.size() <= 0) {
			System.out.println("=========>>> crea los items para la factura");
			for (int i = 0; i < 10; i++) {
				ItemComprobanteVenta icv = new ItemComprobanteVenta();
				icv.setCantidad(1);
				itemAux.add(icv);
			}
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
					Articulo art = (Articulo) q.getResultList().get(0);
					if (!existeArticuloEnItems(art)) {
						itemLocal.setArticulo(art);
						itemLocal.setvUnitario(art.getCurrentPrecio().getPvp());
						editarValoresItem(itemLocal);
						actualRow++;
					} else {
						itemLocal.setCodigoBarra("");
					}
				}
			}
		}
	}

	/**
	 * determina si el articulo ya existe en los items de la factura si ya
	 * existe se agrega 1 en la cantidad de vendida
	 * 
	 * @param nuevoArticulo
	 * @return true si ya ha sido agregado el articulo
	 */
	public boolean existeArticuloEnItems(Articulo nuevoArticulo) {
		boolean ban = false;
		// this.getInstance().getItems()
		for (ItemComprobanteVenta icv : this.itemAux) {
			if (icv.getArticulo() != null) {
				if (icv.getArticulo().getId() == nuevoArticulo.getId()) {
					ban = true;
					// agrego 1
					icv.setCantidad(icv.getCantidad() + 1);
					editarValoresItem(icv);
				}
			}
		}
		return ban;
	}

	public void editarValoresItem(ItemComprobanteVenta it) {
		if (it.getArticulo() != null) {
			double costo = it.getArticulo().getCurrentPrecio().getCosto()
					.doubleValue();
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
		} else {
			it.setIsValid(new Boolean(true));
			it.setvTotal(null);
			it.setCantidad(1);
		}

		calculoComprobanteVenta();
	}

	public void calculoComprobanteVenta() {
		// identificarDesgloce();
		// for (ItemComprobanteVenta it : this.getInstance().getItems()) {
		int cantArticulosIVA = 0;
		int cantArticulosSINIVA = 0;
		for (ItemComprobanteVenta it : this.itemAux) {
			if (it.getArticulo() != null) {
				if (it.getArticulo().getIsCalculatedIva()) {
					this.getInstance().setSubTotalIva(
							this.getInstance().getSubTotalIva()
									.add(it.getvTotal()));
					cantArticulosIVA++;
				} else {
					this.getInstance().setSubTotalCero(
							this.getInstance().getSubTotalCero()
									.add(it.getvTotal()));
					cantArticulosSINIVA++;
				}
			}
		}
		if (cantArticulosSINIVA == 0) {
			this.getInstance().setSubTotalCero(new BigDecimal(0));
		}
		if (cantArticulosIVA == 0) {
			this.getInstance().setSubTotalIva(new BigDecimal(0));
		}
		// calculo de iva
		if (this.getInstance().getSubTotalIva() != null) {
			this.getInstance().setIva(
					this.getInstance().getSubTotalIva()
							.multiply(new BigDecimal(0.12)));
		}

		this.getInstance().setValorTotal(
				this.getInstance().getSubTotalIva()
						.add(this.getInstance().getSubTotalCero()));

		this.pagoHome.getInstance()
				.setTotal(this.getInstance().getValorTotal());
	}

	/**
	 * metodo no completo, revisar en el caso de mas impuesto q no sean iva
	 * 
	 * @return
	 */
	public BigDecimal calcularValorImpuesto() {
		TipoComprobante tc = this.getInstance().getTipoComprobante();
		Query q = this.getEntityManager().createNamedQuery(
				"TipoComprobateImpuesto.findImpuesto");
		q.setParameter("tipoComprobante", tc);
		if (q.getResultList().size() > 0) {
			// todo
			// se debe tener mayo control revisar
			TipoComprobateImpuesto tci = (TipoComprobateImpuesto) q
					.getSingleResult();

			return new BigDecimal(0);
		} else
			return new BigDecimal(0);
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

	public void removeArticuloItem(ItemComprobanteVenta it) {
		it.setArticulo(null);
		it.setvUnitario(null);
		it.setCodigoBarra("");
		editarValoresItem(it);
		if (actualRow > 0) {
			actualRow--;
		}

	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public String getCriteriaArticulo() {
		return criteriaArticulo;
	}

	public void setCriteriaArticulo(String criteriaArticulo) {
		this.criteriaArticulo = criteriaArticulo;
	}

	@SuppressWarnings("unchecked")
	public void buscarArticulos() {
		// que no sea null
		if (criteriaArticulo != null) {
			// que no este vacio
			if (!criteriaArticulo.equals("")) {
				// q sea una cadena mayor o = a 3 caracteres
				if (criteriaArticulo.length() > 3) {
					Query q = this.getEntityManager().createNamedQuery(
							"Articulo.findByCriteria");
					q.setParameter("codigoBarra", criteriaArticulo);
					q.setParameter("nombre", criteriaArticulo);
					q.setParameter("ubicacion", criteriaArticulo);
					articulos = q.getResultList();
				}
			}
		}
	}

	public void seleccionarArticulo(Articulo articulo) {
		// this.getInstance().getItems()
		ItemComprobanteVenta itemLocal = this.itemAux.get(actualRow);
		if (!existeArticuloEnItems(articulo)) {
			itemLocal.setCodigoBarra(articulo.getCodigoBarra());
			itemLocal.setArticulo(articulo);
			itemLocal.setvUnitario(articulo.getCurrentPrecio().getPvp());
			actualRow++;
		} else {
			itemLocal.setCodigoBarra("");
		}

	}

	public void limpiarPanelBusqueda() {
		this.articulos = null;
		this.criteriaArticulo = null;
	}

	public int getActualRow() {
		return actualRow;
	}

	public void setActualRow(int actualRow) {
		this.actualRow = actualRow;
	}

	public List<ItemComprobanteVenta> getItemAux() {
		return itemAux;
	}

	public void setItemAux(List<ItemComprobanteVenta> itemAux) {
		this.itemAux = itemAux;
	}

	public void guardar() {
		this.residentHome.savaOrUpdate();
		for (ItemComprobanteVenta icv : this.itemAux) {
			if (icv.getArticulo() != null) {
				System.out.println("entra a guardar");
				this.getInstance().add(icv);
			}
		}
		// super.persist();
	}
	
	

}
