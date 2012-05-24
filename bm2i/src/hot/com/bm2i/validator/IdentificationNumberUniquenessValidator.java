package com.bm2i.validator;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.intercept.BypassInterceptors;
import org.jboss.seam.core.Interpolator;

import com.bm2i.comun.model.Resident;

@Name("identificationNumberUniquenessValidator")
@BypassInterceptors
@org.jboss.seam.annotations.faces.Validator
public class IdentificationNumberUniquenessValidator implements
		javax.faces.validator.Validator, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		if (value != null) {
			String nid = value.toString().trim();
			verifyUniqueness(nid);
		}
	}
	
	private void verifyUniqueness(String nid) {
		EntityManager entityManager = (EntityManager) Component
				.getInstance("entityManager");
		//String JPAQL = "Select Contribuyente from Contribuyente Contribuyente "
		//		+ "where Contribuyente.identificationNumber like :nid";
		@SuppressWarnings("unchecked")
		java.util.List<Resident> result = (java.util.List<Resident>) entityManager
				.createNamedQuery("Resident.findByIdentificationNumber")
				.setParameter("identificationNumber", nid).getResultList();

		if (result != null && !result.isEmpty()) {
			message = Interpolator.instance().interpolate(
					"#{messages['common.alreadyExistIdentificationNumber']}",
					new Object[0]);
			throw new ValidatorException(new FacesMessage(message));
		}
	}

}
