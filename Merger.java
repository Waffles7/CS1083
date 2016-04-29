/**
	*This class reads in text files and produces a merged binary file
	*@author Michael Roscoe
**/
import java.text.NumberFormat;
import java.io.*;
import java.util.Scanner;
public class Merger {

	public static void main(String[] args) {
		
		try {
			//Cration of scanners, inputs, and needed variables
			Scanner fileScan1 = new Scanner(new File(args[0]));
			Scanner fileScan2 = new Scanner(new File(args[1]));
			FileOutputStream out = new FileOutputStream("Merged.dat");
			BufferedOutputStream buffer = new BufferedOutputStream(out);
			ObjectOutputStream o = new ObjectOutputStream(buffer);
			Fundraiser f1 = createObject(fileScan1.nextLine());
			Double teamOne = f1.getMoneyRaised();
			Fundraiser f2 = createObject(fileScan2.nextLine());
			Double teamTwo = f2.getMoneyRaised();
			while (fileScan1.hasNext() || fileScan2.hasNext()) {	
				//If both are something, compare
				if (f1 != null && f2 != null) {
					int x = f1.compareTo(f2);
					if ((x > 0) && (fileScan1.hasNext())) {
						o.writeObject(f1);
						f1 = createObject(fileScan1.nextLine());
						teamOne += f1.getMoneyRaised();
					} else if (fileScan2.hasNext()) {
						o.writeObject(f2);
						f2 = createObject(fileScan2.nextLine());
						teamTwo += f2.getMoneyRaised();
					}
				//If one has something and the other doesn't, print the one	
				} else if (f1 != null && !(fileScan2.hasNext())) {
					o.writeObject(f1);
					if (fileScan1.hasNext()) {
						f1 = createObject(fileScan1.nextLine());
						teamOne += f1.getMoneyRaised();
					}
				//Same case as above, opposite files	
				} else {
					o.writeObject(f2);
					if (fileScan2.hasNext()) {
						f2 = createObject(fileScan2.nextLine());
						teamTwo += f2.getMoneyRaised();
					}
				}
				//If either file is done, set to null
				if (!fileScan1.hasNext() && f1 != null) {
					o.writeObject(f1);
					f1 = null;
				}
				if (!fileScan2.hasNext() && f2 != null) {
					o.writeObject(f2);
					f2 = null;
				}
			}
			//Close the output and print the desired result
			o.flush();
			out.close();
			NumberFormat formatter = NumberFormat.getCurrencyInstance();
			System.out.println("The total fundraising money raised in " + args[0] + " : " + formatter.format(teamOne));
			System.out.println("The total fundraising money raised in " + args[1] + " : " + formatter.format(teamTwo));
		}
		catch (FileNotFoundException e) {
			System.err.println("One or both files could not be found or opened.");
		}
		catch (IOException e) {
			System.err.println("There was a problem reading from the files.");
		}
	}
	/**
		*Method to create Fundraiser objects from imported strings
		*@param s The string to use to create 
		*@return The created fundraiser object
	**/
	private static Fundraiser createObject (String s) {
		Fundraiser f;
		Scanner sc = new Scanner(s);
		sc.useDelimiter(";");
		double money = Double.parseDouble(sc.next().substring(1));
		String lastName = sc.next();
		String firstName = sc.next();
		String name = firstName + " " + lastName;
		f = new Fundraiser(name);
		f.addFundraisingMoney(money);
		return f;
	}
} 