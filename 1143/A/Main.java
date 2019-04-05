import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();

    int lastLeft = 0;
    int lastRight = 0;
    for (int i = 0; i < n; i++) {
      int input = in.nextInt();
      if (input == 0) {
        lastLeft = i + 1;
      } else {
        lastRight = i + 1;
      }
    }

    out.println(Math.min(lastLeft, lastRight));

    in.close();
    out.close();
  }
}