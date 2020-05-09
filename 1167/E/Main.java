import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static int MAXN = (int) 1e6 + 10;

  public static void main(String[] args) {
    int n = in.nextInt();
    int x = in.nextInt();

    int[] prefMax = new int[n];
    // ArrayList<Integer>[] pos = new ArrayList[x + 1];
    LinkedList<Integer>[] pos = new LinkedList[x + 1];
    // for (int i = 0; i <= x; i++) {
    //   pos[i] = new LinkedList();
    // }

    for (int i = 0; i < n; i++) {
      int input = in.nextInt();
      if (pos[input] == null) pos[input] = new LinkedList();
      pos[input].add(i);
      prefMax[i] = Math.max(input, (i > 0 ? prefMax[i - 1] : input));
    }

    int p = 1;
    int last = n + 5;
    for (int i = x; i >= 1; --i) {
      if (pos[i] == null) {
        p = i;
        continue;
      }
      if (pos[i].getLast() > last) break;
      p = i;
      last = pos[i].getFirst(); 
    }

    long res = 0;
    last = -1;
    for (int i = 1; i <= x; i++) {
      int r = Math.max(i, p - 1);
      if (last != -1) r = Math.max(r, prefMax[last]);
      res += x - r + 1;
      if (pos[i] != null) {
        if (pos[i].getFirst() < last) break;
        last = pos[i].getLast();
      }
    }

    out.println(res);

    in.close();
    out.close();
  }
}