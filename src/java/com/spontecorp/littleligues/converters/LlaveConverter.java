package com.spontecorp.littleligues.converters;

import com.spontecorp.littleligues.jpacontroller.extentions.FaseJpaControllerExt;
import com.spontecorp.littleligues.jpacontroller.extentions.LlaveJpaControllerExt;
import com.spontecorp.littleligues.jsfcontroller.torneo.PartidoController;
import com.spontecorp.littleligues.model.torneo.Fase;
import com.spontecorp.littleligues.model.torneo.Llave;
import com.spontecorp.littleligues.utils.LittleLiguesUtils;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrés
 */
@FacesConverter("com.spontecorp.LlaveConverter")
public class LlaveConverter implements Converter {

    private LlaveJpaControllerExt jpaController = null;
    
    private FaseJpaControllerExt jpaFaseController = null;
    
    private LlaveJpaControllerExt getJpaController() {
        if (jpaController == null) {
            jpaController = new LlaveJpaControllerExt(LittleLiguesUtils.getEmf());
        }
        return jpaController;
    }
    
    private FaseJpaControllerExt jpaFaseController() {
        if (jpaFaseController == null) {
            jpaFaseController = new FaseJpaControllerExt(LittleLiguesUtils.getEmf());
        }
        return jpaFaseController;
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {

        //System.out.println("1.- Class: LlaveConverter - Methodo: getAsObject. Value: " + value);

        if (value == null || value.length() == 0) {
            //System.out.println("1.- Si value es null --> Value: " + value);
            return null;
        }

        //int faseId = 22; 
        //Fase fase = jpaFaseController().findFase(faseId);
        
        //return getJpaController().findLlave(value, fase);
        return getJpaController().findLlave(value);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Llave) {
            Llave o = (Llave) object;
            return o.toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Llave.class.getName());
        }
    }
}
