/**
* Student Sorter - reads students in at command line or from redirected file
* sorts the students and outputs the result
* the sort, initially has a couple of bugs in it.
* @author Kohdy Nicholson
* @author Michael Roscoe
*/

import java.util.Scanner;


public class StudentSorter
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter(",");

		System.out.println("Enter the total number of students>");
		int sCount = scan.nextInt();
		scan.nextLine();
		
		Student[] studentList = new Student[sCount];

		for (int i = 0; i < sCount; i++)
		{
			System.out.println("Enter student name, id, major, year, days since registration>");
			String name = scan.next(); 
			String id = scan.next();
			String major = scan.next();
			int year = scan.nextInt();
			int daysSinceReg = scan.nextInt();
			scan.nextLine();
		
			if (major.equalsIgnoreCase("CS"))	
				studentList[i] = new CSStudent(name, id, year,daysSinceReg);	
			else
				studentList[i] = new OtherStudent(name, id, year,daysSinceReg);
		}

		brokenSort(studentList);

		System.out.println("\n\n------Sorted Students------");

		for (int i = 0; i < sCount; i++)
			System.out.println(studentList[i]);
	}

	public static void brokenSort(Student[] list)
   	{
		int min;
		Student temp;

		//visit each spot in the array
		for (int i = 0; i < list.length-1; i++)
		{
			min = i;

			//compare each spot in the array with each item in the unsorted list
			for (int j = i + 1; j < list.length; j++)
			{
				//is the current that is found the new smallest number
				if (list[j].compareTo(list[i]) > 0)
				{
					if (list[j].compareTo(list[min]) > 0){
						min = j;
					}
				}
			}
			// Swap the values
			temp = list[i];
			list[i] = list[min];
			list[min] = temp;
		}
	}
}
