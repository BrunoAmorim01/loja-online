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
		Endereco endereco = null;

		if (value != null && !value.isEmpty()) {
			endereco = enderecoDAO.porID(new Long(value));
		}

		return endereco;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			return ((Endereco) value).getCodigo().toString();
		}

		return "";
	}
}
