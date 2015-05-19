/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.roster.entity;

import java.io.Serializable;
import javaeetutorial.roster.util.IncorrectSportException;
import javax.persistence.Entity;

/**
 *
 * @author desenvolvimento
 */
@Entity
public class SummerLeague extends League implements Serializable {
    private static final long serialVersionUID = 1L;

    public SummerLeague() {
    }
  
    public SummerLeague(String id, String name, String sport) throws IncorrectSportException{
        this.id=id;
        this.name= name;
        
        if(sport.equalsIgnoreCase("swimming") || sport.equalsIgnoreCase("soccer")|| sport.equalsIgnoreCase("basketball") || sport.equalsIgnoreCase("baseball")){
        
        this.sport=sport;
        
        }else{
        throw new IncorrectSportException("Sport is not a summer sport");
        }
  
}
}