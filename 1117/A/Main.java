import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();

    long[] a = new long[n];
    long max = 0;
    for (int i = 0; i < n; i++) {
      long input = in.nextLong();
      a[i] = input;
      max = Math.max(input, max);
    }

    long lengthMax = 1;
    long counter = 1;
    for (int i = 0; i < n; i++) {
      if (a[i] == max) {
        counter = 0;
        while (i < n && a[i] == max) {
          counter++;
          i++;
        }
        lengthMax = Math.max(lengthMax, counter);
      }
    }

    out.println(lengthMax);

    in.close();
    out.close();
  }
}