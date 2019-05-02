import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();

    int[] figures = new int[n];
    for (int i = 0; i < n; i++) {
      figures[i] = in.nextInt();
    }

    boolean inf = false;
    int touched = 0;
    for (int i = 1; i < n && !inf; i++) {
      int prev = figures[i - 1];
      int curr = figures[i];
      if ((prev == 1 && curr == 2) ||
          (prev == 2 && curr == 1)) touched += 3;
      else if ((prev == 1 && curr == 3) ||
                (prev == 3 && curr == 1)) touched += 4;
      else inf = true;
    }

    if (inf) {
      out.println("Infinite");
    } else {
      out.println("Finite");
      out.println(touched);
    }

    in.close();
    out.close();
  }
}