import java.util.Scanner;
// *******************************************************************
// TestFib.java
//
// A simple driver that uses the Fib class to compute the
// nth element of the Fibonacci sequence.
// *******************************************************************
public class TestFib {
   public static void main(String[] args) {
      int n, fib;
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter an integer: ");
      n = scan.nextInt();
      fib = Fib.fib2(n);
      System.out.println("Fib(" + n + ") is " + fib);
      fib = Fib.fib1(n);
      System.out.println("Fib(" + n + ") is " + fib);
   }
}

// *******************************************************************
// Fib.java
//
// A utility class that provide methods to compute elements of the
// Fibonacci sequence.
// *******************************************************************

class Fib {
   //------------------------------------------------------------------
   // Recursively computes fib(n)
   //------------------------------------------------------------------
   public static int fib1(int n) {
      int answer;
      if (n == 0) {
         answer = 0;
      } else if (n == 1) {
         answer = 1;
      } else {
         answer = fib1(n-1) + fib1(n-2);
      }
      return answer;
   }
   public static int fib2(int n) {
      int answer;
      if (n == 0) {
         answer = 0;
      } else if (n ==1) {
         answer = 1;
      } else {

         int[] array = new int[n + 1];
         array[0] = 0;
         array[1] = 1;
         for (int i = 2; i < array.length; i++) {
            array[i] = array[i-2] + array[i-1];
         }
         answer = array[array.length-1];
      }  
      return answer;
   }
}
