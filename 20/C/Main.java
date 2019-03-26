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
    int weight[][] = new int[NEdges][NEdges];
    for (int i = 0; i < NEdges; i++) {
      int u = in.nextInt() - 1;
      int v = in.nextInt() - 1;
      int w = in.nextInt();
      weight[u][v] = w;
      weight[v][u] = w;
    }

    boolean visited[] = new boolean[NEdges];
    for (int i = 0; i < NEdges; i++) {
      visited[i] = true;
      for (int j = 1; j < NEdges; j++) {
        if (weight[i][j] > 0) {
          if (distance[j] == 0) {
            distance[j] = weight
          }
        }
      }
    }

    in.close();
    out.close();
  }
}