package db.entity;
// Generated Mar 10, 2014 2:54:58 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Hotel generated by hbm2java
 */
public class Hotel  implements java.io.Serializable {


     private int id;
     private Town town;
     private String name;
     private Set bills = new HashSet(0);

    public Hotel() {
    }

	
    public Hotel(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Hotel(int id, Town town, String name, Set bills) {
       this.id = id;
       this.town = town;
       this.name = name;
       this.bills = bills;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Town getTown() {
        return this.town;
    }
    
    public void setTown(Town town) {
        this.town = town;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set getBills() {
        return this.bills;
    }
    
    public void setBills(Set bills) {
        this.bills = bills;
    }




}

