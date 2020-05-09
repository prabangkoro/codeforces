import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  static boolean isPowerOfTwo (int n) {
    return ((n & (n - 1)) == 0);
  }

  static int firstNonZeroBit (int x) {
    int counter = 0;
    while (x > 0) {
      x = x >> 1;
      counter++;
    }
    return counter;
  }

  static int checkBit (int x, int position) {
    return x & (1 << position);
  }

  static int firstZeroBit (int x, int bitStart) {
    int counter = bitStart;
    while (counter >= 0) {
      if (checkBit(x, counter) == 0) break;
      counter--;
    }
    return counter;
  }
  public static void main(String[] args) {
    int n = in.nextInt();

    if (isPowerOfTwo(n + 1)) {
      out.println(0);
    } else {
      int firstBitPosition = firstNonZeroBit(n);

      int turns = 0;
      LinkedList<Integer> answers = new LinkedList<>();
      // int counter = 10;
      while (!isPowerOfTwo(n + 1)) {
        if (turns % 2 == 0) {
          int power = firstZeroBit(n, firstBitPosition - 1) + 1;
          answers.add(power);
          int numberOfXORer = (1 << power) - 1;
          // out.println("number of XOR er: " + numberOfXORer);
          n = n ^ (numberOfXORer);
        } else {
          n++;
        }
        turns++;
        // counter--;
      }
      out.println(turns);
      Iterator<Integer> iterator = answers.iterator();
      while (iterator.hasNext()) {
        out.print(iterator.next() + " ");
      }
    }

    in.close();
    out.close();
  }
}