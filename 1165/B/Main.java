import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static int NMAX = 200010;
  
  public static void main(String[] args) {
    int n = in.nextInt();
    TreeSet<Integer> a = new TreeSet<>();
    int[] contests = new int[NMAX];

    for (int i = 0; i < n; i++) {
      int input = in.nextInt();
      a.add(input);
      contests[input]++;
    }

    int days = 0;
    Iterator<Integer> it = a.iterator();
    while (it.hasNext()) {
      int k = it.next();
      int kQty = contests[k];
      // out.println("k: " + k + " qty: " + kQty + " counter: " + counter);
      if (days < k) {
        days += Math.min((k - days), kQty);
      }
    }

    out.println(days);

    in.close();
    out.close();
  }
}