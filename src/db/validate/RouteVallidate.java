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
         if (id.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter the route ID", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
         }
        else{
            try{
            int r_id =  Integer.parseInt(id);
             if ( length > 11 || length !=5 ){
                 JOptionPane.showMessageDialog(null, "Route ID must be 5 charachters", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return false;
             }
             else if (r_id < 0){
                  JOptionPane.showMessageDialog(null, "Route ID must be greater than zero", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return false;
               }
             else 
                 return true;             
            }
            catch(NumberFormatException nf){
                JOptionPane.showMessageDialog(null, "ID should only contain digits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return false;
        }
    
        }
    }      
         

    
    public boolean isUnique(String id){
         if (routeDAO.isUnique(id)){
                       return true;
                   }
                   else{
                       
                       JOptionPane.showMessageDialog(null, "Route ID must be unique", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
    }
    public boolean isExit(String id){
         if (routeDAO.isExist(id)){
                       return true;
                   }
                   else{
                       
                       JOptionPane.showMessageDialog(null, "Route ID is not exist!!Please enter the correct id.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
    }
    
    
    public boolean nameValidation(String name){
        
        if (name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Enter the Name", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if (!isAlphabet(name)){
            JOptionPane.showMessageDialog(null, "Name should contain only alphabets and underscore", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else
            return true;

    }
    
    public boolean isAlphabet(String name){
        if(name.isEmpty()){
            return false;
        } else {
            for(int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);
                if(!(Character.isLetter(c) || c == 0x2e || c == 0x20)){
                    return false;
                } 
            }
        }
        return true;
    } 
    
    public boolean daysValidation(String days){
        try{
           int r_days =  Integer.parseInt(days);
           if (r_days == 0){
               JOptionPane.showMessageDialog(null, "Please enter the route days", "ERROR", JOptionPane.ERROR_MESSAGE);
               return false;
           }
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
        if (distance.isEmpty()){
               JOptionPane.showMessageDialog(null, "Please enter the route distance", "ERROR", JOptionPane.ERROR_MESSAGE);
               return false;
            }
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
        catch(NumberFormatException nfe ){
            JOptionPane.showMessageDialog(null, "Route Length must only contain digits", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
        }
    }
    
}
