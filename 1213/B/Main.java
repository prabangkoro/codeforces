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
      int n = in.nextInt();
      LinkedList<Integer> sequence = new LinkedList<>();
      for (int j = 0; j < n; j++) {
        int inp = in.nextInt();
        sequence.push(inp);
      }

      Iterator<Integer> iterator = sequence.iterator();
      int min = sequence.peek();
      int badDays = 0;
      while (iterator.hasNext()) {
        int price = iterator.next();
        if (min < price) badDays++;
        if (min > price) min = price;
      }
      out.println(badDays);
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