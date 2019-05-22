import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static boolean[] visited;
  static ArrayList<Integer>[] road;
  static int[] depth;
  static int d;

  static void bfs (int start) {
    visited[start] = true;

    for (int next : road[start]) {
      if (!visited[next]) {
        depth[next] = depth[start] + 1; 
        bfs(next);
      }
    }
  }
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int k = in.nextInt();
    d = in.nextInt();

    depth = new int[n];

    int[] police = new int[k];
    for (int i = 0; i < k; i++) {
      police[i] = in.nextInt();
    }
    
    road = new ArrayList[n];
    for (int i = 0; i < n - 1; i++) {
      int u = in.nextInt() - 1;
      int v = in.nextInt() - 1;
      if (road[u] == null) road[u] = new ArrayList<>();
      if (road[v] == null) road[v] = new ArrayList<>();
      road[u].add(v);
      road[v].add(u);
    }

    visited = new boolean[n];
    bfs(2);

    for (int i = 0; i < n; i++) {
      out.println("i: " + i + " depth: " + depth[i]);
    }


    in.close();
    out.close();
  }
}