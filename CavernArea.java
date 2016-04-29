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
     *the cavern is filled using a separate method.
     *@param height The height of the cavern to be represented
     *@param width The width of the cavern to be represented
     **/
    public CavernArea (int height, int width) {

        cavern = new int[height][width];
        this.fillCavern();
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
     * This method finds the first opening to the cave, and then calls the search
     * method on every other 0 attached to the opening
     * @return The total area of the cave
     **/
    public int findArea () {
        int x = 0;
        int y = 0;
        //Finds the valve of the cavern
        for (int i = 0; i < cavern[0].length; i++) {
            if (cavern[0][i] == 0) {
                x = i;
                cavern[0][i] = 8;
                break;
            }
        }
        return this.findArea(cavern, new Point(x,y));
    }
    /**
     * Marks a cavern point as an 8, and searches every point around it
     * that is a 0.
     * @param cavern The cavern to be searched
     * @param p The point to be looked at
     * @return The area found during this search
     */
    private int findArea (int[][] cavern, Point p) {
        int x = p.getX();
        int y = p.getY();
        cavern[y][x] = 8;
        int result = 1;
        if (x > 0 && cavern[y][x-1] == 0) {
            result += this.findArea(cavern ,new Point(x-1,y));
        }
        if (x < (cavern[y].length -1) && cavern[y][x+1] == 0) {
            result += this.findArea(cavern, new Point(x+1,y));
        }
        if (y > 0 && cavern[y-1][x] == 0) {
            result += this.findArea(cavern, new Point(x, y-1));
        }
        if (y < (cavern.length -1) && cavern[y+1][x] == 0) {
            result += this.findArea(cavern, new Point(x, y+1));
        }
        return result;
    }
}