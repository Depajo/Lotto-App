package fi.tuni.tamk.tiko.depascalejoonatan.util;

/** 
 * The class Arrays contain methods performing beisics.
 * 
 * This class contain besics methods what arrays need. 
 * The documentation for the methods contained in this class includes briefs description of the implementations.
 * 
 * @author Joonatan De Pascale
*/

public class Arrays {

    /**
     * Convert string arrays to integer array.
     * 
     * Which will get an String array and it transforms that into an int array.
     * 
     * Method creates a new integer array that is the same size as the array obtained by the parameter. 
     * Go through the integer array and put the values from the string array into the integer array. 
     * Before putting it in the integer array, the values are converted to integers with Integer.parseInt.
     * 
     * @param array Take as a parameter string arrays
     * @return returns the integer array
    */
    public static int [] toIntArray(String [] array) {
        int size = array.length;
        int [] intArray = new int [size];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }

        return intArray;
    }

    /**
     * 
     * Searshes the arrays for a value and returns true if the value can de found
     * 
     * Go though the array with a loop and if the value is found return true. 
     * If the value not found returns false.
     * 
     * @param value value whose you want in array
     * @param array check if the value in the this array
     * @return if the value is in the array, returns true if otherwise returns false
    */

    public static boolean contains(int value, int [] array) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return true;
            }
        }

        return false;
    }
    
    /**
     *  
     * Compare the two arrays and tell you how many of the same values can be found.
     * 
     * First, it is compared whether both lists are the same length. Goes through the each value of array1
     * and looks for the same value in array2, if the value is found in array2 adds one more in sameValue.
     * If the lists are of different lengths return an error "Arrays are different sizes".
     * 
     * @param array1 is a integer array where search same value what is in the secend array
     * @param array2 is a integer array where search same value what is in the secend array
     * @return integer value how many the same value is in the arrrays
     */
    
    public static int containsSameValues(int [] array1, int [] array2) {
        int sameValue = 0;
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (contains(array1[i], array2)) {
                    sameValue++;
                }
            }
        } else {
            System.out.println("Arrays are different sizes");
        }

        return sameValue;
    }

    /**
     * 
     * This method print the integer array values
     * 
     * This method read through and print the values one by one. If values are less than 10 add zero fornt of the number.
     * The values print separated in commas for example like this [01, 09, 10, 17].
     * 
     * @param array array what you want to print
    */

    public static void printIntArray(int [] array) {
        String print = "[";
        for(int i = 0; i < array.length; i++){
            if (array[i] < 10) {
                print += "0";
            }
            print += array[i];
            if(!(i == array.length-1)) {
               print += ", ";
            }
        }
        print += "]";
        System.out.println(print);
    }

    /**
     * 
     * Method remove the index value of the array and returns a new table without the value of the remuved index. 
     * The array size of the array is one less.
     * 
     * Method creates a new array that is one smaller in size. Go through each index in the array and add the values in new array.
     * If the index is the remove index it adds the value of the next index repeating this until the end of the array.
     * Then returns the new array wihtout the value of the desired index.
     * 
     * @param removeIndex This number is the index which you want to delete.
     * @param numbers Integer array from which you want to delete index.
     * @return New integer array without removeNumber
    */

    public static int[] removeIndex(int removeIndex, int [] numbers) {
        int size = numbers.length-1;
        int [] newNumbers = new int[size];
        
        for (int i = 0; i < newNumbers.length; i++) {
            if (i < removeIndex) {
                newNumbers[i] = numbers[i];
            } else {
                newNumbers[i] = numbers[i+1];
                
            }
        } 
        return newNumbers;
    }

    /**
     * 
     * Method add the value in arrays index if arrays index is null.
     * 
     * Method checks the array index and if the index is a null 
     * then add the value in arrays index, before add the given value convert the value to string.
     * 
     * @param index An index where add a value.
     * @param value Integer value.
     * @param array Getting string array which is empty.
     * @return 
     */

    public static String[] addArray(int index, int value, String [] array) {
        
        if (array[index-1] == null){
            array[index-1] = String.valueOf(value);
        }
        return array;
    }

    /**
     * 
     * Method sorted integer array smallest to largest and return array.
     * 
     * 
     * 
     * @param array Integer array -
     * @return Integer array which is sorted from smallest to largest.
    */

    public static int[] sort(int [] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int smallest = array[i];
            array[i] = array[min];
            array[min] = smallest;
        }

        return array;
    }

}

