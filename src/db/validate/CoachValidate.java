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
            JOptionPane.showMessageDialog(null, "Please enter reg No", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            regNo = Integer.parseInt(regno);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Reg No can contain only digits!!!!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (regno.length() != 10) {
            JOptionPane.showMessageDialog(null, "Please enter 10 digit Reg No", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (DriverDAO.isExistDriver(regNo)) {
            JOptionPane.showMessageDialog(null, "A driver with Reg No is already there", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public static boolean capacityValidate(String capcity){
        if (!capcity.equals("")) {
            if (isNumeric(capcity)) {
                if (capcity.length() == 10) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter  Phone Number with 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please enter  Phone Number with digits only", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a Phone Number", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean isNumeric(String tpNo) {

        Integer id = 0;

        try {
            id = Integer.parseInt(tpNo);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
    
}
