import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import javafx.util.Pair;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static int vertices;
  static int edges;
  static HashMap<Integer, Integer> graph[];
  static long distance[];
  static int prev[];
  static LinkedList<Integer> shortestPath;
  static boolean noPath = false;

  static void dijkstra (int source, int target) {
    LinkedList<Integer> Q = new LinkedList<>();
    
    distance = new long[vertices];
    prev = new int[vertices];
    for (int i = 0; i < vertices; i++) {
      distance[i] = Long.MAX_VALUE;
      prev[i] = -1;
      Q.add(i);
    }
    distance[source] = 0;

    while (!Q.isEmpty()) {
      Iterator<Integer> iterator = Q.iterator();
      int u = Q.peekFirst();
      int uIndex = 0;
      int index = 0;
      while (iterator.hasNext()) {
        int v = iterator.next();
        if (distance[v] < distance[u]) {
          u = v;
          uIndex = index;
        }
        index++;
      }

      Q.remove(uIndex);
      if (u == target) break;

      for (Integer v : graph[u].keySet()) {
        long newDist = graph[u].get(v) + distance[u];
        if (newDist < distance[v]) {
          distance[v] = newDist;
          prev[v] = u;
        }
      }
    }
  }

  static void calculateShortestPath (int source, int target) {
    shortestPath = new LinkedList<>();
    int v = target;
    while (v != source) {
      shortestPath.push(v + 1);
      v = prev[v];
      if (v == -1) {
        noPath = true;
        break;
      }
    }
    shortestPath.push(source + 1);
  }

  public static void main(String[] args) {
    vertices = in.nextInt();
    edges = in.nextInt();

    graph = new HashMap[vertices];
    for (int i = 0; i < vertices; i++) {
      graph[i] = new HashMap<>();
    }

    for (int i = 0; i < edges; i++) {
      int u = in.nextInt() - 1;
      int v = in.nextInt() - 1;
      int weight = in.nextInt();

      graph[u].put(v, weight);
      graph[v].put(u, weight);
    }

    dijkstra(0, vertices - 1);
    calculateShortestPath(0, vertices - 1);

    // for (int i = 0; i < prev.length; i++) {
    //   out.println("i: " + (i + 1) + " prev: " + (prev[i] + 1));
    // }

    if (noPath) {
      out.println(-1);
    } else {
      Iterator<Integer> iterator = shortestPath.iterator();
      while (iterator.hasNext()) {
        out.print(iterator.next() + " ");
      }
    }

    in.close();
    out.close();
  }
}