package db.entity;
// Generated Mar 12, 2014 5:01:43 PM by Hibernate Tools 3.6.0



/**
 * RouteTown generated by hbm2java
 */
public class RouteTown  implements java.io.Serializable {


     private RouteTownId id;
     private Route route;
     private Town town;
     private Integer routeId;
     private Integer townId;

  public RouteTown(int routeId, int townId) {
      this.routeId = routeId;
       this.townId = townId;
    }
	
  /*  public RouteTown(RouteTownId id) {
        this.routeId = id.getRouteId();
        this.townId = id.getTownId();
    }*/
    
    public RouteTown(RouteTownId id, Route route, Town town) {
       this.id = id;
       this.route = route;
       this.town = town;
    }
   
    public RouteTownId getId() {
        return this.id;
    }
    
    public void setId(RouteTownId id) {
        this.id = id;
    }
    public Route getRoute() {
        return this.route;
    }
    
    public void setRouteId(Integer id) {
        this.routeId = id;
    }
    public Integer getRouteId() {
        return this.routeId;
    }
    
    public void setTownId(Integer id) {
        this.townId = id;
    }
    public Integer getTownId() {
        return this.townId;
    }
    
    public void setRoute(Route route) {
        this.route = route;
    }
    public Town getTown() {
        return this.town;
    }
    
    public void setTown(Town town) {
        this.town = town;
    }




}


