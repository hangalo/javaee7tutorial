/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.order.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author desenvolvimento
 */
public class LineItemKey implements Serializable{
    private Integer customerOrder;
    private int itemId;

    public LineItemKey() {
    }

    public Integer getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(Integer customerOrder) {
        this.customerOrder = customerOrder;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.customerOrder);
        hash = 71 * hash + this.itemId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LineItemKey other = (LineItemKey) obj;
        if (!Objects.equals(this.customerOrder, other.customerOrder)) {
            return false;
        }
        if (this.itemId != other.itemId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LineItemKey{" + "customerOrder=" + customerOrder + ", itemId=" + itemId + '}';
    }
    
    
    
    
}
