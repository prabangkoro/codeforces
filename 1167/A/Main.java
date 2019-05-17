import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int t = in.nextInt();
    
    for (int i = 0; i < t; i++) {
      int n = in.nextInt();
      in.nextLine();
      String phone = in.nextLine();
      boolean OK = false;
      for (int j = 0; j < n - 10 && !OK; j++) {
        if (phone.charAt(j) == '8') {
          OK = true;
        }
      }
      out.println(OK ? "YES" : "NO");
    }

    in.close();
    out.close();
  }
}