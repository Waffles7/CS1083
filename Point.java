/**
	*This class represents a point in a 2D array of ints
	*using an x and y value.
	*@author Michael Roscoe
**/
public class Point {
	/**
		*The x value representing the point's horizontal position 
		*going from left to right.
	**/
	private final int x;
	/**
		*The y value representing the vertical position of the point
		*going from top to bottom.
	**/
	private final int y;
	/**
		*Constructor for a Point, takes in the x and y values and creates
		*the point
		*@param xIn The x value of the point
		*@param yIn The y value of the point
	**/
	public Point (int xIn, int yIn) {
		x = xIn;
		y = yIn;
	}
	/**
		*Method to access the x value of the point
		*@return The x value of the point
	**/
	public int getX () {
		return x;
	}
	/**
		*Method to access the y value of the point
		*@return The y value of the point
	**/
	public int getY () {
		return y;
	}
}