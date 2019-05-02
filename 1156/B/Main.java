import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static void solve (String word)
  {
    char[] chars = word.toCharArray();
    Arrays.sort(chars);
    int half = chars.length / 2;
    char[] merged = new char[chars.length];
    for (int i = 0; i * 2 < chars.length; i++) {
      out.println("i: " + i);
      merged[2 * i] = chars[half + i];
      merged[2 * i + 1] =  chars[i];
    }
    String charsString = new String(chars);
    String mergedString = new String(merged);
    out.println("chars: " + charsString);
    // out.println("merged: " + mergedString + "\n");
  }
  public static void main(String[] args) {
    int n = in.nextInt();
    in.nextLine();

    String[] words = new String[n];
    for (int i = 0; i < n; i++) {
      words[i] = in.nextLine();
    }

    for (int i = 0; i < n; i++) {
      solve(words[i]);
    }

    in.close();
    out.close();
  }
}