/**
	*This class represents a breadth core course in the BCS program
	*@author Michael Roscoe
**/
public class BreadthCourse extends Course {

	/**
		*Constructs a BreadthCourse
		*@param t The title of the course
		*@param g The grade received in the course
		*@param c The credit hours of the course
	**/
	public BreadthCourse (String t, String g, int c) {
		super (t,g,c);
	}
	/**
		*Determines the total number of grade points earned in this course
		*@return The total grade points earned
	**/
	public double getPoints () {
		return (super.getCreditHours() * super.gradeConvert(super.getGrade()));
	}
}