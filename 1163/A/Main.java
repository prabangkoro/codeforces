import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();
    
    if (m == 0) out.println(1);
    else {
      if (m <= (n / 2)) out.println(m);
      else out.println(n - m);
    }

    in.close();
    out.close();
  }
}