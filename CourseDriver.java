/**
	*This class is a test driver to test all of the classes written for
	*assignment #3
	*@author Michael Roscoe
**/
import java.util.Scanner;
public class CourseDriver {

	public static void main(String[] args) {
		//Indentify, and create the student
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		Student s = new Student(name);
		String title = sc.next();
		while (!(title.equals("end"))) {
			//Pulls in course information
			int credit = sc.nextInt();
			String grade = sc.next();
			int cat = sc.nextInt();
			Course c;
			//Decides the category of course
			switch (cat) {
				case 1: c = new CSCourse(title, grade, credit); break;
				case 2: c = new TechCourse(title, grade, credit); break;
				case 3: c = new MathCourse(title, grade, credit); break;
				case 4: c = new BreadthCourse(title, grade, credit); break;
				default: c = new FreeCourse(title, grade, credit); break;
			}
			//Adds the course, moves to next line
			s.addCourse(c);
			sc.nextLine();
			title = sc.next();
		}
		//Print original course data
		System.out.println("\nOriginal Data:\n");
		System.out.println(s.toString());

		//Print sorted course data
		s.orderCourses();
		System.out.println("Sorted Data:\n");
		System.out.println(s.toString());

		title = sc.next();
		while (!(title.equals("end")))  {
			//Find course to check, and call findCourse on said course
			String courseToFind = title;		
			System.out.println(s.findCourse(courseToFind));
			title = sc.next();
		}
	}
}
