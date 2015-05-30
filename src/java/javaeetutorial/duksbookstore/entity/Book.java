/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.duksbookstore.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author desenvolvimento
 */
@Entity
@Table(name = "book")
@NamedQuery(name = "findBooks", query = "SELECT b FROM Book b ORDER BY b.bookId")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private String bookId;
    private String surname;
    private String firstname;
    private String title;
    private Double price;
    private Boolean onsale;
    private Integer calendarYear;
    private String description;
    private Integer inventory;

    public Book() {
    }

    public Book(String bookId, String surname, String firstname, String title, Double price, Boolean onsale, Integer calendarYear, String description, Integer inventory) {
        this.bookId = bookId;
        this.surname = surname;
        this.firstname = firstname;
        this.title = title;
        this.price = price;
        this.onsale = onsale;
        this.calendarYear = calendarYear;
        this.description = description;
        this.inventory = inventory;
    }
    
    public Book(String bookId){
    this.bookId=bookId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getOnsale() {
        return onsale;
    }

    public void setOnsale(Boolean onsale) {
        this.onsale = onsale;
    }

    public Integer getCalendarYear() {
        return calendarYear;
    }

    public void setCalendarYear(Integer calendarYear) {
        this.calendarYear = calendarYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.bookId);
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
        final Book other = (Book) obj;
        if (!Objects.equals(this.bookId, other.bookId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", title=" + title + '}';
    }
    
  
}































































