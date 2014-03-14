/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.validate;

import db.dao.DriverDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Pranavan
 */
public class DriverValidate {

    public static boolean idValidate(String id) {
        int iD;

        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter ID", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            iD = Integer.parseInt(id);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID can contain only digits!!!!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (id.length() != 10) {
            JOptionPane.showMessageDialog(null, "Please enter 10 digit ID", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (DriverDAO.isExistDriver(iD)) {
            JOptionPane.showMessageDialog(null, "A driver with ID is already there", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean nameValidate(String name) {
        if (!name.equals("")) {
            if (name.matches("[A-Z][a-zA-Z]*")) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter Name with alphabets", name, JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a Name", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean addressValidate(String address) {

        if (!address.equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a Address", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public static boolean tpNoValidate(String tpNo) {
        if(!tpNo.equals("")){
            if(isNumeric(tpNo)){
                
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter  Phone Number with digits only", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please enter a Phone Number", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    
    public static boolean isNumeric(String tpNo){
        
        Integer id = 0;
        
        try {
            id = Integer.parseInt(tpNo);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
}
