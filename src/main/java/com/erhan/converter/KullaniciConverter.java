package com.erhan.converter;

import com.erhan.model.Kullanici;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Kullanici.class)
public class KullaniciConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Kullanici) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Kullanici) {
            Kullanici entity = (Kullanici) value;
            if (entity instanceof Kullanici && entity.getKullaniciid()!= null) {
                uiComponent.getAttributes().put(entity.getKullaniciid().toString(), entity);
                return entity.getKullaniciid().toString();
            }
        }
        return "";
    }
}