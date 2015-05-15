/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.order.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author desenvolvimento
 */
@Entity
@Table(name = "vendor_part", uniqueConstraints = @UniqueConstraint(columnNames = {"part_number","part_revision"}))

@NamedQueries({@NamedQuery(name = "findAveregeVendorPartPrive",  query = "SELECT AVG(vp.price) FROM VendorPart vp"),
@NamedQuery(name = "findTotalVendorPartPricePerVendor", query = "SELECT SUM(vp.price) FROM VendorPart vp WHERE vp.vendor.vendroId=:id"),
@NamedQuery(name = "findAllVendorParts", query = "SELECT vp FROM VendorPart vp ORDER BY vp.vendorPartNumber")

})
public class VendorPart implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long vendorPartNumber;
    private String description;
    private double price;
    private Part part;
    private Vendor vendor;

    public VendorPart() {
    }

    public VendorPart(String description, double price, Part part) {
       
        this.description = description;
        this.price = price;
        this.part = part;
       part.setVendorPart(this);
    }
   
    @TableGenerator(
    name = "vendorPartGen", table = "sequence_generator", pkColumnName = "gen_key",
            valueColumnName = "gen_value", pkColumnValue = "vendor_part_id", allocationSize = 10)
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator ="vendorPartGen")
    public Long getVendorPartNumber() {
        return vendorPartNumber;
    }

    public void setVendorPartNumber(Long vendorPartNumber) {
        this.vendorPartNumber = vendorPartNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
@OneToOne
@JoinColumns({
@JoinColumn(name = "part_number",referencedColumnName = "part_number"),
@JoinColumn(name = "part_revision", referencedColumnName = "revision")
})
    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    @JoinColumn(name = "vendor_id")
    @ManyToOne
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

}
