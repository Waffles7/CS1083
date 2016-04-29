/**
	*This class represents an other student using the Student
	*@author Kohdy Nicholson
	*@author Michael Roscoe
**/
public class OtherStudent extends Student {

	/**
		*Constructs an OtherStudent using the same parameters as the Student class
		*@param nameIn The name of the student
		*@param idIn The ID of the student
		*@param yearIn The year of study of the student
		*@param daysIn The days since registration of the student
	**/
	public OtherStudent (String nameIn, String idIn, int yearIn, int daysIn) {
		super (nameIn, idIn, yearIn, daysIn);
	}
	/**
		*Method to calculate the priority of an OtherStudent
		*@return The priority of the student
	**/
	public int priority () {
		return ((super.getYear() * 2) + super.getDays());

	}
}