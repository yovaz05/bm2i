package com.bm2i.inventario.action;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.wicket.util.time.ITimeFrameSource;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.bm2i.inventario.model.Articulo;
import com.bm2i.inventario.model.Ganancia;
import com.bm2i.inventario.model.Generico;
import com.bm2i.inventario.model.Linea;
import com.bm2i.inventario.model.Precio;

@Name("articuloHome")
public class ArticuloHome extends EntityHome<Articulo> {

	@In(create = true)
	LineaHome lineaHome;

	@In(create = true)
	PrecioHome precioHome;

	public void setArticuloId(Long id) {
		setId(id);
	}

	public Long getArticuloId() {
		return (Long) getId();
	}

	@Override
	protected Articulo createInstance() {
		Articulo articulo = new Articulo();
		return articulo;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Linea linea = lineaHome.getDefinedInstance();
		if (linea != null) {
			getInstance().setLinea(linea);
		}
		Precio precio = precioHome.getDefinedInstance();
		if (precio != null) {
			getInstance().setCurrentPrecio(precio);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Articulo getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Generico> getGenericos() {
		return getInstance() == null ? null : new ArrayList<Generico>(
				getInstance().getGenericos());
	}

	public List<Precio> getPrecios() {
		return getInstance() == null ? null : new ArrayList<Precio>(
				getInstance().getPrecios());
	}

	@SuppressWarnings("unchecked")
	public void generarListaPVP() {
		System.out.println("======>>>>> entra a generar");
		Query q = this.getEntityManager().createNamedQuery("Ganancia.findAll");
		List<Ganancia> ganancias = q.getResultList();
		List<Precio> preciosLocal = new ArrayList<Precio>();
		for (Ganancia g : ganancias) {
			System.out.println("======>>>>> valores " + g.getNombre());
			Precio p = new Precio();
			p.setArticulo(this.getInstance());
			p.setCosto(this.getInstance().getCurrentCosto());
			p.setFecha(new Date());
			p.setGanancia(g);
			p.setIsActive(true);
			p.realizarCalculo();
			preciosLocal.add(p);
		}
		this.getInstance().setPrecios(preciosLocal);
	}

	public void recalcularPVP() {
		for (Precio p : this.getInstance().getPrecios()) {
			p.setCosto(this.getInstance().getCurrentCosto());
			p.realizarCalculo();
		}
	}

	public void calcularUtilidad() {
		Precio precio = this.getInstance().getCurrentPrecio();
		double costo = precio.getCosto().doubleValue();
		double total = precio.getPvp().doubleValue();
		double utilidadValor = total - costo;
		double utilidadPorce = (utilidadValor * 100) / total;

		BigDecimal utilidad = new BigDecimal(utilidadPorce);
		utilidad = utilidad.setScale(2, RoundingMode.HALF_UP);
		precio.setUtilidad(utilidad);
		this.getInstance().getCurrentPrecio().setUtilidad(utilidad);
		this.getInstance().getCurrentPrecio().setPvp(new BigDecimal(total));
	}

	public void calcularPVP() {
		Precio precio = this.getInstance().getCurrentPrecio();
		double costo = precio.getCosto().doubleValue();
		double utilidad = precio.getUtilidad().doubleValue();
		double total = costo + (costo * utilidad / 100);
		
		BigDecimal pvp = new BigDecimal(total);
		pvp = pvp.setScale(2, RoundingMode.HALF_UP);
		precio.setPvp(pvp);
		this.getInstance().getCurrentPrecio()
				.setUtilidad(new BigDecimal(utilidad));
		this.getInstance().getCurrentPrecio().setPvp(pvp);
	}

	public void addPrecio() {
		Precio precio = new Precio();
		precio.setFecha(new Date());
		// precio.setUtilidad(this.getInstance().getCurrentCosto());
		precio.setArticulo(this.getInstance());
		precio.setCosto(this.getInstance().getCurrentCosto());
		// this.getInstance().add(precio);
		this.getInstance().setCurrentPrecio(precio);
		// disableAddressControls = false;
	}

	@Override
	public String persist() {
		// TODO Auto-generated method stub
		//if (this.getInstance().getCurrentPrecio().getCosto() != null) {
			//this.getInstance().add(this.getInstance().getCurrentPrecio());
		//}
		return super.persist();
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		if (this.getInstance().getCurrentPrecio().getCosto() != null) {
			this.getInstance().add(this.getInstance().getCurrentPrecio());
		}
		return super.update();
	}

}
