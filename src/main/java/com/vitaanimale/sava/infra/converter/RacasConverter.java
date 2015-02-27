package com.vitaanimale.sava.infra.converter;
import com.vitaanimale.sava.to.Racas;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Elisa
 */
@FacesConverter(forClass = Racas.class)
public class RacasConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.isEmpty()) {
            return (Racas) component.getAttributes().get(value);
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Racas) {
            Racas raca= (Racas) value;
            if (raca != null && raca instanceof Racas && raca.getIdRaca()!= null) {
                component.getAttributes().put( raca.getIdRaca().toString(), raca);
                return raca.getIdRaca().toString();
            }
        }
        
        return "";
    }
    
}
