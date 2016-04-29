/**
	*This class represents a CS student using the Student class
	*@author Kohdy Nicholson
	*@author Michael Roscoe
**/
public class CSStudent extends Student{

	/**
		*Constructs a CS Student using the same parameters as the Student class
		*@param nameIn The name of the student
		*@param idIn The ID of the student
		*@param yearIn The year of study of the student
		*@param daysIn The days since registration of the student
	**/
	public CSStudent (String nameIn, String idIn, int yearIn, int daysIn) {
		super(nameIn, idIn, yearIn, daysIn);
	}
	/**
		*Method to return the priority of a CS Student
		*@return The priority of the student
	**/
	public int priority () {
		return ((super.getYear() * 3) + (super.getDays() * 2));
	}
}