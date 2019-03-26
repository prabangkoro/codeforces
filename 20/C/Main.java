import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) {
    int NVertices = in.nextInt();
    int NEdges = in.nextInt();

    long distance[] = new long[NVertices];
    int weight[][] = new int[NVertices][NVertices];
    for (int i = 0; i < NEdges; i++) {
      int u = in.nextInt() - 1;
      int v = in.nextInt() - 1;
      int w = in.nextInt();
      weight[u][v] = w;
      weight[v][u] = w;
    }

    for (int i = 0; i < NVertices; i++) {
      for (int j = 0; j < NVertices; j++) {
        out.print(weight[i][j] + " ");
      }
      out.println();
    }

    boolean visited[] = new boolean[NVertices];
    for (int i = 1; i < NVertices; i++) {
      for (int j = 0; j < NVertices - i; j++) {
        distance[j] = Math.min(distance[j], distance[i] + weight[i][j]);
      }
    }

    out.println("distance");
    for (int i = 0; i < NVertices; i++) {
      out.print(distance[i] + " ");
    }

    in.close();
    out.close();
  }
}