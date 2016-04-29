/**
	*Program to test if an input string is a palindrome
	*@author Michael Roscoe
	*@author Kohdy Nicholson
**/
import java.util.Scanner;
public class Palindrome {

	public static void main(String[] args) {
		String x;
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		x = scan.nextLine();
		if (stringCompare(x)) {
			System.out.println("This string is a palindrome: '"  + x + "'");
		} else {
			System.out.println("This string is not a palindrome: '"  + x + "'");
		}
	}

	public static boolean stringCompare(String s) {
		boolean success = false;
		if (s.length() == 0 || s.length() == 1) {
			success = true;
		} else {
			if (s.charAt(s.length()-1) == s.charAt(0)) {
				success = stringCompare(s.substring(1,s.length()-1));
			}
		}
		return success;
	}
}