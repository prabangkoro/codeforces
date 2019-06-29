import java.io.*;
import java.util.*;

public class Main {
  static InputStream inputStream = System.in;
  static OutputStream outputStream = System.out;
  static InputReader in = new InputReader(inputStream);
  static PrintWriter out = new PrintWriter(outputStream);
  
  public static void main(String[] args) {
    int h = in.nextInt();
    int w = in.nextInt();
    String[] tiles = new String[h];
    boolean[][] stars = new boolean[h][w];

    for (int i = 0; i < h; i++) {
      tiles[i] = in.next();
      for (int j = 0; j < w; j++) {
        if (tiles[i].charAt(j) == '*') stars[i][j] = true;
      }
    }

    boolean center = false;
    int centerH = 0;
    int centerW = 0;
    for (int i = 1; i < h - 1 && !center; i++) {
      for (int j = 1; j < w - 1 && !center; j++) {
        if (stars[i][j] &&
          stars[i - 1][j] &&
          stars[i + 1][j] &&
          stars[i][j - 1] &&
          stars[i][j + 1]
          ) {
            center = true;
            centerH = i;
            centerW = j;
            stars[centerH][centerW] = false;
          }
      }
    }

    if (!center) out.println("NO");
    else {
      // upward
      int start = 1;
      while ((centerH - start) >= 0 && stars[centerH - start][centerW]) {
        stars[centerH - start][centerW] = false;
        start++;
      }
      // downward
      start = 1;
      while ((centerH + start) < h && stars[centerH + start][centerW]) {
        stars[centerH + start][centerW] = false;
        start++;
      }
      // left
      start = 1;
      while ((centerW - start) >= 0 && stars[centerH][centerW - start]) {
        stars[centerW][centerW - start] = false;
        start++;
      }
      // right
      start = 1;
      while ((centerW + start) < w && stars[centerH][centerW + start]) {
        stars[centerW][centerW + start] = false;
        start++;
      }
  
      center = false;
      for (int i = 0; i < h && !center; i++) {
        for (int j = 0; j < w && !center; j++) {
          if (stars[i][j]) {
            center = true;
          }
        }
      }
  
      if (!center) out.println("YES");
      else out.println("NO");
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