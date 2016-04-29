/**
	*This class represents a free elective course in the BCS program
	*@author Michael Roscoe
**/

public class FreeCourse extends Course {

	/**
		*Constructs a FreeCourse
		*@param t The title of the course
		*@param g The grade received in the course
		*@param c The credit hours of the course
	**/
	public FreeCourse (String t, String g, int c) {
		super (t,g,c);
	}
	/**
		*Determines the total number of grade points earned in this course
		*@return The total grade points earned
	**/
	public double getPoints () {
		return (0.8 * super.getCreditHours() * super.gradeConvert(super.getGrade()));
	}
}