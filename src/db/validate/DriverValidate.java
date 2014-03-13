/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.validate;

import javax.swing.JOptionPane;

/**
 *
 * @author Pranavan
 */
public class DriverValidate {
    
    public static boolean idValidate(String id){
       int iD;
       
       if(id.equals("")){
           JOptionPane.showMessageDialog(null,"Please enter ID","Error", JOptionPane.ERROR_MESSAGE);
           return false;
       }
       try{
           iD = Integer.parseInt(id);
           
       } catch(NumberFormatException ex){
           JOptionPane.showMessageDialog(null, "ID can contain only digits!!!!","Error",JOptionPane.ERROR_MESSAGE);
           return false;
       }
       
       return true;
    }
    
    
    public static boolean nameValidate(String name){
        return true;
    }
}
