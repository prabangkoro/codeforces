import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();

    int weight = 0;
    for (int i = 1; i < n - 1; i++) {
      weight += ((i + 1) * (i + 2));
    }

    out.println(weight);

    in.close();
    out.close();
  }
}