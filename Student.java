/**
	*This class is an abstract class to represent a generic student
	*@author Kohdy Nicholson
	*@author Michael Roscoe
**/
public abstract class Student implements Comparable<Student> {

	/**
		*The name of the student
	**/
	private String name;
	/**
		*The ID of the student
	**/
	private String ID;
	/**
		*The year of study for the student
	**/
	private int yearStudy;
	/**
		*The days since registration for the student
	**/
	private int dayReg;
	/**
		*Constructs a Student object taking in data to initialize the instance variables
		*@param nameIn The name of the student
		*@param idIn The ID of the student
		*@param yearIn The year of study of the student
		*@param daysIn The days since registration of the student
	**/
	public Student (String nameIn, String idIn, int yearIn, int daysIn) {
		name = nameIn;
		ID = idIn;
		yearStudy = yearIn;
		dayReg = daysIn;
	}
	/**
		*Accessor method for the name
		*@return The name of the student
	**/
	public String getName () {
		return name;
	}
	/**
		*Accessor method for the ID
		*@return The ID of the student
	**/
	public String getID () {
		return ID;
	}
	/**
		*Accessor method for the year of study
		*@return The year of study of the student
	**/
	public int getYear () {
		return yearStudy;
	}
	/**
		*Accessor method for the days since registration of the student
		*@return The days since registration of the student
	**/
	public int getDays () {
		return dayReg;
	}
	/**
		*Future method to determine the priority of the data
	**/
	public abstract int priority ();
	/**
		*Method to return a properly formatted String representing the student
		*@return The String representing the student
	**/
	public String toString () {
		String s = name + "\t(" + ID + "):\t" + this.priority();
		return s;
	}
	/**
		*Method to compare two students to determine the order of the students by prioirty
		*@param otherStudent The student to be compared to
		*@return An integer showing the order based on negative, equal, or positive values
	**/
	public int compareTo (Student otherStudent) {
		int x = 0;
		if (this.priority() > otherStudent.priority()) {
			x = 1;
		} else if (this.priority() < otherStudent.priority()) {
			x = -1;
		}
		return x;
	}
}