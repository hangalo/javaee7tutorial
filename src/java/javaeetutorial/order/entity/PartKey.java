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
public class PartKey implements Serializable{
    private String partNumber;
    private int revision;

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.partNumber);
        hash = 97 * hash + this.revision;
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
        final PartKey other = (PartKey) obj;
        if (!Objects.equals(this.partNumber, other.partNumber)) {
            return false;
        }
        if (this.revision != other.revision) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PartKey{" + "partNumber=" + partNumber + ", revision=" + revision + '}';
    }
    
    
    
}
