import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    String input = in.nextLine();

    int countA = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == 'a') countA++;
    }

    out.println(Math.min(input.length(), (countA * 2 - 1)));

    in.close();
    out.close();
  }
}