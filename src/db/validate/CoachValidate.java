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
public class CoachValidate {
    
    
    public static boolean regNoValidate(String regno){
        int regNo;

        if (regno.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter ID", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            regNo = Integer.parseInt(regno);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID can contain only digits!!!!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (regno.length() != 10) {
            JOptionPane.showMessageDialog(null, "Please enter 10 digit ID", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (DriverDAO.isExistDriver(regNo)) {
            JOptionPane.showMessageDialog(null, "A driver with ID is already there", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    
    
}
