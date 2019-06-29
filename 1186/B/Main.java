import java.io.*;
import java.util.*;

public class Main {
  static InputStream inputStream = System.in;
  static OutputStream outputStream = System.out;
  static InputReader in = new InputReader(inputStream);
  static PrintWriter out = new PrintWriter(outputStream);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    double[] a = new double[n];
    double[] floorA = new double[n];
    long sum = 0;

    for (int i = 0; i < n; i++) {
      a[i] = in.nextDouble();
      // out.println(a[i]);
      floorA[i] = Math.floor(a[i]);
      sum += floorA[i];
    }

    // out.println("floor: ");
    // for (double ans : floorA) {
    //   out.println((int)ans);
    // }

    int i = 0;
    while (sum < 0 && i < n) {
      double diff = a[i] - floorA[i];
      if (diff != 0 && diff != 1) {
        floorA[i]++;
        sum++;
      }
      i++;
    }

    // out.println("ans:");
    for (double ans : floorA) {
      out.println((int)ans);
    }

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

    public double nextDouble () {
      return Double.parseDouble(next());
    }

    public char nextChar () {
      return next().charAt(0);
    }
  }
}