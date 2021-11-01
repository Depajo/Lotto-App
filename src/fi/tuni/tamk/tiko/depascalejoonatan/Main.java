package fi.tuni.tamk.tiko.depascalejoonatan;

import fi.tuni.tamk.tiko.depascalejoonatan.util.Math;

import java.io.Console;

import fi.tuni.tamk.tiko.depascalejoonatan.util.*;

/** 
 * 
 * In this class i build lotto - application. 
 * This application tell you how many years you have to play lotto before you win seven rights.
 * I don't use "ArrayList" or "Set" classes. 
 * I practising arrays and i do every methods myself even though they can be found ready-made
 * 
 * 
 * @author Joonatan De Pascale
 * 
*/

public class Main {

    static final int LOTTO_NUMBER_COUNT = 7;
    static final int BIGGEST_LOTTO_NUMBERS = 40;
    static boolean SHOW_WINS = false;
    static int [] lottoLine = null;
    public static void main(String [] args) {
        
        if (args.length == LOTTO_NUMBER_COUNT){
            lottoLine = Arrays.toIntArray(args);
        } else {
            lottoLine = askNumbers(LOTTO_NUMBER_COUNT);
        }
        lifetimeLotto(lottoLine);
        
    }
    
    /** 
     * 
     * Method ask that dou you wnat to see when you get right. The answer is given in letters. "Y" is yes and "n" is no. 
     * 
     * Method ask you question and you have to answer yes or no. Your answer is in letter y or n. If you give something else
     * return is that your answer is not valid and then asks again.
     * 
    */

    public static void askShowWin() {
        Console c = System.console();
        System.out.println("Would you like to see when you win? y = yes/n = no");
        String answer = c.readLine();
        if (answer.equals("y")) {
            SHOW_WINS = true;
        } else if (answer.equals("n")) {
            SHOW_WINS = false;
        } else {
            System.out.println("Your answer is not valid. Please try again!");
            askShowWin();
        }
    }

    /**
     * 
     * Method ask you numbers as many times as you parameter number are.
     * After entering the numbers returns a method list with the entered numbers.
     * 
     * Method create new integer array whose size are the number what you are given in parameter.
     * The user is ask for to enter the numbers to be added to the array. 
     * Numbers are requested with MyConsole.readInt method where parameter is minimum number is one and biggest number is (variable name) BIGGEST_LOTTO_NUMBERS.
     * Error messages are also given as parameters. Once you have entered the number it is checked that there is no other same number. If there is same number
     * you get error message where you will be asked to enter a new number.
     * 
     * @param numbers how meny times you want to ask numbers.
     * @return array where the numbers are.
     */

    public static int [] askNumbers(int numbers) {
        int [] numberLine = new int [numbers];
        int i = 0;
        while (i < numbers) {
            int number = MyConsole.readInt(1, BIGGEST_LOTTO_NUMBERS, 
            "User did not gave a integer number. Please try again!", 
            "User did not gave a integer number between min and max. Pleas try again!");
            if (!(Arrays.contains(number, numberLine))) {
                numberLine[i] = number;
                i++;
            } else {
                System.out.println("Pleas put different numbers");
            }  
        }
        return numberLine;
    }

    /**
     * 
     * Method calculate lottery numbers and then return array where is the random numbers.
     * 
     * There are as many numbers as you have specified for LOTTO_NUMBER_COUNT. 
     * The range of drawn numbers depends on what the BIGGEST LOTTO NUMBER is.
     * 
     * @return Integer array where are the number seven random number.
     */

    public static int[] calculateLotto() {
        int [] numbers = new int[BIGGEST_LOTTO_NUMBERS];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (i+1);
        }
        int index = Math.getRandom(0, numbers.length-1);
        int [] lotto = new int [LOTTO_NUMBER_COUNT];
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = numbers[index];
            numbers = Arrays.removeIndex(index, numbers);
            index = Math.getRandom(0, numbers.length-1);
        }
        return lotto;
    }

    /**
     * 
     * This method calculates how long it takes you to get the lottery seven correctly. 
     * If you get seven correctly less then 120 year this method returns true.
     * 
     * Method go through as many times as random lottery numbers are for example seven correct. 
     * WeeklyLotto variable calls calculateLotto() method which gets, for example, seven random numbers.
     * Then compares users lottery numbers and weeklyLotto variable with the Arrays.containsSameValues method. 
     * It gets the number how many is correct. 
     * If the correctly number is for example seven then lifetime variable is true and the loop is be stopped.
     * Otherwise it increments the weeks variable by one. 
     * It then adds the number of years to the BestOf array. 
     * The position of the BestOf array is determined by the how many hit right.
     * 
     * @return true or false
    */

    public static boolean right() {
        int weeks = 0;
        int years = 0;
        boolean end = false;
        String [] bestOf = new String[LOTTO_NUMBER_COUNT];
        boolean lifetime = false;
        int [] weeklyLotto = null;
        askShowWin();
        while(!(end)) {
            //int [] lottoLine = calculateLotto();
            weeklyLotto = calculateLotto();
            int rights = Arrays.containsSameValues(lottoLine, weeklyLotto);
            
            if (rights == LOTTO_NUMBER_COUNT) {
                end = true;
            } else {
                weeks++;
            }
            
            if(rights > 0) {  
                Arrays.addArray(rights, years, bestOf);
                printLotteryWin(SHOW_WINS, weeklyLotto, lottoLine, rights, years);
            }
            
            if (years > 120) { 
                lifetime = false;
            } else {
                lifetime = true;
                
            }
            
            if (weeks == 52) {
                years++;
                weeks = 0;
            }
        }
        
        printBestOf(bestOf);

        if (lifetime == false) {
            System.out.println("Althought it took more than a lifetime, let's try it again.");
        } else {
            System.out.println("You won the lottery in your lifetime");
        }
        return lifetime;
    }

    /**
     * 
     * This method prints best of each right and how many years it took.
     * 
     * @param bestOf String array where is the years.
    */

    public static void printBestOf(String [] bestOf) {
        for (int i = 0; i < bestOf.length; i++) {
            System.out.println("Got " + (i+1) + " right! Took " + bestOf[i] + " years");
        }
    }

    /**
     * 
     * This method goes through the Right() method as many times before it returns false.
     * 
     * @param array integer array where are your lotto numbers
     */

    public static void lifetimeLotto(int [] array) {
        while(!(right())) {
            right();
        }
    }

    /**
     * 
     * Method prints a lottery with at least one right. 
     * 
     * This method prints a lottery there you see the random lottery numbers and your own numbers. 
     * Also you see how many correctly hit you got. Method print only if parameter "show" is true. 
     * Then method calls the method askShowWin().
     * 
     * @param show Gets true or false.
     * @param randomLotto Gets array where are random numbers.
     * @param userLotto Gets array where are user numbers.
     * @param rights Takes integer number of correctly guessed numbers.
     * @param years Takes the year as an integer.
     */

    public static void printLotteryWin(boolean show, int [] randomLotto, int [] userLotto, int rights, int years) {
        if (show) {
            System.out.print("\nUser lotto:   ");
            Arrays.printIntArray(Arrays.sort(userLotto));
            System.out.print("Random lotto: ");
            Arrays.printIntArray(Arrays.sort(randomLotto));
            System.out.println("Got " + rights + " right! Took " + years + " years\n");
            askShowWin();
        } 
    }    
}