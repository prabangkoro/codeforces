import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int[] candies = new int[n];

    for (int i = 0; i < n; i++) {
      candies[i] = in.nextInt();
    }

    int max_same_amount = 0;
    int[] candy_amount = new int[200000];
    for (int i = 0; i < n - 1; i++) {
      for (int j = i+1; j < n; j++) {
        int amount = candies[j] + candies[i];
        // out.println("c i: " + candies[i] + " j: " + candies[j] + " amount: " + amount);
        candy_amount[amount]++;
        max_same_amount = Math.max(max_same_amount, candy_amount[amount]);
      }
      // out.println();
    }

    out.println(max_same_amount);

    in.close();
    out.close();
  }
}