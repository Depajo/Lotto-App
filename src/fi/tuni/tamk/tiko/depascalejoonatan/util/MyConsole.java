package fi.tuni.tamk.tiko.depascalejoonatan.util;

import java.io.Console;

/**
* The class MyConsole contains methods for performing basics.
*
* @author Joonatan De Pascale
*/

public class MyConsole {

    /**
     * 
     * Asks the user for integer number. The number must be between min and max. 
     * 
     * If the number does not meet the conditions you will receive an error message.
     * You can set the error message yourself.
     * 
     * @param min minimum number accepted from the user
     * @param max Biggest number accepted from the user
     * @param errorMessageNonNumeric String message if the input is not are number.
     * @param errorMessageNonMinAndMax String message if the input is not are between min and max.
     * @return
    */
    
    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {
        Console c = System.console();
        boolean end = false;
        int input = 0;
        while(!end) {
            System.out.println("Pleas give a unique number between [" + min + ", " + max + "]");
            try {
                input = Integer.parseInt(c.readLine());
                if (input >= min && input <= max ) {
                    end = true;
                } else {
                    System.out.println(errorMessageNonMinAndMax);
                }
            } catch(NumberFormatException e) {
                System.out.println(errorMessageNonNumeric);
            }
        }
        return input;
    }

}
