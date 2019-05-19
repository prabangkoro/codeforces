import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    in.nextLine();
    String sequence = in.nextLine();

    int[] score = new int[n];
    int current = 0;
    int max = 0;
    for (int i = 0; i < n; i++) {
      if (sequence.charAt(i) == '(') {
        score[i] = ++current;
      } else {
        score[i] = current--;
      }
      max = Math.max(max, current);
    }

    for (int i = 0; i < n; i++) {
      int ans = score[i] > (max / 2) ? 1 : 0;
      out.print(ans);
    }

    in.close();
    out.close();
  }
}