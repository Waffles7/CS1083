import java.io.*;
/**
 * This class prints a quesiton pool.
 * @author Michael Roscoe
 * @author Adrian Bolesnikov
 */
public class ArchiveDisplay {

    public static void main(String[] args) {

        try {
            FileInputStream in = new FileInputStream("QuestionPool.dat");
            BufferedInputStream buffer = new BufferedInputStream(in);
            ObjectInputStream o = new ObjectInputStream(buffer);
            QuestionQueue queue = (QuestionQueue) o.readObject();
            System.out.println("Here are the archived questions...");
            if (!queue.isEmpty()) {
                System.out.print(queue);
            }
            o.close();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found - check source package.");
        }
        catch (IOException e) {
            System.out.println("Something went wrong - check file permissions and file location.");
        }


    }
}
