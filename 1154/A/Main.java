import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int[] u = new int[4];

    int abc = 0;
    int idxABC = 0;
    for (int i = 0; i < 4; i++) {
      u[i] = in.nextInt();
      if (abc < u[i]) {
        abc = Math.max(abc, u[i]);
        idxABC = i;
      }
    }

    for (int i = 0; i < 4; i++) {
      if (i == idxABC) continue;
      out.print((abc - u[i]) + " ");
    }

    in.close();
    out.close();
  }
}