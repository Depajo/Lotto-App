package fi.tuni.tamk.tiko.depascalejoonatan.util;

/**
* 
* The class Math contains methods for performing basics.
*
* @author Joonatan De Pascale
*/

public class Math {

    /**
    * Return a random number between min and max
    * 
    * This method returns the given minimum and maximum 
    * numbers passed by a random number
    * 
    * @param min the smallest given number which can be a random number
    * @param max the biggest given number which can be a random number
    * @return return random number given between min and max
    */
    
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }


    /**
    * Returns the absolute value of an int value. 
    *
    * If the argument is not negative, the 
    * argument is returned. If the argument is negative, the negation of the argument 
    * is returned.
    * 
    * @param a the argument whose absolute value is to be determined
    * @return the absolute value of the argument.
    */
    
    public static int abs(int a) {
        if(a < 0) {
            return a * -1;
        } else {
            return a;
        }
    }
}
