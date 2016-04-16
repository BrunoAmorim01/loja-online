package br.com.lojaonline.converter;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("apenasNumeros")
public class ApenasNumeroConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if (value != null) {
			/*System.out.println("object");
			System.out.println("object  value "+value );
			String resultado=value.replaceAll("[^0-9]", "");
			System.out.println("object  value depois "+resultado );*/
			return value.replaceAll("[^0-9]", "");
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		/*System.out.println("string");
		System.out.println("string value "+ value.toString());*/
		return value.toString();
	}

	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}
}
