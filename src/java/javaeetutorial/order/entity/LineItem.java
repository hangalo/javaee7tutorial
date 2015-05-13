/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.order.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author desenvolvimento
 */
@IdClass(LineItemKey.class)
@Entity
@Table(name = "line_item")

@NamedQueries({
@NamedQuery(name = "findAllLineItems", query="SELECT l FROM LineItem l"),
@NamedQuery(name = "findLineItemByOrderId", query="SELECT l FROM LineItem l WHERE l.customerOrder.orderId =:orderId ORDER BY l.itemId"),
@NamedQuery(name = "findLineItemById", query="SELECT DISTINCT l FROM LineItem l WHERE l.itemId =:itemId AND l.customerOrder.orderId=:orderId")


})
public class LineItem implements Serializable {

    private static final long serialVersionUID = 1L;
    private int itemId;
    private int quantity;
    private VendorPart vendorPart;
    private CustomerOrder customerOrder;

    public LineItem() {
    }

    public LineItem(int quantity, VendorPart vendorPart, CustomerOrder customerOrder) {
        this.itemId = customerOrder.getNextId();
        this.quantity = quantity;
        this.vendorPart = vendorPart;
        this.customerOrder = customerOrder;
    }

    @Id
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @JoinColumn(name = "vendor_part_numner")
    @ManyToOne
    public VendorPart getVendorPart() {
        return vendorPart;
    }

    public void setVendorPart(VendorPart vendorPart) {
        this.vendorPart = vendorPart;
    }
@Id
@ManyToOne
@JoinColumn(name = "order_id")
    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

}
