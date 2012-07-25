package com.bm2i.venta.action;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.inventario.action.ArticuloHome;
import com.bm2i.inventario.action.PrecioHome;
import com.bm2i.inventario.model.Articulo;
import com.bm2i.inventario.model.Precio;
import com.bm2i.security.Usuario;
import com.bm2i.security.action.UserSession;
import com.bm2i.security.action.UsuarioHome;
import com.bm2i.venta.model.RegistroVenta;

@Name("registroVentaHome")
public class RegistroVentaHome extends EntityHome<RegistroVenta> {

	@In(create = true)
	ArticuloHome articuloHome;
	@In(create = true)
	PrecioHome precioHome;
	@In(create = true)
	UsuarioHome usuarioHome;

	private BigDecimal total = new BigDecimal(0);

	private Articulo art = new Articulo();
	// private List<RegistroVenta> registroVentas = new
	// ArrayList<RegistroVenta>();
	private Date fechaVenta = new Date();
	private Precio precio;

	public void setRegistroVentaId(Long id) {
		setId(id);
	}

	public Long getRegistroVentaId() {
		return (Long) getId();
	}

	@Override
	protected RegistroVenta createInstance() {
		RegistroVenta registroVenta = new RegistroVenta();
		return registroVenta;
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
		Precio precio = precioHome.getDefinedInstance();
		if (precio != null) {
			getInstance().setPrecio(precio);
		}
		Usuario user = usuarioHome.getDefinedInstance();
		if (user != null) {
			getInstance().setUser(user);
		}
	}

	public boolean isWired() {
		return true;
	}

	public RegistroVenta getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	/*
	 * public Articulo getArticulo() { return articulo; }
	 * 
	 * public void setArticulo(Articulo articulo) { this.articulo = articulo; }
	 */

	/*
	 * public List<RegistroVenta> getRegistroVentas() { return registroVentas; }
	 * 
	 * public void setRegistroVentas(List<RegistroVenta> registroVentas) {
	 * this.registroVentas = registroVentas; }
	 */

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Precio getPrecio() {
		return precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}

	public List<Articulo> autoComplete(Object o) {
		Query query = this.getEntityManager().createNamedQuery(
				"Articulo.findByCodigoNombre");
		query.setParameter("criteria", o.toString());
		return (List<Articulo>) query.getResultList();
	}

	public void selectArticulo(Articulo art) {
		System.out.println("entra a signar el articulo");
		if (art != null) {
			if (art.getId() != null) {
				System.out.println("asigna------>>>>>>> articulo");
				this.art = art;
				this.getInstance().setArticulo(art);
				this.getInstance().setPrecio(art.getCurrentPrecio());
				if (art.getCurrentPrecio() != null) {
					this.getInstance().setSubTotal(
							art.getCurrentPrecio().getPvp());
				}

				/*
				 * Query q = this.getEntityManager().createNamedQuery(
				 * "Precio.findByArticulo"); q.setParameter("articulo", art); if
				 * (q.getResultList().size() > 0) { Precio p = (Precio)
				 * q.getResultList().get(0); System.out.println("el precio " +
				 * p.getId()); this.getInstance().setPrecio(p);
				 * this.getInstance().setSubTotal(p.getPvp()); }
				 */
			}
		}
	}

	public void realizarCalculo() {
		System.out.println("entra a realizar el calculo");
		if (this.getInstance().getPrecio() != null) {
			if (this.getInstance().getPrecio().getId() != null) {
				double pvp = this.getInstance().getPrecio().getPvp()
						.doubleValue();
				int cantidad = this.getInstance().getCantidad();
				double pvpTotal = pvp * cantidad;
				BigDecimal totalbd = new BigDecimal(pvpTotal);
				totalbd = totalbd.setScale(2, RoundingMode.HALF_UP);
				this.getInstance().setTotal(null);
				this.getInstance().setTotal(totalbd);
			}
		}

	}

	public void guardar() {
		this.getInstance().setFecha(this.fechaVenta);
		System.out.println("la fecha " + this.getInstance().getFecha());
		UserSession userSession = (UserSession) getSessionContext().get(
				"userSession");
		if (userSession.getUsuario() != null) {
			this.getInstance().setUser(userSession.getUsuario());
			if (this.getInstance().getPrecio() != null) {
				if (this.getInstance().getPrecio().getId() != null) {
					super.persist();
					nuevo();
				}
			}
		}
	}

	public void nuevo() {
		this.setInstance(new RegistroVenta());
		wire();
		this.art = new Articulo();
	}

	public void borrar(RegistroVenta rv) {
		if (rv != null) {
			this.setInstance(rv);
			super.remove();
			nuevo();
			// rv = null;
		}
	}

	public Articulo getArt() {
		return art;
	}

	public void setArt(Articulo art) {
		this.art = art;
	}

	public List<RegistroVenta> getRegistroVentas() {
		// /////////////////////////////////////////
		Query query1 = this.getEntityManager().createNamedQuery(
				"RegistroVenta.addByFecha");
		query1.setParameter("fecha", this.getInstance().getFecha());
		if (query1.getResultList().size() > 0) {
			if (query1.getSingleResult() != null) {
				this.total = new BigDecimal(query1.getSingleResult().toString());
				this.total = this.total.setScale(2, RoundingMode.HALF_UP);
			}
		}
		// ///////////
		Query q = this.getEntityManager().createNamedQuery(
				"RegistroVenta.findByFecha");
		q.setParameter("fecha", this.getInstance().getFecha());
		return q.getResultList();
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
