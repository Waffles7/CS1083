/**
 * This class will read in an int value and check
 * if it is prime or not
 * @author Michael Roscoe
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class PrimeTester {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter an integer to check if it is prime: ");
        try {
            int prime = sc.nextInt();
            System.out.println("Testing using loops:");
            if (checkPrimeLoop(prime)) {
                System.out.println("This number is a prime: " + prime);
            } else {
                System.out.println("This number is not a prime: " + prime);
            }
            System.out.println("Testing using recursion:");
            if (checkPrimeRecursive(prime, prime, 0)) {
                System.out.println("This number is a prime: " + prime);
            } else {
                System.out.println("This number is not a prime: " + prime);
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Error: Non-integer value entered.");
        }
    }
    /**
     * This method checks whether a passed in int is a prime using iteration
     * @param n The number to be checked for being a prime
     * @return Indication of the number being prime or not
     */
    public static boolean checkPrimeLoop(int n) {
        boolean success;
        if (n < 1) {
            throw new IllegalArgumentException("Argument less than 1, illegal argument");
        }
        int count = 0;
        for (int i = n; i > 0; i--) {
            if (n%i == 0) {
                count++;
            }
        }
        success = (count == 2);
        return success;
    }
    /**
     * This method checks whether a passed in int is a prime using iteration
     * @param n The number to be checked
     * @param start The current value to be divided
     * @param count The number of times that the division had a remainder of 0
     * @return Indication of the number being prime or not
     */
    public static boolean checkPrimeRecursive(int n, int start, int count) {
        boolean success;
        if (n < 1) {
            throw new IllegalArgumentException("Argument less than 1, illegal argument");
        }
        if (start == 0) {
            success = (count == 2);
        } else if (n%start == 0) {
            success = checkPrimeRecursive(n, start-1, count+1);
        } else {
            success = checkPrimeRecursive(n, start-1, count);
        }
        return success;
    }
}
