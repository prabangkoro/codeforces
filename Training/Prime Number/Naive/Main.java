import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static boolean prime (int n) {
    boolean prime = true;
    for (int i = 2; i* i <= n && prime; i++) {
      if (n % i == 0) prime = false;
    }
    return prime;
  }
  public static void main(String[] args) {
    int n = in.nextInt();

    long start = System.currentTimeMillis();

    for (int i = 1; i <= n; i++) {
      if (prime(i)) {
        out.print(i + ", ");
      }
    }
    
    long end = System.currentTimeMillis();
    out.println("elapsed time: " + (end - start) + " ms");

    in.close();
    out.close();
  }
}