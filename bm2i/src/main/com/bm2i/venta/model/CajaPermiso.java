package com.bm2i.venta.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import com.bm2i.comun.model.Persona;

/**
 * @author richard
 * @version 1.0
 * @created 23-May-2012 10:53:38
 */
@Entity
@TableGenerator(name = "CajaPermisoGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "CajaPermiso", initialValue = 1, allocationSize = 1)
public class CajaPermiso {

	@Id
	@GeneratedValue(generator = "CajaPermisoGenerator", strategy = GenerationType.TABLE)
	private Long id;

	private BigDecimal balanceInicial;

	@Temporal(TemporalType.DATE)
	private Date openingTime;

	@Temporal(TemporalType.DATE)
	private Date closingTime;

	private Boolean isActive;

	@ManyToOne
	@JoinColumn(name = "cajero_id")
	private Persona cajero;

	@ManyToOne
	private DiaTrabajo diaTrabajo;

	@ManyToOne
	private Caja caja;

	@OneToMany(mappedBy = "cajaPermiso", cascade = CascadeType.ALL)
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<RegistroDinero> registros;

	public CajaPermiso() {

	}

	public void finalize() throws Throwable {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getBalanceInicial() {
		return balanceInicial;
	}

	public void setBalanceInicial(BigDecimal balanceInicial) {
		this.balanceInicial = balanceInicial;
	}

	public Date getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(Date openingTime) {
		this.openingTime = openingTime;
	}

	public Date getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(Date closingTime) {
		this.closingTime = closingTime;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Persona getCajero() {
		return cajero;
	}

	public void setCajero(Persona cajero) {
		this.cajero = cajero;
	}

	public DiaTrabajo getDiaTrabajo() {
		return diaTrabajo;
	}

	public void setDiaTrabajo(DiaTrabajo diaTrabajo) {
		this.diaTrabajo = diaTrabajo;
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public List<RegistroDinero> getRegistros() {
		return registros;
	}

	public void setRegistros(List<RegistroDinero> registros) {
		this.registros = registros;
	}
}// end CajaPermiso