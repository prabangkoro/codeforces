import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) {
    int n = in.nextInt();

    long start = System.currentTimeMillis();
    int lp[] = new int[n + 1];
    ArrayList<Integer> pr = new ArrayList<>();

    for (int i = 2; i <= n; i++) {
      if (lp[i] == 0) {
        lp[i] = i;
        pr.add(i);
      }
      for (int j = 0; j < pr.size() && pr.get(j) <= lp[i] && i * pr.get(j) <= n; j++) {
        lp[i * pr.get(j)] = pr.get(j);
      }
    }

    for (Integer prime : pr) {
      out.print(prime + ", ");
    }
    long end = System.currentTimeMillis();
    out.println("elapsed time: " + (end - start) + " ms");

    in.close();
    out.close();
  }
}