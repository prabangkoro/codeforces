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

  static HashMap<Integer, Integer>[] graphs;
  static long distances[];
  static int path[];
  static LinkedList<Integer> shortest;
  static boolean NO_PATH = false;

  static void dijkstra (int s, int vertices, int edges) {
    distances = new long[vertices];
    path = new int[vertices];
    boolean marked[] = new boolean[vertices];

    Arrays.fill(distances, Long.MAX_VALUE);
    Arrays.fill(path, -1);

    distances[s] = 0;
    for (int i = 0; i < vertices; i++) {
      int currentVertex = -1;
      // find min path
      for (int j = 0; j < vertices; j++) {
        if (!marked[j] && (currentVertex == -1 || distances[j] < distances[currentVertex]))
          currentVertex = j;
      }
      marked[currentVertex] = true;

      for (Integer v : graphs[currentVertex].keySet()) {
        int to = v;
        int weight = graphs[currentVertex].get(v);

        if (distances[to] > (distances[currentVertex] + weight)) {
          distances[to] = distances[currentVertex] + weight;
          path[to] = currentVertex;
        }
      }
      for (int j = 0; j < vertices; j++) {
        if (graphs[j].containsKey(currentVertex)) {
          int to = j;
          int weight = graphs[j].get(currentVertex);

          if (distances[to] > (distances[currentVertex] + weight)) {
            distances[to] = distances[currentVertex] + weight;
            path[to] = currentVertex;
          }
        }
      }
    }
  }

  static void shortestPath (int source, int target) {
    shortest = new LinkedList<>();

    Integer prev = target;
    while (prev != source) {
      shortest.push(prev + 1);
      prev = path[prev];
      if (prev == -1) {
        NO_PATH = true;
        break;
      }
    }
    shortest.push(source + 1);
  }

  public static void main(String[] args) {
    int NVertices = in.nextInt();
    int NEdges = in.nextInt();
    
    graphs = new HashMap[NVertices];
    for (int i = 0; i < NVertices; i++) {
      graphs[i] = new HashMap<>();
    }

    for (int i = 0; i < NEdges; i++) {
      int u = in.nextInt() - 1;
      int v = in.nextInt() - 1;
      int weight = in.nextInt();

      graphs[u].put(v, weight);
      // graphs[v].put(u, weight);
    }

    dijkstra(0, NVertices, NEdges);
    shortestPath(0, NVertices - 1);

    if (!NO_PATH) {
      Iterator<Integer> iterator = shortest.iterator();
      while (iterator.hasNext()) {
        out.print(iterator.next() + " ");
      }
      // for (Integer currentPath : shortest) {
      //   out.print(currentPath + " ");
      // }
    } else {
      out.println(-1);
    }

    in.close();
    out.close();
  }
}