package com.bm2i.venta.action;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.venta.model.Pago;
import com.bm2i.venta.model.TipoPago;

@Name("pagoHome")
public class PagoHome extends EntityHome<Pago> {

	@In(create = true)
	TipoPagoHome tipoPagoHome;

	@In
	FacesMessages facesMessages;

	private Boolean anyError = new Boolean(true);
	private String errorValue;

	public void setPagoId(Long id) {
		setId(id);
	}

	public Long getPagoId() {
		return (Long) getId();
	}

	@Override
	protected Pago createInstance() {
		Pago pago = new Pago();
		return pago;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		TipoPago tipoPago = tipoPagoHome.getDefinedInstance();
		if (tipoPago != null) {
			getInstance().setTipoPago(tipoPago);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Pago getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public void cerrar() {
		this.getInstance().setCambio(new BigDecimal(0));
		this.getInstance().setEfectivo(new BigDecimal(0));
	}

	public List<TipoPago> getTiposPago() {
		Query q = this.getEntityManager().createNamedQuery("TipoPago.findAll");
		this.getInstance().setTipoPago((TipoPago) q.getResultList().get(0));
		return q.getResultList();
	}

	public void calcularCambio() {
		if (this.getInstance().getTotal() != null) {
			int comp = this.getInstance().getEfectivo()
					.compareTo(this.getInstance().getTotal());
			if (comp > 0) {
				this.getInstance().setCambio(
						this.getInstance().getEfectivo()
								.subtract(this.getInstance().getTotal()));
				this.anyError = new Boolean(false);
			} else {
				this.anyError = new Boolean(true);
				facesMessages
						.addToControl(
								"",
								org.jboss.seam.international.StatusMessage.Severity.ERROR,
								"El efectivo no puede ser menor al total");
			}
		} else {
			this.anyError = new Boolean(true);
			facesMessages.addToControl("",
					org.jboss.seam.international.StatusMessage.Severity.ERROR,
					"Debe agregar Articulos al comprobante");
		}
	}

	public Boolean getAnyError() {
		return anyError;
	}

	public void setAnyError(Boolean anyError) {
		this.anyError = anyError;
	}

	public String getErrorValue() {
		return errorValue;
	}

	public void setErrorValue(String errorValue) {
		this.errorValue = errorValue;
	}
}
