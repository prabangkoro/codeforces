import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    in.nextLine();
    String input = in.nextLine();

    boolean OK = false;
    char prev = input.charAt(0);
    for (int i = 1; i < n && !OK; i++) {
      if (prev > input.charAt(i)) {
        OK = true;
        out.println("YES");
        out.println(i + " " + (i + 1));
      }
      prev = input.charAt(i);
    }

    if (!OK) {
      out.println("NO");
    }

    in.close();
    out.close();
  }
}