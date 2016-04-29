import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Driver program for questionqueue
 * @author Michael Roscoe
 * @author Adrian Bolesnikov
 */
public class Moderator {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        QuestionQueue queue = new QuestionQueue();
        String s = "Moderator options:\nN = Add a new question\nA = Ask current question\nP = Pass on current question" +
                "\nQ = quit";

        System.out.println("\nNo submitted questions pending.");
        System.out.println(s);
        System.out.print("Enter your choice: ");
        char ch = sc.nextLine().toUpperCase().charAt(0);

        while (ch != 'Q') {
            switch (ch) {
                case 'N':
                    System.out.println("Enter question:");
                    String question = sc.nextLine();
                    System.out.println("Submitted by:");
                    String submitter = sc.nextLine();
                    queue.enqueue(new Question(question, submitter));
                    break;
                case 'A':
                    System.out.println("Question asked.\n");
                    try {
                        queue.dequeue();
                    }
                    catch (NoSuchElementException e) {
                        System.out.println("Error - No question pending.");
                    }
                    break;
                case 'P':
                    System.out.println("Passed.\n");
                    try {
                        queue.enqueue(queue.dequeue());
                    }
                    catch (NoSuchElementException e) {
                        System.out.println("Error - No question pending.");
                    }
                    break;
                default:
                    System.out.println("Incorrect input, character not available choice - please enter valid input.");
            }
            if (queue.isEmpty()) {
                System.out.println("\nNo submitted questions pending.");
            } else {
                System.out.println("\nCurrent question: " + queue.peek());
            }
            System.out.println(s);
            System.out.print("Enter your choice: ");
            ch = sc.nextLine().toUpperCase().charAt(0);
        }
        try {
            FileOutputStream out = new FileOutputStream("QuestionPool.dat");
            BufferedOutputStream buffer = new BufferedOutputStream(out);
            ObjectOutputStream o = new ObjectOutputStream(buffer);
            o.writeObject(queue);
            o.flush();
            out.close();
            System.out.println("Unused questions archived to: QuestionPool.dat");
        }
        catch (IOException e) {
            System.out.println("Something went wrong - check file permissions and file location.");
        }

    }
}
