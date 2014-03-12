/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.validate;

import javax.swing.JOptionPane;
import db.dao.RouteDAO;
import javax.swing.JDialog;

/**
 *
 * @author userr
 */
public class RouteVallidate {
    
    public RouteDAO routeDAO = RouteDAO.create();
    
    private static RouteVallidate routeValidate = null;
    
    public static RouteVallidate createInstance(){
        if (routeValidate == null){
            routeValidate = new RouteVallidate();
             JDialog.setDefaultLookAndFeelDecorated(true);
        }
        return routeValidate;
    }
    
    public boolean IDValidation(String id){
        
        
        int length = id.length();
        try{
           int r_id =  Integer.parseInt(id);
           if ( length < 11 ){
               if (r_id > 0){
                   if (routeDAO.isUnique(id)){
                       return true;
                   }
                   else{
                       
                       JOptionPane.showMessageDialog(null, "Route ID must be unique", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }
               else{
               JOptionPane.showMessageDialog(null, "Route ID must be greater than zero", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
           }
           else{
               JOptionPane.showMessageDialog(null, "Route ID must be 5 charachters", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return false;
                }
        }
        catch(NumberFormatException nf){
            JOptionPane.showMessageDialog(null, "ID should only contain digits", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
        }
    }
    
    public boolean nameValidation(String name){
        
        return true;
    }
    
    public boolean daysValidation(String days){
        try{
           int r_days =  Integer.parseInt(days);
               if (r_days > 0){
                   return true;
                }
               else{
               JOptionPane.showMessageDialog(null, "Route days must be greater than zero", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
           }
        catch(NumberFormatException nf){
            JOptionPane.showMessageDialog(null, "Route days should only contain digits", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
        }
    }
    
    public boolean distanceValidation(String distance){
        try{
           int r_distance =  Integer.parseInt(distance);
               if (r_distance > 0){
                   return true;
                }
               else{
               JOptionPane.showMessageDialog(null, "Route Length must be greater than zero", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
           }
        catch(NumberFormatException nf){
            JOptionPane.showMessageDialog(null, "Route Length must only contain digits", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
        }
    }
    
}
