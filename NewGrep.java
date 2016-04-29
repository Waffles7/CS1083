/**
	*This is an implementation of the grep program found in Unix systems
	*@author Michael Roscoe
**/
import java.util.Scanner;
import java.io.*;
public class NewGrep {

	public static void main(String[] args) throws IOException {
		
		if (args.length == 2) {
			try {
				Scanner fileScan = new Scanner(new File(args[1]));
				Scanner stringScan;
				int lineNumber = 1;
				int totalLines = 0;

				System.out.println("\nSearching " + args[1] + " for '" + args[0] + "'...\n");
				while (fileScan.hasNext()) {

					String s = fileScan.nextLine();
					stringScan = new Scanner(s);

					while (stringScan.hasNext()) {
						if (stringScan.next().toLowerCase().contains(args[0].toLowerCase())) {
							System.out.println(lineNumber + ": " + s);
							totalLines++;
							break;
						}
					}
					lineNumber++;
				}
				System.out.println("\nLines containing " + args[0] + ": " + totalLines + "\n");
			}
			catch (FileNotFoundException e) {
				System.err.println("\nFile " + args[1] + " was not found.");
				System.err.println("Please restart the program with a valid file name.\n");
			}
		} else {
			System.out.println("\nImproper number of command line arguments.");
			System.out.println("Please restart the program with two arguments: a search term and the file.\n");
		}		
	}

}