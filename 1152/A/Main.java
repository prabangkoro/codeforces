import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();

    int A_Even = 0;
    int A_Odd = 0;
    for (int i = 0; i < n; i++) {
      int input = in.nextInt();
      if (input % 2 == 0) {
        A_Even++;
      } else {
        A_Odd++;
      }
    }
    int B_Even = 0;
    int B_Odd = 0;
    for (int i = 0; i < m; i++) {
      int input = in.nextInt();
      if (input % 2 == 0) {
        B_Even++;
      } else {
        B_Odd++;
      }
    }

    int answer = Math.min(A_Even, B_Odd) + Math.min(A_Odd, B_Even);
    out.println(answer);

    in.close();
    out.close();
  }
}