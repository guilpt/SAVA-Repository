package com.vitaanimale.sava.infra.converter;

import com.vitaanimale.sava.to.Especies;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Elisa
 */
@FacesConverter(forClass = Especies.class)
public class EspeciesConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.isEmpty()) {
            return (Especies) component.getAttributes().get(value);
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Especies) {
            Especies especie= (Especies) value;
            if (especie != null && especie instanceof Especies && especie.getIdEspecie() != null) {
                component.getAttributes().put( especie.getIdEspecie().toString(), especie);
                return especie.getIdEspecie().toString();
            }
        }
        
        return "";
    }
    
}
