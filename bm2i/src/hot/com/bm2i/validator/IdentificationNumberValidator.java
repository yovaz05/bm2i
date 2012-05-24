package com.bm2i.validator;

/**
 * @author wilman
 */

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.intercept.BypassInterceptors;
import org.jboss.seam.core.Interpolator;

import com.bm2i.comun.action.ResidentHome;
import com.bm2i.comun.model.TipoIdentificacion;

@Name("identificationNumberValidator")
@BypassInterceptors
@org.jboss.seam.annotations.faces.Validator
public class IdentificationNumberValidator implements
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
			ResidentHome contribuyenteHome = (ResidentHome) Component
					.getInstance("ResidentHome");
			// System.out.println("===> INGRESO A VALOR DIFERENTE DE NULL...... "
			// + nid + ", Type Identification: " +
			// ContribuyenteHome.getInstance().getTipoIdentificacion());
			if (contribuyenteHome.getInstance().getTipoIdentificacion() == TipoIdentificacion.CEDULA) {
				this.validateNationalIdentityDocument(nid);
			} else if (contribuyenteHome.getInstance().getTipoIdentificacion() == TipoIdentificacion.RUC) {
				this.validateTaxpayerDocument(nid);
			}

		} else {
			message = Interpolator.instance().interpolate(
					"#{messages['common.requiredIdentificationNumber']}",
					new Object[0]);
			throw new ValidatorException(new FacesMessage(message));
		}

	}
	
	private void verifyNationalIdentityDocument(String nid){
		String wced = nid.substring(0, 9);
		String verif = nid.substring(9, 10);
		double wd = 0;
		double wc = 0;
		double wa = 0;
		double wb = 0;

		for (int i = 0; i <= wced.length() - 1; i = i + 2) {
			wa = Double.parseDouble(wced.substring(i, i + 1));
			wb = wa * 2;
			wc = wb;
			if (wb > 9) {
				wc = wb - 9;
			}
			wd = wd + wc;
		}

		for (int i = 1; i <= wced.length() - 1; i = i + 2) {
			wa = Double.parseDouble(wced.substring(i, i + 1));
			wd = wd + wa;
		}
		double wn;
		wn = wd / 10;
		double wn2 = Math.ceil(wn);
		wn2 = wn2 * 10;
		double digit = wn2 - wd;

		if (digit != Double.parseDouble(verif)) {
			message = Interpolator.instance().interpolate(
					"#{messages['common.invalidIdentificationNumber']}",
					new Object[0]);
			throw new ValidatorException(new FacesMessage(message));
		}
	}

	private void validateNationalIdentityDocument(String nid) {
		message = Interpolator.instance().interpolate(
				"#{messages['common.lengthIdentificationNumber']}",
				new Object[0]);
		if (nid.length() < 10) {
			throw new ValidatorException(new FacesMessage(message));
		}
		String spatron = "[0-9]{10}";// \\d{10}
		if (!Pattern.matches(spatron, nid)) {
			message = Interpolator.instance().interpolate(
					"#{messages['common.wrongIdentificationNumber']}",
					new Object[0]);
			throw new ValidatorException(new FacesMessage(message));
		}
		this.verifyNationalIdentityDocument(nid);
		
	}
	
	private void verifyTaxPayerPrivate(String nid){
		
		int[] coeficientes = {4,3,2,7,6,5,4,3,2}; 
		int module = 11;
		
		String wced = nid.substring(0, 9);
		String verif = nid.substring(9, 10);
		
		int sum_coef = 0;
		int wa;
		
		for (int i=0; i < coeficientes.length; i++){
			wa = Integer.parseInt(wced.substring(i, i + 1));
			sum_coef = sum_coef + (wa*coeficientes[i]); 
		}
		
		int residue = sum_coef % module;
		
		int digit_verify = residue == 0 ? residue : module - residue;
				
		if (digit_verify != Integer.parseInt(verif)) {
			message = Interpolator.instance().interpolate(
					"#{messages['common.invalidIdentificationNumber']}",
					new Object[0]);
			throw new ValidatorException(new FacesMessage(message));
		}
		
		String _main = nid.substring(10, nid.length());
		
		if (!_main.matches("[0-9]{2}[0-9&&[^0]]")){
			message = Interpolator.instance().interpolate(
					"#{messages['common.invalidIdentificationNumberFinished']}",
					new Object[0]);
			throw new ValidatorException(new FacesMessage(message));
		}

	}
	
	
	private void verifyTaxPayerPublic(String nid){
		
		int[] coeficientes = {3,2,7,6,5,4,3,2 }; 
		int module = 11;
		
		String wced = nid.trim().substring(0, 8);
		String verif = nid.trim().substring(8, 9);
		
		int sum_coef = 0;
		int wa;
		
		for (int i=0; i < coeficientes.length; i++){
			wa = Integer.parseInt(wced.substring(i, i + 1));
			sum_coef = sum_coef + (wa*coeficientes[i]); 
		}
		
		int residue = sum_coef % module;
		
		int digit_verify = residue == 0 ? residue : module - residue;
				
		if (digit_verify != Integer.parseInt(verif)) {
			message = Interpolator.instance().interpolate(
					"#{messages['common.invalidIdentificationNumber']}",
					new Object[0]);
			throw new ValidatorException(new FacesMessage(message));
		}
		
		String _main = nid.substring(9, nid.length());
		
		if (!_main.matches("[0-9]{3}[0-9&&[^0]]")){
			message = Interpolator.instance().interpolate(
					"#{messages['common.invalidIdentificationNumberFinished']}",
					new Object[0]);
			throw new ValidatorException(new FacesMessage(message));
		}
	}

	private void validateTaxpayerDocument(String nid) {
		message = Interpolator.instance().interpolate(
				"#{messages['common.lengthIdentificationNumberLegalEntity']}",
				new Object[0]);
		if (nid.length() < 13) {
			throw new ValidatorException(new FacesMessage(message));
		}
		String spatron = "[0-9]{13}";// \\d{10}
		if (!Pattern.matches(spatron, nid)) {
			message = Interpolator.instance().interpolate(
					"#{messages['common.wrongIdentificationNumberLegalEntity']}",
					new Object[0]);
			throw new ValidatorException(new FacesMessage(message));
		}
		
		// TODO Chequeo de RUC
		/** 
		 * Extraer tercer digito para saber si es:
		 *  9 para sociedades privadas y extranjeros 
		 *  6 para sociedades publicas 
		 *  menor que 6 (0,1,2,3,4,5) para personas naturales
		 */
		nid = nid.trim();
		char typeRucChar = nid.charAt(2);
		int typeRuc = Integer.parseInt(typeRucChar+"");
		if (typeRuc < 6){
			this.verifyNationalIdentityDocument(nid);
			String _main = nid.substring(10, nid.length());
			
			if (!_main.matches("[0-9]{2}[0-9&&[^0]]")){
				message = Interpolator.instance().interpolate(
						"#{messages['common.invalidIdentificationNumberFinished']}",
						new Object[0]);
				throw new ValidatorException(new FacesMessage(message));
			}
		}else if (typeRuc == 6){
			verifyTaxPayerPublic(nid);
		}else if (typeRuc == 9){
			this.verifyTaxPayerPrivate(nid);
		}else{
			message = Interpolator.instance().interpolate(
					"#{messages['common.wrongTypeIdentificationNumberLegalEntity']}",
					new Object[0]);
			throw new ValidatorException(new FacesMessage(message));
		}
		
		String _main = nid.substring(9, nid.length());
		
		if (!_main.matches("[0-9]{3}[1-9]")){
			message = Interpolator.instance().interpolate(
					"#{messages['common.invalidIdentificationNumberFinished']}",
					new Object[0]);
			throw new ValidatorException(new FacesMessage(message));
		}

	}


}
