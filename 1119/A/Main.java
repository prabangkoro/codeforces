import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();

    int[] colors = new int[n];
    for (int i = 0; i < n; i++) {
      colors[i] = in.nextInt();
    }

    int longest_dist = 0;
    int l_counter = 0;
    int r_counter = n - 1;
    boolean diff_color = false;
    while (l_counter <= r_counter && !diff_color) {
      if (colors[l_counter] != colors[r_counter]) {
        diff_color = true;
        longest_dist = r_counter - l_counter;
      } else {
        r_counter--;
      }
    }
    l_counter = 0;
    r_counter = n - 1;
    diff_color = false;
    while (l_counter <= r_counter && !diff_color) {
      if (colors[l_counter] != colors[r_counter]) {
        diff_color = true;
        longest_dist = Math.max(longest_dist, (r_counter - l_counter));
      } else {
        l_counter++;
      }
    }

    out.println(longest_dist);

    in.close();
    out.close();
  }
}