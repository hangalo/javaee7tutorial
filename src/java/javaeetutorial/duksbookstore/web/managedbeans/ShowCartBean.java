/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.duksbookstore.web.managedbeans;

import java.io.Serializable;
import javaeetutorial.duksbookstore.entity.Book;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author desenvolvimento
 */
@Named("showcart")
@SessionScoped
public class ShowCartBean extends  AbstractBean implements Serializable{
    
    private boolean cartChanged = false;

    public ShowCartBean() {
    }

    public boolean isCartChanged() {
        return cartChanged;
    }

    public void setCartChanged(boolean cartChanged) {
        this.cartChanged = cartChanged;
    }
    
    protected ShoppingCartItem item(){
    ShoppingCartItem item = (ShoppingCartItem)context().getExternalContext().getRequestMap().get("item");
    
    return (item);
    }
    
    
    public String details(){
    context().getExternalContext().getSessionMap().put("selected", item().getItem());
    
    return ("bookdetails");
    
    
    }
    
    
   public String remove(){
   Book book = (Book)item().getItem();
   cart.remove(book.getBookId());
       setCartChanged(true);
       message(null, "ConfirmRemove", new Object[]{book.getTitle()});
       return (null);
   } 
    
    public String update(){
    String changed = (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("changed");
    if((changed!= null)&&changed.equals(true)){
        setCartChanged(true);
    
    }else{
        setCartChanged(false);
    }
    if(isCartChanged()){
        message(null, "QuantitiesUpdated");
    
    }else{
        message(null, "QuantitiesNotUpdated");
    
    }
    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("chaged", "false");
    return (null);
    }
}





















































