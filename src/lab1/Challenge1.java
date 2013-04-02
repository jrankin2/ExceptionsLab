package lab1;

import javax.swing.JOptionPane;

/**
 * The purpose of this challenge is to give you practice time using
 * Java Exception handling techniques.
 * <p>
 * Your challenge is to consider all the possible things that can go wrong
 * with this program and use exception handling where appropriate to prevent
 * the program from crashing. In addition you must display a friendly error
 * message in a JOptionPane and ask the user to try again.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Challenge1 {
    private static final int LAST_NAME_IDX = 1;
    private static final int LAST_NAME_WITH_COMMA_IDX = 0;
    private static final int LAST_NAME_WITH_MIDDLE_IDX = 0;

    public static void main(String[] args) {
        Challenge1 app = new Challenge1();
        
        String fullName = JOptionPane.showInputDialog("Enter full name:");
        try{
            String lastName = app.extractLastName(fullName);
            String msg = "Your last name is: " + lastName;
            JOptionPane.showMessageDialog(null, msg);
        
        } catch(IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(null, iae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    /*
     * special characters are not allowed, only letters, commas, and spaces
     * 
     * does not mandate case.
     * 
     * if name contains " " without ",":
     * last name comes 2nd
     * 
     * if name contains ",":
     * last name comes first
     */
    public String extractLastName(String fullName) {
        if(fullName == null || fullName.length() == 0){
            throw new IllegalArgumentException("Entry is required.");
        }
        
        for (char chr : fullName.toCharArray()) {
            if(!Character.isLetter(chr) && !(chr == ' ') && !(chr == ',')){
                throw new IllegalArgumentException("Invalid character found");
            }
        }
        
        if(fullName.contains(", ")) {
            return fullName.split(", ")[LAST_NAME_WITH_COMMA_IDX];
        }else if(fullName.contains(" ")) {
            return (fullName.split(" ").length == 2? fullName.split(" ")[LAST_NAME_IDX] : fullName.split(" ")[LAST_NAME_WITH_MIDDLE_IDX]);
        } else{
            throw new IllegalArgumentException("Name must contain a space or comma.");
        }
    }

}
