import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();

    ArrayList<Integer> boys = new ArrayList<>();
    int min_boys = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int input = in.nextInt();
      boys.add(input);
      min_boys = Math.min(min_boys, input);
    }
    PriorityQueue<Integer> girls = new PriorityQueue<>();
    int max_girls = 0;
    for (int i = 0; i < m; i++) {
      int input = in.nextInt();
      girls.add(input);
      max_girls = Math.max(max_girls, input);
    }

    long sweets = 0;
    if (min_boys > max_girls) {
      sweets = -1;
    } else {
      Collections.sort(boys);
      for (Integer boy : boys) {
        girls.peek();
        Iterator<Integer> it_girls = girls.iterator();
        while (it_girls.hasNext()) {

        }
      }
    }

    out.println(sweets);

    in.close();
    out.close();
  }
}