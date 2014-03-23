/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.validate;

import db.dao.CoachDAO;
import db.dao.DriverDAO;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Pranavan
 */
public class CoachValidate {

    public static boolean regNoValidate(String regno) {
        int regNo;

        if (regno.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter reg No", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            regNo = Integer.parseInt(regno);
            if (!(regNo > 0)) {
                JOptionPane.showMessageDialog(null, "Registration Number cannot be negative", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Reg No can contain only digits!!!!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (regno.length() != 4) {
            JOptionPane.showMessageDialog(null, "Please enter 4 digit Reg No", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (CoachDAO.isExistCoach(regNo)) {
            JOptionPane.showMessageDialog(null, "A Coach with Reg No is already there", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean capacityValidate(String capcity) {
        if (!capcity.equals("")) {
            if (isNumeric(capcity)) {
                Integer capa = Integer.parseInt(capcity);
                if (capa > 0) {
                    return true;
                } else {
                         JOptionPane.showMessageDialog(null, "Please enter  capacity that is positive Number", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please enter  capacity that is Numeric", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter Capcity", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean isNumeric(String numericString) {

        Integer NumericString = 0;

        try {
            NumericString = Integer.parseInt(numericString);
            return true;
        } catch (NumberFormatException numberFormatException) {
            //JOptionPane.showMessageDialog(null,"Capcity is an integer!!!", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean dateValidate(Date date) {
        if (date == null) {
            JOptionPane.showMessageDialog(null, "Please Enter Date", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean mileageValidate(String mileage) {
        try {
            Double mileag = Double.parseDouble(mileage);
            if (mileag > 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "The mileage must be positive!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "The mileage must be a decimal !!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
