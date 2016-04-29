/**
	*This class reads in all Fundraiser objects in a binary file and prints
	*appropriate information for each object.
	*@author Michael Roscoe
**/
import java.text.NumberFormat;
import java.io.*;
import java.util.Scanner;
public class FundraiserReader {

	public static void main(String[] args) {
		
		try {
			//Creation of input
			FileInputStream in = new FileInputStream("Merged.dat");
			BufferedInputStream buffer = new BufferedInputStream(in);
			ObjectInputStream o = new ObjectInputStream(buffer);
			//Creation of output
			FileWriter fw = new FileWriter(args[0]);
			BufferedWriter buf = new BufferedWriter(fw);
			PrintWriter printer = new PrintWriter(buf);
			//Write every object until end of file.
			while(true) {
				try {
					printPerson(printer, o.readObject());
				}
				//Use end of file exception to break while loop
				catch (EOFException e) {
				System.err.println("End of input file reached.");
				break;
				}
				catch (ClassNotFoundException e) {
				System.err.println("The class name read by the readObject method is not defined.");
				}
			}
			printer.close();

		}
		catch (FileNotFoundException e) {
			System.err.println("Merged.dat file was not found.");
		}
		catch (IOException e) {
			System.err.println("There was an issue with the input/output stream.");
		}
		finally {
			System.out.println("Output file was created.");
		}
	}
	/**
		*Method to print out objects read in from input file
		*@param pw The PrintWriter object to be used
		*@param obj The object to be printed
	**/
	private static void printPerson(PrintWriter pw, Object obj) {
			NumberFormat formatter = NumberFormat.getCurrencyInstance();
			Fundraiser f = (Fundraiser) obj;
			String s = formatter.format(f.getMoneyRaised()) + " - " + f.getName();
			pw.println(s);


	}
}