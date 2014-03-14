/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.validate;

import db.dao.BillDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author 110592A
 */
public class BillValidate {
    public BillDAO billDAO = BillDAO.create();
    
    private static BillValidate billValidate = null;
    
     public static BillValidate create()  {
        if (billValidate == null) {
              billValidate = new BillValidate();
        }
            return billValidate;
    }
     
    public boolean validatReferenceNo(String referenceNo)   {
        if (referenceNo.length() == 4)  {
            try {
                int reference = Integer.parseInt(referenceNo);
                
                if (reference > 0)  {
                    if (billDAO.isUnique(referenceNo) == null)    {
                        return true;
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Reference Number already exits", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                        
                }
                else {
                    JOptionPane.showMessageDialog(null, "Reference should be a postive 4 digit integer", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Reference number should only contain digits", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        else    {
            JOptionPane.showMessageDialog(null, "Reference number should contain 4 digits", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
        
    /*public boolean validateDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date d = sdf.parse(date);
            if (d.after(new Date()))    {
                JOptionPane.showMessageDialog(null, "Please E", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            return true;
        }
        catch(ParseException ex) {
            JOptionPane.showMessageDialog(null, "Please Enter a valid date in dd-MM-yyyy format", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }   
    }*/
    
     public boolean validateIndividuals(String numberOfIndividuals) {
          try {
                int number = Integer.parseInt(numberOfIndividuals);
            
                if (number > 0) {
                    return true;
                }
                else {
                     JOptionPane.showMessageDialog(null, "Number of individuals should be greater than zero", "ERROR", JOptionPane.ERROR_MESSAGE);
                     return false;
                }
          }
          catch(NumberFormatException ex) {
               JOptionPane.showMessageDialog(null, "Please Enter the valid amount of individuals", "ERROR", JOptionPane.ERROR_MESSAGE);
               return false;
          }   
     }
     
     public boolean validateAmount(String amount) {
          try {
                double bills = Double.parseDouble(amount);
            
                if (bills > 0) {
                    return true;
                }
                else {
                     JOptionPane.showMessageDialog(null, "Bill amount must be greater than zero", "ERROR", JOptionPane.ERROR_MESSAGE);
                     return false;
                }
          }
          catch(NumberFormatException ex) {
               JOptionPane.showMessageDialog(null, "Please Enter a valid bill amount", "ERROR", JOptionPane.ERROR_MESSAGE);
               return false;
          }
         
     }
     
     public boolean validateNotNull(String value)   {
         return !value.isEmpty();
             
     }
     
    /*  public boolean validateTown(String townId)   {
         if(billDAO.getTown(townId) != null)
             return true;
         else   {
               JOptionPane.showMessageDialog(null, "Town ID is not valid", "ERROR", JOptionPane.ERROR_MESSAGE);
               return false;
         }
             
     }
       public boolean validateHotel(String hotelId)   {
         if(billDAO.getHotel(hotelId) != null)
             return true;
         else   {
               JOptionPane.showMessageDialog(null, "Hotel ID is not valid", "ERROR", JOptionPane.ERROR_MESSAGE);
               return false;
         }
             
     }*/
}
