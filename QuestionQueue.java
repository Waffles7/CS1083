import java.io.Serializable;
import java.util.LinkedList;

/**
 * This class represents a queue data structure for question objects.
 * @author Michael Roscoe
 * @author Adrian Bolesnikov
 */
public class QuestionQueue implements Serializable {

    private LinkedList<Question> list;

    public QuestionQueue () {
        list = new LinkedList<>();
    }

    public void enqueue (Question q) {
        list.add(q);
    }

    public Question dequeue () {
        return list.removeFirst();
    }

    public Question peek () {
        return list.peekFirst();
    }

    public boolean isEmpty () {
        return list.isEmpty();
    }

    public String toString () {
        String s = "";
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                s += i + 1 + ". " + list.get(i).toString() + "\n";
                i++;
            }
        }
        return s;
    }
}
