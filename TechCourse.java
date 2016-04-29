/**
	*This class represents a technical elective for the BCS program
	*@author Michael Roscoe
**/
public class TechCourse extends Course {

	/**
		*Constructs a TechCourse
		*@param t The title of the course
		*@param g The grade received in the course
		*@param c The credit hours of the course
	**/
	public TechCourse (String t, String g, int c) {
		super (t,g,c);
	}
	/**
		*Determines the total number of grade points earned in this course
		*@return The total grade points earned
	**/
	public double getPoints () {
		return (1.4 * super.getCreditHours() * super.gradeConvert(super.getGrade()));
	}
}