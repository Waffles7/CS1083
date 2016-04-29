/**
	*This class represents a core CS or INFO course
	*@author Michael Roscoe
**/
public class CSCourse extends Course {

	/**
		*Constructs a CSCourse
		*@param t The title of the course
		*@param g The grade received in the course
		*@param c The credit hours of the course
	**/
	public CSCourse (String t, String g, int c) {
		super (t,g,c);
	}
	/**
		*Determines the total number of grade points earned in this course
		*@return The total grade points earned
	**/
	public double getPoints () {
		return (1.6 * super.getCreditHours() * super.gradeConvert(super.getGrade()));
	}
}