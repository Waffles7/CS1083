import java.util.NoSuchElementException;

/**
 * This class is a driver for the BoardGame
 * and BoardGameList classes.
 * @author Michael Roscoe
 */
public class BoardGameDriver {

    public static void main (String[] args) {
        System.out.println("Creating board games to test with.");
        BoardGame game1 = new BoardGame("Monopoly", 8);
        BoardGame game2 = new BoardGame("Yahtzee", 4);
        BoardGame game3 = new BoardGame("Connect Four", 2);
        BoardGame game4 = new BoardGame("Mousetrap", 6);
        BoardGame game5 = new BoardGame("Chess", 2);
        BoardGame game6 = new BoardGame("Snakes & Ladders", 3);
        System.out.println("\nGames were created:\n");
        System.out.println(game1);
        System.out.println(game2);
        System.out.println(game3);
        System.out.println(game4);
        System.out.println(game5);
        System.out.println(game6);

        System.out.println("\nCreating list and adding items.\n");
        BoardGameList list = new BoardGameList();
        list.add(game3);
        list.add(game5);
        list.add(game6);
        list.add(game1);
        list.add(game4);
        list.add(game2);

        System.out.println("Printing list as an array:\n");
        BoardGame[] array = list.getListAsArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println( "Game " + i + ": " + array[i]);
        }

        System.out.println("\nRemoving games from the list: ");
        System.out.println(game2);
        System.out.println(game1);
        System.out.println(game5);
        list.remove(game1);
        list.remove(game2);
        list.remove(game5);

        System.out.println("\nPrinting new list as an array: \n");
        array = list.getListAsArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println( "Game " + i + ": " + array[i]);
        }

        System.out.println("\nAdding new items to the list.\n");
        list.add(new BoardGame("Risk", 4));
        list.add(new BoardGame("Battleship", 2));

        System.out.println("Printing new list in reverse:");
        array = list.getReversedListAsArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println( "Game " + i + ": " + array[i]);
        }

        System.out.println("\nRemoving a game that is not in the list:");
        System.out.println(new BoardGame("Game of Life", 6));
        try {
            list.remove(new BoardGame("Game of Life", 6));
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nNumber of games in the list: " + list.getNumGames());
    }
}
