/**
	*This class represents a Math core course in the BCS program
	*@author Michael Roscoe
**/
public class MathCourse extends Course {

	/**
		*Constructs a MathCourse
		*@param t The title of the course
		*@param g The grade received in the course
		*@param c The credit hours of the course
	**/
	public MathCourse (String t, String g, int c) {
		super (t,g,c);
	}
	/**
		*Determines the total number of grade points earned in this course
		*@return The total grade points earned
	**/
	public double getPoints () {
		return (1.2 * super.getCreditHours() * super.gradeConvert(super.getGrade()));
	}
}