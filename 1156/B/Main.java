import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
  static InputStream inputStream = System.in;
  static OutputStream outputStream = System.out;
  static InputReader in = new InputReader(inputStream);
  static PrintWriter out = new PrintWriter(outputStream);

  static boolean isOK (String query) {
    boolean OK = true;
    for (int i = 1; i < query.length() && OK; i++) {
      if (Math.abs(query.charAt(i) - query.charAt(i - 1)) == 1) OK = false;
    }
    return OK;
  }

  static void solve (String query) {

    if (isOK(query)) {
      out.println(query);
    } else {
      char[] querryArray = query.toCharArray();
      ArrayList<Character> even = new ArrayList<>();
      ArrayList<Character> odd = new ArrayList<>();

      for (int i = 0; i < querryArray.length; i++) {
        if (querryArray[i] % 2 == 0) even.add(querryArray[i]);
        else odd.add(querryArray[i]);
      }
      Collections.sort(even);
      Collections.sort(odd);

      if (Math.abs(even.get(0) - odd.get(odd.size() - 1)) != 1) {
        odd.addAll(even);
        out.println(getStringRepresentation(odd));
      } else if (Math.abs(odd.get(0) - even.get(even.size() - 1)) != 1) {
        even.addAll(odd);
        out.println(getStringRepresentation(even));
      }
      else out.println("No answer");
    }
  }
  
  public static void main(String[] args) {
    int T = in.nextInt();

    for (int i = 0; i < T; i++) {
      solve(in.next());
    }

    out.close();
  }

  static String getStringRepresentation(ArrayList<Character> list)
  {    
    StringBuilder builder = new StringBuilder(list.size());
    for(Character ch: list)
    {
      builder.append(ch);
    }
    return builder.toString();
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