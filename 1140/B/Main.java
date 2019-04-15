import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();

    for (int i = 0; i < n; i++) {
      int length = in.nextInt();
      in.nextLine();
      String sequence = in.nextLine();

      int ans = length - 1;
      for (int j = 0; j < length; j++) {
        if (sequence.charAt(j) == '>' || sequence.charAt(length - 1 - j) == '<') {
          ans = Math.min(ans, j);
        }
      }

      out.println(ans);
    }

    in.close();
    out.close();
  }
}