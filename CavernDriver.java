/**
	*This class is a driver to test and utilize the CavernArea class
	*@author Michael Roscoe
**/
import java.util.Scanner;
public class CavernDriver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);


		System.out.println("\nPlease enter the height and width of the cavern to be represented, seperated by a space:");
		CavernArea currentCavern = new CavernArea(sc.nextInt(), sc.nextInt());

		System.out.println("\nThis is the cavern entered:");
		System.out.println(currentCavern.toString());

		System.out.println("The area of the cavern is: " + currentCavern.findArea());

		System.out.println("\nThis is the cavern searched:");
		System.out.println(currentCavern.toString());

	}
}