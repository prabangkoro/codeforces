import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static int MAXN = (int) 5e5 + 1;
  static Random rand = new Random();
  static int[] root = new int[MAXN];
  static int[] quantity = new int[MAXN];

  static void makeSet (int u) {
    root[u] = u;
  }

  static int getRoot (int u) {
    if (root[u] == u) return u;
    root[u] = getRoot(root[u]);
    return root[u];
  }

  static void mergeUnion (int u, int v) {
    int rootU = getRoot(u);
    int rootV = getRoot(v);
    if (rootU != rootV) {
      if (rand.nextInt(2) % 2 == 0) root[rootU] = rootV;
      else root[rootV] = rootU;
    }
  }
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();

    for (int i = 1; i <= n; i++) {
      makeSet(i);
    }
    for (int i = 0; i < m; i++) {
      int k = in.nextInt();
      if (k == 0) continue;
      int par = in.nextInt();
      for (int j = 1; j < k; j++) {
        mergeUnion(par, in.nextInt());
      }
    }

    for (int i = 1; i <= n; i++) {
      quantity[getRoot(i)]++;
    }

    for (int i = 1; i <= n; i++) {
      out.print(quantity[root[i]] + " ");
    }
    out.println();

    in.close();
    out.close();
  }
}