import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int t = in.nextInt();

    for (int i = 0; i < t; i++) {
      Long n = in.nextLong();
      Long a = in.nextLong();
      Long b = in.nextLong();

      if (2 * a < b) {
        long p = n * a;
        out.println(p);
      } else {
        long p = 0;
        if (n % 2 != 0) {
          n--;
          p = a;
        }
        p += (n / 2) * b;
        out.println(p);
      }
    }

    in.close();
    out.close();
  }
}