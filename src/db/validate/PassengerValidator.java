/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.validate;

import db.dao.PassengerDAO;

/**
 *
 * @author Vishnuvathsasarma
 */
public class PassengerValidator {
    private final int idLength = 6;
    private final int minNameLength = 3;
    private final int maxNameLength = 45;
    private final int tourCodeLength = 6;
    private PassengerDAO passengerDAO = new PassengerDAO();

    public int getIdLength() {
        return idLength;
    }

    public int getMinNameLength() {
        return minNameLength;
    }

    public int getMaxNameLength() {
        return maxNameLength;
    }

    public int getTourCodeLength() {
        return tourCodeLength;
    }
    
    public boolean isValidID(int ID) {
        return String.valueOf(ID).length()==idLength;
    }
    
    public boolean isDuplicateID(int ID){
        return (passengerDAO.getPassenger(ID)== null);
    }
    
    public boolean isValidName(String name){
        return (name.length() >= minNameLength && name.length() <= maxNameLength && isAlphabet(name));
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
    
    public boolean isValidTourCode(int tourCode){
        return String.valueOf(tourCode).length()==tourCodeLength;
    }
}
