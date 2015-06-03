/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.duksbookstore.web.managedbeans;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author desenvolvimento
 */
@Named
@SessionScoped
public class AbstractBean implements Serializable {

    /**
     * Creates a new instance of AbstractBean
     */
    @Inject
    ShoppingCart cart;
    
    public AbstractBean() {
    }
    
    protected FacesContext context() {
        return (FacesContext.getCurrentInstance());
    }
    
    protected void message(String clientId, String key) {
        
        String text;
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("avaeetutorial.duksbookstore.web.messages.Messages", context().getViewRoot().getLocale());
            text = bundle.getString(key);
            
        } catch (Exception e) {
            
            text = "???" + key + "???";
            
        }
        context().addMessage(clientId, new FacesMessage(text));
    }
    
    protected void message(String clientId, String key, Object[] params) {
        
        String text;
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("avaeetutorial.duksbookstore.web.messages.Messages", context().getViewRoot().getLocale());
            text = bundle.getString(key);
        } catch (Exception e) {
            text = "???" + "???";
            
        }
        if ((params != null) && (params.length > 0)) {
            text = MessageFormat.format(text, params);
        }
        
        context().addMessage(clientId, new FacesMessage(text));
        
    }
    
}
