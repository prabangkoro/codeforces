import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) {
    int n = in.nextInt();

    int[] conj_a = new int[n];
    int[] b = new int[200001];

    for (int i = 0; i < n; i++) {
      int input = in.nextInt();
      conj_a[i] = n - input;
    }

    for (int i = 0; i < n; i++) {
      int input = in.nextInt();
      b[input]++;
    }

    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      if (b[conj_a[i]] > 0) {
        b[conj_a[i]]--;
      } else {
        int counter = 1;
        while (counter < n) {
          if (b[(conj_a[i] + counter) % n] > 0) {
            ans[i] = counter;
            b[(conj_a[i] + counter) % n]--;
            break;
          }
          counter++;
        }
      }
    }

    for (int answer : ans) {
      out.print(answer + " ");
    }

    in.close();
    out.close();
  }
}