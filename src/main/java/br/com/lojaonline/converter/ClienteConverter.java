package br.com.lojaonline.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.lojaonline.DAO.ClienteDAO;
import br.com.lojaonline.model.Cliente;

@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter {

	@Inject
	ClienteDAO clienteDAo;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			Long codigo = Long.parseLong(value);
			return clienteDAo.porID(codigo);

		} catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			if (value != null) {
				Cliente cliente = (Cliente) value;
				return cliente.getCodigo().toString();
			}
		} catch (RuntimeException ex) {
			return null;
		}
		return "";
	}

}
