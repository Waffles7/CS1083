/**
 * This class converts a binary number to its decimal equivalent
 * @author Michael Roscoe
 */
import java.util.Scanner;
public class BinaryDecimal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a binary string to convert to decimal: ");
        String binary = sc.next();
        System.out.println("This number in decimal is: " + binToDecimal(binary, 0));
    }
    /**
     * This method converts a binary String to a decimal integer
     * using recursion
     * @param s The remaining binary String
     * @param n The current exponent of 2
     * @return The additional decimal value from this call of the method
     */
    public static int binToDecimal (String s, int n) {
        int result = 0;
        if (s.length() == 0) {
            result = 0;
        } else {
            try {
                result += (Integer.parseInt(s.substring(s.length() - 1)) * (Math.pow(2, n)));
            }
            catch (NumberFormatException e) {
                System.out.println("Error: String contained non-integer values.");
            }
            result += binToDecimal(s.substring(0, s.length()-1), n+1);
        }
        return result;
    }
}
