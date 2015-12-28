package at.irian.jsf.model;

import at.irian.jsf.domain.CreditCardType;

import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

public class CreditCardConverterConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String string) throws ConverterException {
        return string != null ? string : null;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) throws ConverterException {
        if (object instanceof String)
            return (String) object;
        return object != null ? ((CreditCardType) object).getValue() : null;
    }
}
