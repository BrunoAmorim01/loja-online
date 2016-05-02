package br.com.lojaonline.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.lojaonline.DAO.FuncionarioDAO;
import br.com.lojaonline.model.Funcionario;

@FacesConverter("funcionarioConverter")
public class FuncionarioConverter implements Converter {

	@Inject
	FuncionarioDAO dao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			Long codigo = Long.parseLong(value);
			return dao.porID(codigo);

		} catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		try {
			Funcionario funcionario = (Funcionario) value;
			Long codigo = funcionario.getCodigo();

			return codigo.toString();

		} catch (RuntimeException ex) {
			return null;
		}

	}

}
