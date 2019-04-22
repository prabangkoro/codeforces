import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int[] uv = new int[n];
    int maxUV = 0;
    int minUV = 101;
    for (int i = 0; i < n; i++) {
      uv[i] = in.nextInt();
      maxUV = Math.max(maxUV, uv[i]);
      minUV = Math.min(minUV, uv[i]);
    }
    int D = maxUV - minUV;
    int medianUV = minUV;
    if ((maxUV - minUV) % 2 == 0) {
      D = (maxUV - minUV) >> 1;
      medianUV = minUV + D;
    }

    boolean valid = true;
    for (int i = 0; i < n; i++) {
      if (uv[i] > medianUV) {
        uv[i] -= D;
      } else if (uv[i] < medianUV) {
        uv[i] += D;
      }
      if (uv[i] != medianUV) {
        valid = false;
        break;
      }
    }

    if (valid) {
      out.println(D);
    } else {
      out.println(-1);
    }

    in.close();
    out.close();
  }
}