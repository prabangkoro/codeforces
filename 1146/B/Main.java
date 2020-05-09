import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static List<Character> hateA = new ArrayList<>();
  static String input;
  
  static boolean isCopied () {
    boolean isCopied = true;
    for (int i = 0; i * 2 < hateA.size() && isCopied; i++) {
      if (hateA.get(hateA.size() / 2 - i - 1) != input.charAt(input.length() - 1 - i)) isCopied = false;
    }
    return isCopied;
  }
  public static void main(String[] args) {
    input = in.nextLine();

    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) != 'a') {
        hateA.add(input.charAt(i));
      }
    }
    if (isCopied()) {
      out.println("FOUND");
    } else {
      out.println(":(");
    }

    in.close();
    out.close();
  }
}