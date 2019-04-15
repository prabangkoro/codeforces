import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    in.nextLine();

    char[] ans = in.nextLine().toCharArray();
    boolean valid = true;
    // out.println(n);
    if (n % 2 != 0) {
      out.println(":(");
      valid = false;
    }
    int l = n >> 1;
    int r = n >> 1;
    for (int i = 0; i < n; i++) {
      if (ans[i] == '(') l--;
      if (ans[i] == ')') r--;
    }
    if (valid && (l < 0 || r < 0)) {
      out.println(":(");
      valid = false;
    }
    // out.println(ans[0]);
    if (valid && (ans[0] == ')' || ans[n-1] == '(')) {
      out.println(":(");
      valid = false;
    }

    int parPoint = 0;
    
    for (int i = 0; i < n && valid; i++) {
      if (ans[i] == '(') {
        parPoint++;
      }
      if (ans[i] == ')') {
        parPoint--;
      }
      if (ans[i] == '?') {
        if (l > 0) {
          ans[i] = '(';
          l--;
          parPoint++;
        } else {
          if (r > 0) {
            ans[i] = ')';
            r--;
            parPoint--;
          }
        }
      }
      if (parPoint == 0 && i != (n - 1)) {
        out.println(":(");
        valid = false;
        break;
      }
    }

    if (valid) {
      out.println(ans);
    }

    in.close();
    out.close();
  }
}