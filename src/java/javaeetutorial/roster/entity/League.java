/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.roster.entity;

import java.io.Serializable;
import java.util.Collection;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author desenvolvimento
 */
@Entity
@Table(name = "league")
public abstract class League implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String id;
    protected String name;
    protected String sport;
    protected Collection<Team> teams;
@Id
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

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
@OneToMany(cascade=ALL, mappedBy="league")
    public Collection<Team> getTeams() {
        return teams;
    }

    public void setTeams(Collection<Team> teams) {
        this.teams = teams;
    }
    
    
    
    public void addTeam(Team team){
    
    this.getTeams().add(team);
    }
    
    public void dropTeam(Team team){
    
    this.getTeams().remove(team);
   }
    
  
}














