import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();

    int misteries[] = new int[n];
    for (int i = 0; i < n; i++) {
      misteries[i] = in.nextInt()  - 1;
    }
    
    int sumDay = 0;
    int pint = 0;
    int unsolvedMistery = 0;
    while (pint < n) {
      unsolvedMistery = Math.max(unsolvedMistery, misteries[pint]);
      if (unsolvedMistery == pint) {
        sumDay++;
      }
      pint++;
    }

    out.println(sumDay);

    in.close();
    out.close();
  }
}