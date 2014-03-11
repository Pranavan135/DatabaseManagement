/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.validate;

import db.dao.BillDAO;

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
                    if (billDAO.isUnique(referenceNo))    {
                        return true;
                    }
                    else 
                        return false;
                }
                else 
                    return false;
            }
            catch(NumberFormatException ex) {
                return false;
            }
        }
        else
            return false;
    }
    
}
