import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int h = in.nextInt();

    int[] bottles = new int[n];
    for (int i = 0; i < n; i++) {
      bottles[i] = in.nextInt();
    }
    
    boolean touched_top = false;
    int k = 0;
    for (int i = 1; i <= n && !touched_top; i++) {
      Arrays.sort(bottles, 0, i);
      for (int j = 0; j < n; j++) {
        out.print(bottles[j] + " ");
      }
      out.println();
      int total_height = 0;
      for (int j = i - 1; j >= 0; j -= 2) {
        int shelf = 0;
        if (j > 0) {
          shelf = Math.max(bottles[j], bottles[j - 1]);
          out.println("b1: " + bottles[j] + " b2: " + bottles[j - 1]);
        } else {
          shelf = bottles[j];
          out.println("b1: " + bottles[j]);
        }
        out.println("total h: " + total_height + " shelf h: " + shelf);
        if ((total_height + shelf) <= h) {
          total_height += shelf;
          k = i;
        } else {
          touched_top = true;
          break;
        }
      }
    }
    out.println(k);

    in.close();
    out.close();
  }
}