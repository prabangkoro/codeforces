import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();

    int[] power_list = new int[n];
    int[] school_list = new int[n];
    int[] max_power_in_school = new int[m + 1];
    for (int i = 0; i < n; i++) power_list[i] = in.nextInt();
    for (int i = 0; i < n; i++) {
      int school = in.nextInt();
      school_list[i] = school;
      max_power_in_school[school] = Math.max(max_power_in_school[school], power_list[i]);
    }
    int make_up_counter = 0;
    for (int i = 0; i < k; i++) {
      int id = in.nextInt() - 1;
      if (power_list[id] < max_power_in_school[school_list[id]]) {
        make_up_counter++;
      }
    }
    out.println(make_up_counter);
    in.close();
    out.close();
  }
}