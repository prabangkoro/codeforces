import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) {
    int n = in.nextInt();
    in.nextLine();
    String input = in.nextLine();
    ArrayList<Character> goodString = new ArrayList<>();

    int first = 0;
    int second = 1;
    while (second < n) {
      char a = input.charAt(first);
      char b = input.charAt(second);
      if (a != b) {
        goodString.add(a);
        goodString.add(b);
        first = second + 1;
        second = first + 1;
      } else {
        second++;
      }
    }

    out.println((n - goodString.size()));
    for (Character good : goodString) {
      out.print(good);
    }

    in.close();
    out.close();
  }
}