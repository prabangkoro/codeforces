import java.io.*;
import java.util.*;

public class Main {
  static InputStream inputStream = System.in;
  static OutputStream outputStream = System.out;
  static InputReader in = new InputReader(inputStream);
  static PrintWriter out = new PrintWriter(outputStream);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int a = in.nextInt();
    int x = in.nextInt();
    int b = in.nextInt();
    int y = in.nextInt();

    int distA = (a <= x) ? (x - a) : 2 * n - x - a;
    int distB = (b >= y) ? (b - y) : b + y;
    out.println("dist A: " + distA + " dist B: " + distB);

    boolean OK = false;
    for (int i = 0; i <= distA && i <= distB && !OK; i++) {
      int posA = a + i;
      if (posA > n) posA = n - (posA - n);
      int posB = b - i;
      if (posB < 1) posB = -posB + 2;
      out.println("pos A: " + posA + " pos B: " + posB);
      if (posA == posB) OK = true;
    }

    // boolean OK = true;
    // if (a > x ^ b > y) {
    //   if ((a + b) % 2 != 0) OK = false;
    //   else {
    //     int mid = (a + b) / 2;
    //     if (Math.abs(mid - a) == Math.abs(mid - b)) OK = true;
    //     else OK = false;
    //   }
    // } else {
    //   if (x >= Math.min(b, y) && x <= Math.max(b, y)) OK = true;
    //   else if (y >= Math.min(a, x) && y <= Math.max(a, x)) OK = true;
    //   else OK = false;
    // }

    out.println(OK ? "YES" : "NO");

    out.close();
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public long nextLong () {
      return Long.parseLong(next());
    }

    public char nextChar () {
      return next().charAt(0);
    }
  }
}