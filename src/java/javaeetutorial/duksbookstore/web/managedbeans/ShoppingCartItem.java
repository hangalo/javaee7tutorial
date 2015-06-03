/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.duksbookstore.web.managedbeans;

import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author desenvolvimento
 */
@Named
@SessionScoped
public class ShoppingCartItem implements Serializable{
    
    Object item;
    int quantity;

    /**
     * Creates a new instance of ShopptingCartItem
     */
    public ShoppingCartItem() {
    }

    public ShoppingCartItem(Object item) {
        this.item = item;
        this.quantity = 1;
    }
    
    public void incrementQuantity(){
    quantity++;
    }
    
    
    public void decrementQuantity(){
    quantity--;
    
    }
    
    
    public Object getItem(){
    return item;
    }
    
    
    public int getQuantity(){
    
     return quantity;
    }
    
    
    public void setQuantity(int quantity){
    
    this.quantity=quantity;
    }
}







