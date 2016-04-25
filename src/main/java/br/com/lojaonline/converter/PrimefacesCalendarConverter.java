package br.com.lojaonline.converter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter("primefacesCalendarConverter")
public class PrimefacesCalendarConverter extends DateTimeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {		
		LocalDate ldate = null;
		Date date = null;
		Object o = super.getAsObject(facesContext, uiComponent, value);
		
		if (o == null) {
			return null;
		}
		if (o instanceof Date) {
			date = (Date) o;		
			ldate=date.toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDate().plusDays(1);			
			return ldate;
		} else {
			throw new IllegalArgumentException(String
					.format("value=%s could not be converted to a LocalDate, result super.getAsObject=%s", value, o));
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		
		if (value == null) {
			return super.getAsString(facesContext, uiComponent, value);
		}
		if (value instanceof LocalDate) {
			LocalDate lDate = (LocalDate) value;			
			Instant instant = lDate.atStartOfDay().atZone(ZoneId.of("America/Sao_Paulo")).toInstant();
			Date date = Date.from(instant);			
			return super.getAsString(facesContext, uiComponent, date);
		} else {
			throw new IllegalArgumentException(String.format("value=%s is not a instanceof LocalDate", value));
		}

	}

}
