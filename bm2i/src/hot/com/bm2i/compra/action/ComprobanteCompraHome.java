package com.bm2i.compra.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.compra.model.ComprobanteCompra;
import com.bm2i.compra.model.ItemComprobanteCompra;
import com.bm2i.comun.action.ResidentHome;
import com.bm2i.comun.model.Resident;
import com.bm2i.inventario.model.Articulo;
import com.bm2i.security.action.UserSession;
import com.bm2i.venta.action.TipoPagoHome;
import com.bm2i.venta.model.ItemComprobanteVenta;
import com.bm2i.venta.model.TipoPago;

@Name("comprobanteCompraHome")
public class ComprobanteCompraHome extends EntityHome<ComprobanteCompra> {

	@In(create = true)
	ResidentHome residentHome;
	@In(create = true)
	TipoPagoHome tipoPagoHome;

	@In
	FacesMessages facesMessages;

	// para el panel de busqueda de articulos
	private List<Articulo> articulos;
	private List<ItemComprobanteCompra> itemAux = new ArrayList<ItemComprobanteCompra>();
	private String criteriaArticulo;

	@In(scope = ScopeType.SESSION, value = "userSession")
	UserSession userSession;
	private Integer maxRows = new Integer(10);
	private int actualRow;

	// para reporte
	private BigDecimal iva;
	private BigDecimal subTotal;
	private BigDecimal descuento;
	private BigDecimal subTotalCero;
	private BigDecimal subTotalIva;
	private BigDecimal total;

	private String criterio;
	private List<Resident> residents;

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

		if (itemAux.size() <= 0) {
			for (int i = 0; i < 18; i++) {
				ItemComprobanteCompra icv = new ItemComprobanteCompra();
				icv.setCantidad(1);
				itemAux.add(icv);
			}
		}
	}

	public boolean isWired() {
		return true;
	}

	public ComprobanteCompra getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ItemComprobanteCompra> getItems() {
		return getInstance() == null ? null
				: new ArrayList<ItemComprobanteCompra>(getInstance().getItems());
	}

	public List<TipoPago> getTiposPago() {
		Query q = this.getEntityManager().createNamedQuery("TipoPago.findAll");
		this.getInstance().setTipoPago((TipoPago) q.getResultList().get(0));
		return q.getResultList();
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

	public Integer getMaxRows() {
		return maxRows;
	}

	public void setMaxRows(Integer maxRows) {
		this.maxRows = maxRows;
	}

	public int getActualRow() {
		return actualRow;
	}

	public void setActualRow(int actualRow) {
		this.actualRow = actualRow;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getSubTotalCero() {
		return subTotalCero;
	}

	public void setSubTotalCero(BigDecimal subTotalCero) {
		this.subTotalCero = subTotalCero;
	}

	public BigDecimal getSubTotalIva() {
		return subTotalIva;
	}

	public void setSubTotalIva(BigDecimal subTotalIva) {
		this.subTotalIva = subTotalIva;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getCriterio() {
		return criterio;
	}

	public void setCriterio(String criterio) {
		this.criterio = criterio;
	}

	public List<Resident> getResidents() {
		return residents;
	}

	public void setResidents(List<Resident> residents) {
		this.residents = residents;
	}

	@SuppressWarnings("unchecked")
	public void buscarArticulos() {
		// que no sea null
		if (criteriaArticulo != null) {
			// que no este vacio
			if (!criteriaArticulo.equals("")) {
				// q sea una cadena mayor o = a 3 caracteres
				if (criteriaArticulo.length() >= 3) {
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
		ItemComprobanteCompra itemLocal = this.itemAux.get(actualRow);
		if (!existeArticuloEnItems(articulo)) {
			itemLocal.setCodigoBarra(articulo.getCodigoBarra());
			itemLocal.setArticulo(articulo);
			itemLocal.setIsCodigoBarraEnabled(new Boolean(false));
			// editarValoresItem(itemLocal);
			actualRow++;

		} else {
			itemLocal.setCodigoBarra("");
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
		for (ItemComprobanteCompra icv : this.itemAux) {
			if (icv.getArticulo() != null) {
				if (icv.getArticulo().getId() == nuevoArticulo.getId()) {
					ban = true;
					// agrego 1
					icv.setCantidad(icv.getCantidad() + 1);
					// editarValoresItem(icv);
				}
			}
		}
		return ban;
	}

	public List<ItemComprobanteCompra> getItemAux() {
		return itemAux;
	}

	public void setItemAux(List<ItemComprobanteCompra> itemAux) {
		this.itemAux = itemAux;
	}

	public void removeArticuloItem(ItemComprobanteCompra it) {
		it.setArticulo(null);
		it.setvUnitario(null);
		it.setCodigoBarra("");

		it.setIsCodigoBarraEnabled(new Boolean(true));
		if (actualRow > 0) {
			actualRow--;
		}
	}

	@Override
	public String persist() {
		if (this.residentHome.getInstance().getNumeroIdentificacion() != null) {
			if (actualRow > 0) {
				this.residentHome.evaluateName();
				this.getInstance().setPreveedor(this.residentHome.getInstance());
				this.getInstance().setRegistrador(this.userSession.getPersona());
				for (ItemComprobanteCompra icv : this.itemAux) {
					if (icv.getArticulo() != null) {
						this.getInstance().add(icv);
					}
				}
				return super.persist();
			} else {
				facesMessages
						.addToControl(
								"",
								org.jboss.seam.international.StatusMessage.Severity.ERROR,
								"Debe agregar articulos al comprobate");
				return null;
			}
		} else {
			facesMessages.addToControl("",
					org.jboss.seam.international.StatusMessage.Severity.ERROR,
					"Revise los datos del contribuyente");
			return null;
		}
	}
	
	public void limpiarPanelBusqueda() {
		this.articulos = null;
		this.criteriaArticulo = null;
	}
	
}
