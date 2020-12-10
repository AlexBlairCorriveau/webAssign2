/**
 * Class name: ColorConverter.java
 * Description: ColorConverter will convert user entered strings to Color object and vice-versa
 * 
 * @author alexb
 * @version 1
 * @since 2020/11/20
 */
package service;

import java.awt.Color;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;


@FacesConverter("ColorConverterObject")
public class ColorConverter implements Converter {
    
    // This will convert the user entered string value into a color object.
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return Color.decode("#" + value);
    }
    
    // This will convert the related color object into a string value.
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Color color = (Color) value;
        return Integer.toHexString(color.getRGB()).substring(2);
    }
}