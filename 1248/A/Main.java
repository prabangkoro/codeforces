import java.io.*;
import java.util.*;

public class Main {
  static InputStream inputStream = System.in;
  static OutputStream outputStream = System.out;
  static InputReader in = new InputReader(inputStream);
  static PrintWriter out = new PrintWriter(outputStream);
  
  public static void main(String[] args) {
    int t = in.nextInt();
    
    for (int i = 0; i < t; i++) {
      long odd1 = 0;
      long odd2 = 0;
      long even1 = 0;
      long even2 = 0;

      // DLS
      int dls = in.nextInt();
      for (int j = 0; j < dls; j++) {
        long input = in.nextInt();
        if (input % 2 == 0) even1++;
        else odd1++;
      }
      // JLS
      int jls = in.nextInt();
      for (int j = 0; j < jls; j++) {
        long input = in.nextInt();
        if (input % 2 == 0) even2++;
        else odd2++;
      }

      out.println((odd1 * odd2 + even1 * even2));
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

    public char nextChar () {
      return next().charAt(0);
    }
  }
}