import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static int[] names = new int[26];
  
  static int combination (int n) {
    return n * (n - 1) / 2;
  }
  
  public static void main(String[] args) {
    int n = in.nextInt();
    in.nextLine();

    for (int i = 0; i < n; i++) {
      String name = in.nextLine();
      names[name.charAt(0) - 'a']++;
    }

    int ans = 0;
    for (int i = 0; i < 26; i++) {
      int a = names[i] / 2;
      int b = names[i] - a;
      ans += combination(a) + combination(b);
    }

    out.println(ans);

    in.close();
    out.close();
  }
}