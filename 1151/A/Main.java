import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    in.nextLine();
    String dna = in.nextLine();

    int[] dnaNumber = new int[n];
    for (int i = 0; i < n; i++) {
      dnaNumber[i] = dna.charAt(i) - 'A';
    }

    int A = 'A' - 'A';
    int C = 'C' - 'A';
    int T = 'T' - 'A';
    int G = 'G' - 'A';
    int minOperations = 10000000;
    for (int i = 0; i < n - 3; i++) {
      int distA = Math.abs(dnaNumber[i] - A);
      int distC = Math.abs(dnaNumber[i + 1] - C);
      int distT = Math.abs(dnaNumber[i + 2] - T);
      int distG = Math.abs(dnaNumber[i + 3] - G);
      int minA = Math.min(distA, (26 - distA));
      int minC = Math.min(distC, (26 - distC));
      int minT = Math.min(distT, (26 - distT));
      int minG = Math.min(distG, (26 - distG));
      // out.println("T: " + (26 - (T - dnaNumber[i + 2])));
      // out.println("i: " + i);
      // out.println("abcd: " + dnaNumber[i] + "," + dnaNumber[i + 1] + "," + dnaNumber[i + 2] + "," + dnaNumber[i + 3]);
      // out.println("min A: " + minA);
      // out.println("min C: " + minC);
      // out.println("min T: " + minT);
      // out.println("min G: " + minG);
      minOperations = Math.min(minA + minC + minT + minG, minOperations);
    }

    out.println(minOperations);

    in.close();
    out.close();
  }
}