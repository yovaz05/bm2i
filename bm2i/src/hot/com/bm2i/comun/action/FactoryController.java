package com.bm2i.comun.action;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityController;

import com.bm2i.comun.model.Impuesto;
import com.bm2i.comun.model.TipoComprobante;
import com.bm2i.inventario.model.Linea;
import com.bm2i.inventario.model.TipoArticulo;

@Name("factories")
@Scope(ScopeType.CONVERSATION)
public class FactoryController extends EntityController {

	private static final long serialVersionUID = 1L;

	public static String SYSTEM_PARAMETER_SERVICE_NAME = "/gim/SystemParameterService/local";

	// private SystemParameterService systemParameterService;

	@SuppressWarnings("unchecked")
	@Factory("lineas")
	public List<Linea> findLineas() {
		Query query = this.getEntityManager().createNamedQuery("Linea.findAll");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Factory("tiposProducto")
	public List<TipoArticulo> findTiposArticulo() {
		return Arrays.asList(TipoArticulo.values());
	}

	@SuppressWarnings("unchecked")
	@Factory("impuestos")
	public List<Impuesto> findImpuesto() {
		Query query = this.getEntityManager().createNamedQuery(
				"Impuesto.findAll");
		return query.getResultList();
	}

	

}
