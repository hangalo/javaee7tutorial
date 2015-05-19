/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.roster.entity;

import java.io.Serializable;
import javaeetutorial.roster.util.IncorrectSportException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author desenvolvimento
 */
@Entity
public class WinterLeague extends League implements Serializable {
    private static final long serialVersionUID = 1L;

    public WinterLeague() {
    }
    
    public WinterLeague(String id, String name, String sport) throws IncorrectSportException{
        this.id=id;
        this.name= name;
        
        if(sport.equalsIgnoreCase("hockey") || sport.equalsIgnoreCase("Skiing")|| sport.equalsIgnoreCase("snowboarding")){
        
        this.sport=sport;
        
        }else{
        throw new IncorrectSportException("Sport is not a winter sport");
        }
    }
    
    
    
    
    
}
