/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.roster.util;

import java.io.Serializable;

/**
 *
 * @author desenvolvimento
 */
public class PlayerDetails implements Serializable{
 private String id;
 private String name;
 private String position;
 private double salary;

    public PlayerDetails() {
    }

    public PlayerDetails(String id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PlayerDetails{" + "id=" + id + ", name=" + name + ", position=" + position + ", salary=" + salary + '}';
    }
 
 
}
