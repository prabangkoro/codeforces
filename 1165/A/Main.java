import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int x = in.nextInt();
    int y = in.nextInt();
    in.nextLine();
    String input = in.nextLine();

    int step = 0;
    for (int i = 0; i < x; i++) {
      char digit = input.charAt(n - 1 - i);
      if (i == y && digit == '1') continue;
      if (i != y && digit == '0') continue;
      // out.println("i: " + i);
      step++;
    }

    out.println(step);

    in.close();
    out.close();
  }
}