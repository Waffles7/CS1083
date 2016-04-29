/**
	*This class represents a student in the BCS program
	*@author Michael Roscoe
**/
import java.util.*;
public class Student {

	/**
		*A static int for the class to generate unique student ID's
	**/
	private static int counter = 1000;
	/**
		*A unique ID for each student created
	**/
	private final int ID;
	/**
		*The name of the student
	**/
	private final String name;
	/**
		*The courses the student is taking
	**/
	private Course[] courseList;
	/**
		*Constructs a student
		*@param n The name of the student
	**/
	public Student (String n) {
		ID = counter++;
		name = n;
		courseList = new Course[0];
	}
	/**
		*Adds a course to the student's course list
		*@param e The course to be added
	**/
	public void addCourse (Course e) {
		ArrayList<Course> list = new ArrayList<Course>(Arrays.asList(courseList));
		list.add(e);
		courseList = list.toArray(courseList);
	}
	/**
		*Sorts the student's courses by the points received
	**/
	public void orderCourses () {
		Sorting.selectionSort(courseList);
	}
	/**
		*Attempts to find a course in a student's list
		*@param t The course to be found
		*@return A String either representing the course found, or stating failuree
	**/
	public String findCourse (String t) {
		String s = "";
		boolean success = false;
		int index = 0;
		for (int i = 0; i < courseList.length; i++) {
			if (courseList[i].getTitle().equals(t)) {
				index = i;
				success = true;
				break;
			}
		}
		if (success) {
			s = "Course  " + courseList[index].toString();
		} else {
			s = "Course  " + t + " was not found.";
		}
		return s;
	}
	/**
		*Method to create a properly formatted String representing the student
		*@return The properly formatted String representing the student
	**/
	public String toString () {
		String s = name + "\n";
		s += "Courses: \n   ";
		for (int i = 0; i < courseList.length; i++) {
			s += courseList[i].toString() + "\n   ";
		}
		return s;
	}
}