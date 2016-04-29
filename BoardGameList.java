import java.util.NoSuchElementException;

/**
 This class represents a doubly linked list of board games;
 NOTE: You may NOT use the java.util.LinkedList class.
 @author Michael Roscoe
 **/
public class BoardGameList {
    /**
     The first node in the list.
     **/
    private GameNode firstNode;

    /**
     The last node in the list.
     **/
    private GameNode lastNode;

    /**
     The number of games in the list.
     **/
    private int numGames;

    /**
     Creates an empty list.
     **/
    public BoardGameList() {
        firstNode = null;
        lastNode = null;
        numGames = 0;
    }

    /**
     Adds a new node representing the specified board game at
     the appropriate position in the list; proper ordering of the
     board games must be maintained (i.e. they must always be
     sorted in ascending order).
     @param gameIn The board game to be included in the new node.
     **/
    public void add(BoardGame gameIn) {
        GameNode newNode = new GameNode(gameIn);
        if (firstNode == null || numGames == 0) { //If nothing in the list already
            firstNode = newNode;
            lastNode = newNode;
            numGames++;
        } else if (gameIn.compareTo(lastNode.game) > 0) { //If biggest so far
            lastNode.next = newNode;
            newNode.previous = lastNode;
            lastNode = newNode;
            numGames++;
        } else if (gameIn.compareTo(firstNode.game) < 0) { //If smallest so far
            firstNode.previous = newNode;
            newNode.next = firstNode;
            firstNode = newNode;
            numGames++;
        } else { //If somewhere in between
            GameNode currentNode = lastNode;
            while (currentNode != null) {
                if (newNode.game.compareTo(currentNode.game) > 0) { //If new larger than current
                    newNode.previous = currentNode;
                    newNode.next = currentNode.next;
                    currentNode.next.previous = newNode;
                    currentNode.next = newNode;
                    numGames++;
                    break;
                }
                currentNode = currentNode.previous;
            }
        }
    }

    /**
     Remove from this list a node containing the specified board game.
     @param gameIn The game to be removed.
     @throws java.util.NoSuchElementException
     **/
    public void remove(BoardGame gameIn) {
        if (firstNode == null) { //List is empty
            throw new NoSuchElementException("All items searched, specified game not found.");
        } else if (firstNode.game.compareTo(gameIn) == 0) { //First node contains game
            firstNode = firstNode.next;
            firstNode.previous = null;
            numGames--;
        } else if (lastNode.game.compareTo(gameIn) == 0) { //Last node contains game
            lastNode.previous.next = null;
            lastNode = lastNode.previous;
            numGames--;
        } else { //Game might be in the middle
            GameNode currentNode = firstNode.next;
            while (currentNode != null) {
                if (currentNode.game.compareTo(gameIn) == 0) { //Current node contains game
                    currentNode.previous.next = currentNode.next;
                    currentNode.next.previous = currentNode.previous;
                    numGames--;
                    break;
                }
                currentNode = currentNode.next;
            }
            if (currentNode == null) {
                throw new NoSuchElementException("All items searched, specified game not found.");
            }
        }
    }

    /**
     Returns the number of games currently stored in the list.
     @return the number of games
     **/
    public int getNumGames() {
        return numGames;
    }

    /**
     Creates and returns an array containing all of the BoardGames
     in this list, in ascending order.
     @return the list as an array
     **/
    public BoardGame[] getListAsArray() {
        BoardGame[] list = new BoardGame[numGames];
        GameNode currentNode = firstNode;
        int index = 0;
        while (currentNode != null) {
            list[index] = currentNode.game;
            currentNode = currentNode.next;
            index++;
        }
        return list;
    }

    /**
     Creates and returns an array containing all of the BoardGames
     in this list, in descending order.
     @return the list (in reverse order) as an array
     **/
    public BoardGame[] getReversedListAsArray() {
        BoardGame[] list = new BoardGame[numGames];
        GameNode currentNode = firstNode;
        int index = numGames -1;
        while (index > -1) {
            list[index] = currentNode.game;
            currentNode = currentNode.next;
            index--;
        }
        return list;
    }

    /**
     An inner class that represents a node in the board game list;
     the public variables are accessed by the BoardGameList class.
     **/
    private class GameNode {
        /**
         The BoardGame referenced by this node.
         **/
        public BoardGame game;

        /**
         The next node in the list.
         **/
        public GameNode next;

        /**
         The previous node in the list.
         **/
        public GameNode previous;

        /**
         Creates a node.
         @param gameIn The board game to be represented by this node.
         **/
        public GameNode (BoardGame gameIn) {
            game = gameIn;
            next = null;
            previous = null;
        }

    }
}
