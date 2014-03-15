/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.validate;

import db.dao.HotelDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class HotelValidate {
    public HotelDAO hotelDAO = HotelDAO.create();
    private static HotelValidate hotelValidate = null;
    
     public static HotelValidate create()  {
        if (hotelValidate == null) {
              hotelValidate = new HotelValidate();
        }
            return hotelValidate;
    }
     
     public boolean validatID(String ID)   {
        if (ID.length() == 4)  {
            try {
                int intID = Integer.parseInt(ID);
                
                if (intID > 0)  {
                    if (hotelDAO.isUnique(ID) == null)    {
                        return true;
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Hotel Id already exits", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                        
                }
                else {
                    JOptionPane.showMessageDialog(null, "Hotel ID should be a postive 4 digit integer", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Hotel ID should only contain digits", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            } 
        }
         else    {
            JOptionPane.showMessageDialog(null, "Hotel ID should contain 4 digits", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
     }
     
     public boolean validateNotNull(String value)   {
         return !value.isEmpty();
             
     }
}
