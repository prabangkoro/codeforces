import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static int MAXN = (int) 1e6 + 10;
  static ArrayList<Integer>[] pos = new ArrayList[MAXN];

  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();
    
    for (int i = 0; i < MAXN; i++) {
      pos[i] = new ArrayList<>();
    }
    
    int[] a = new int[n];
    int[] prefMax = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      pos[a[i]].add(i);
      prefMax[i] = Math.max(a[i], (i > 0 ? prefMax[i - 1] : a[i]));
    }

    for (int i = 0; i < n; i++) {
      out.println("i: " + i + " prefMax: " + prefMax[i]);
    }

    in.close();
    out.close();
  }
}