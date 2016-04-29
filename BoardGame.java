public class BoardGame implements Comparable<BoardGame> {
    private String title;
    private int maxPlayers;

    public BoardGame (String titleIn, int playersIn) {
        title = titleIn;
        maxPlayers = playersIn;
    }

    public String toString () {
        return title + " [max. " + maxPlayers + "players]";
    }

    public int compareTo(BoardGame g) {
        int value;
        if (this.maxPlayers > g.maxPlayers) {
            value = 1;
        } else if (this.maxPlayers < g.maxPlayers) {
            value = -1;
        } else {
            value = this.title.compareTo(g.title);
        }
        return value;
    }
}