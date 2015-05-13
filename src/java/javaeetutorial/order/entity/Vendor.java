/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.order.entity;

import java.io.Serializable;
import java.util.Collection;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author desenvolvimento
 */
@Entity

@Table(name="vendor")
@NamedQueries({
@NamedQuery(name = "findVendorByPartialName", query="SELECT v FROM Vendor v WHERE LOCATE(:name, v.name)>0"),
@NamedQuery(name="findVendorByCustomerOrder", query="SELECT DISTINCT l.vendorPart.vendor FROM CustomerOrder co, IN(co.lineItems) l WHERE co.orderId = :id ORDER By l.vendorPart.vendor.name")    

})
public class Vendor implements Serializable {

    private static final long serialVersionUID = 1L;

    private int vendroId;
    private String name;
    private String address;
    private String contact;
    private String phone;
    private Collection<VendorPart> vendorParts;

    public Vendor() {
    }

    public Vendor(int vendroId, String name, String address, String contact, String phone) {
        this.vendroId = vendroId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.phone = phone;
    }

    @Id
    public int getVendroId() {
        return vendroId;
    }

    public void setVendroId(int vendroId) {
        this.vendroId = vendroId;
    }

    @Column(name = "vendor_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @OneToMany(cascade = ALL, mappedBy = "vendor")
    public Collection<VendorPart> getVendorParts() {
        return vendorParts;
    }

    public void setVendorParts(Collection<VendorPart> vendorParts) {
        this.vendorParts = vendorParts;
    }

    public void addVendorPart(VendorPart vendorPart) {
        this.getVendorParts().add(vendorPart);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.vendroId;
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
        final Vendor other = (Vendor) obj;
        if (this.vendroId != other.vendroId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vendor{" + "vendroId=" + vendroId + ", name=" + name + ", phone=" + phone + '}';
    }

    
    
}
