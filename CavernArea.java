/**
	*This program reads in a two-dimensional array to represent an 
	*underground storage facility, and outputs the area of the cavern 
	*that is accessible
	*@author Michael Roscoe
**/
import java.util.*;
public class CavernArea {

	/**
		*An array representing the cross-section of the cave.
	**/
	private int[][] cavern;

	/**
		*This method constructs a cavern by taking in height and width,
		*the cavern is filled using a seperate method.
		*@param height The height of the cavern to be represented
		*@param width The width of the cavern to be represented
	**/
	public CavernArea (int height, int width) {

		cavern = new int[height][width];
		this.fillCavern();
	}
	/**
		*This method takes in a two dimensional array representing
		*the cavern, and returns the accessible area in int form.
		*@return The area accessible in the cavern
	**/
	public int findArea () {
		int finalArea = 0;
		this.search();
		for (int i = 0; i < cavern.length; i++) {
			for (int j = 0; j < cavern[i].length; j++) {
				if (cavern[i][j] == 8) {
					finalArea++;
				}
			}
		}
		return finalArea;
	}
	/**
		*This method prints out the contents of the two-dimensional array,
		*in other words it shows a diagram of the cavern depicted.
		*@return The String representing the cavern
	**/
	public String toString () {
		String s = "";
		for (int i = 0; i < cavern.length; i++) {
			for (int j = 0; j < cavern[i].length; j++) {
				s += cavern[i][j];
			}
			s += "\n";
		}
		return s;
	}
	/**
		*This method fills the two-dimensional array taking in data
		*from the user.
	**/
	private void fillCavern () {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < cavern.length; i++) {
			String s = sc.nextLine();
			for (int k = 0; k < s.length(); k++) {
				char ch = s.charAt(k);
				cavern[i][k] = (ch-48);
			}
		}
	}
	/**
		*This method searches through the cave from the entrance
		*and marks the open cavern attatched to the valve by marking
		*the array with 8's
	**/
	private void search () {
		int x = 0;
		int y = 0;
		//Finds the valve of the cavern
		for (int i = 0; i < cavern[0].length; i++) {
			if (cavern[0][i] == 0) {
				x = i;
				cavern[0][i] = 8;
			}
		}
		//Creates a list of points to be checked in the future, starting with valve
		ArrayList<Point> toCheck = new ArrayList<Point>(1);
		toCheck.add(new Point(x,y));

		//Mark every point on the list, and check all around them for other 0's
		while (!toCheck.isEmpty()) {
			Point currentPoint = toCheck.get(0);
			x = currentPoint.getX();
			y = currentPoint.getY();
			cavern[y][x] = 8;
			if (x > 0 && cavern[y][x-1] == 0) {
				toCheck.add(new Point(x-1,y));
			}
			if (x < (cavern[y].length -1) && cavern[y][x+1] == 0) {
				toCheck.add(new Point(x+1,y));
			}
			if (y > 0 && cavern[y-1][x] == 0) {
				toCheck.add(new Point(x, y-1));
			}
			if (y < (cavern.length -1) && cavern[y+1][x] == 0) {
				toCheck.add(new Point(x, y+1));
			}
			toCheck.remove(0);
		}
	}


}