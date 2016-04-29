/**
	*This class represents a general course that can be implmented by other courses
	*@author Michael Roscoe
**/
import java.text.NumberFormat;
public abstract class Course implements Comparable<Course> {
	/**
		*The number of credit hours the course is worth
	**/
	private int credit;
	/**
		*The letter grade received in the course
	**/
	private String grade;
	/**
		*The title of the course
	**/
	private String title;

	/**
		*Constructs a course
		*@param t The title of the course
		*@param g The grade received in the course
		*@param c The credit hours of the course
	**/
	public Course (String t, String g, int c) {
		credit = c;
		grade = g;
		title = t;
	}	
	/**
		*Converts a letter grade to the equivalent point value
		*@param letterGrade The letter grade to convert
		*@return The equivalent point value
	**/
	public static double gradeConvert(String letterGrade) {
		double x = 0.0;
		String s = letterGrade.toLowerCase();
		switch (s) {
			case "a+": x = 4.3; break;
			case "a": x = 4.0; break;
			case "a-": x = 3.7; break;
			case "b+": x = 3.3; break;
			case "b": x = 3.0; break;
			case "b-": x = 2.7; break;
			case "c+": x = 2.3; break;
			case "c": x = 2.0; break;
			case "d": x = 1.0; break;
			case "f": x = 0.0; break;
		}
		return x;
	}
	/**
		*Creates and returns a textual string containing the course title,
		*letter grade, and total grade points earned (2 decimal digits)
		*@return The textual string
	**/
	public String toString () {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		return title + "\t" + grade + "\tpoints = " + nf.format(this.getPoints());
	}
	/**
		*Determines the total number of grade points earned in this course
		*@return The total grade points earned
	**/
	public abstract double getPoints ();

	/**
		*Retrieves the course title
		*@return The title for this course
	**/
	public String getTitle () {
		return title;
	}
	/**
		*Retrieves the letter grade
		*@return The letter grade for this course
	**/
	public String getGrade() {
		return grade;
	}
	/**
		*Retrieves the credit hours
		*@return The credit hours for this course
	**/
	public int getCreditHours() {
		return credit;
	}
	/**
		*Compares courses based on their total grade points
		*@param The other course to compare
		*@return An integer value to indicate <,>, or ==
	**/
	public int compareTo (Course other) {
		int x = 0;
		if (other.getPoints() < this.getPoints()) {
			x = 1;
		} else if (other.getPoints() > this.getPoints()) {
			x = -1;
		}
		return x;
	}
}