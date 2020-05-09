import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();
    int b = in.nextInt();

    int minBuy = 1001;
    for (int i = 0; i < n; i++) {
      int input = in.nextInt();
      minBuy = Math.min(minBuy, input);
    }
    int maxSell = 0;
    for (int i = 0; i < m; i++) {
      int input = in.nextInt();
      maxSell = Math.max(maxSell, input);
    }

    if (maxSell > minBuy) {
      int answer = (b / minBuy) * maxSell + (b % minBuy);
      out.println(answer);
    } else {
      out.println(b);
    }


    in.close();
    out.close();
  }
}