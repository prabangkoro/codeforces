import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static int d;
  static int k;

  static HashMap<Integer, Integer>[] road;
  static HashSet<Integer>[] deletedRoad;
  static boolean[] visited;
  static int[] depth;
  static boolean[] isPolice;
  // static int[][] roadIndex;

  static HashSet<Integer> deletedRoadIndex = new HashSet<>();
  static HashSet<Integer> police = new HashSet<>();

  static void bfs (int start) {
    visited[start] = true;

    for (int next : road[start].keySet()) {
      boolean deleted = false;
      if (deletedRoad[start] != null) deleted = deletedRoad[start].contains(next);
      
      if (!visited[next] && !deleted) {
        if (depth[start] >= d || isPolice[next]) {
          deleteRoad(start, next);

          if (deletedRoadIndex.size() == k - 1) break;
        } else {
          depth[next] = depth[start] + 1; 
          bfs(next);
        }
      }
    }
  }

  static void deleteRoad (int u, int v) {
    if (deletedRoad[u] == null) deletedRoad[u] = new HashSet<>();
    if (deletedRoad[v] == null) deletedRoad[v] = new HashSet<>();
    deletedRoad[u].add(v);
    deletedRoad[v].add(u);

    deletedRoadIndex.add(road[u].get(v));
  }
  
  public static void main(String[] args) {
    int n = in.nextInt();
    k = in.nextInt();
    d = in.nextInt();

    depth = new int[n];
    road = new HashMap[n];
    visited = new boolean[n];
    deletedRoad = new HashSet[n];
    isPolice = new boolean[n];
    // roadIndex = new int[n][n];

    for (int i = 0; i < k; i++) {
      int input = in.nextInt() - 1;
      police.add(input);
      isPolice[input] = true;
    }
    
    for (int i = 0; i < n - 1; i++) {
      int u = in.nextInt() - 1;
      int v = in.nextInt() - 1;

      if (road[u] == null) road[u] = new HashMap<>();
      if (road[v] == null) road[v] = new HashMap<>();
      road[u].put(v, i + 1);
      road[v].put(u, i + 1);
    }


    for (Integer pol : police) {
      if (deletedRoadIndex.size() == k - 1) break;
      bfs(pol);
    }

    // for (int i = 0; i < n; i++) {
    //   out.println("i: " + i + " depth: " + depth[i]);
    // }

    out.println(deletedRoadIndex.size());
    for (Integer idx : deletedRoadIndex) {
      out.print(idx + " ");
    }

    in.close();
    out.close();
  }
}