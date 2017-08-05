package com.beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;

import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {
    
    private String localidad;
    private static Map<String, Object> lstPaises;

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public  Map<String, Object> getLstPaises() {
        return lstPaises;
    }

    public static void setLstPaises(Map<String, Object> lstPaises) {
        UsuarioBean.lstPaises = lstPaises;
    }
    
    static {
        lstPaises = new LinkedHashMap<String, Object>();
        
        lstPaises.put("English", Locale.ENGLISH);
        lstPaises.put("Frances", Locale.FRENCH);
        
        Locale espanol = new Locale("ES");
        lstPaises.put("Español", espanol);
    }
    
    
    
    public void localidadChanged(ValueChangeEvent e) {
        String newLocaleValue = e.getNewValue().toString();
        
        for (Map.Entry<String, Object> entry : lstPaises.entrySet()) {
           
            System.out.println(":::: Value " + entry.getValue().toString());
            System.out.println(":::: Key" + entry.getKey().toString());
            
            if(entry.getValue().toString().equals(newLocaleValue)){
              
                System.out.println(" ======= " + entry.getValue().toString());
                System.out.println(" ::::::: " + newLocaleValue);
                FacesContext.getCurrentInstance().getViewRoot()
                        .setLocale((Locale) entry.getValue());
            }
        }
    }
    
    
    
    
    
    
    
    
}
