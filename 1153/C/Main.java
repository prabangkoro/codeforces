import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    in.nextLine();

    String seq = in.nextLine();

    if (seq.charAt(0) == ')' || seq.charAt(seq.length()) == '(') {
      out.println(":(");
    } else {
      for (int i = 0; i < max; i++) {
        
      }
    }

    in.close();
    out.close();
  }
}