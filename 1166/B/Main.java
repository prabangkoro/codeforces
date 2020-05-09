import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();

    if (n < 25) {
      out.println(-1);
    } else {
      int a = 1;
      int b = 1;
      for (int i = 5; i * i <= n; i++) {
        if (n % i != 0) continue;
        a = i;
        b = n / i;
        break;
      }
      if (a == 1 && b == 1) {
        out.println(-1);
      } else {
        int counter = 0;
        int shift = (b % 5 == 0 ? 1 : 0);
        char[] vowels = new char[]{'a', 'i', 'u', 'e', 'o'};
        for (int i = 0; i < a; i++, counter += 1 + shift) {
          for (int j = 0; j < b; j++, counter++) {
            counter %= 5;
            out.print(vowels[counter]);
          }
        }
        out.println();
      }
    }

    in.close();
    out.close();
  }
}