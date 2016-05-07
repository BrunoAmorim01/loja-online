package br.com.lojaonline.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.lojaonline.DAO.EnderecoDAO;
import br.com.lojaonline.model.Endereco;

@FacesConverter("enderecoConverter")
public class EnderecoConverter implements Converter {

	@Inject
	EnderecoDAO enderecoDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {		

		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		try {
			if (value != null) {
				Endereco endereco = (Endereco) value;
				return endereco.getCodigo().toString();
			}
		} catch (RuntimeException ex) {			
			return null;
		}
		return "";

	}
}
