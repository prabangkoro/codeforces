import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static boolean[] isPrime;

  static void calculateAllPrime (int n) {
    for (int i = 2; i < n; i++) {
      isPrime[i] = true;
    }
    for (int i = 2; i * i <= n; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= n; j += i) {
          isPrime[j] = false;
        }
      }
    }
  }
  
  public static void main(String[] args) {
    int n = in.nextInt();

    int ones = 0;
    int twos = 0;
    for (int i = 0; i < n; i++) {
      int input = in.nextInt();
      if (input == 1) ones++;
      else twos++;
    }
    int sum = ones + twos * 2;
    isPrime = new boolean[sum + 2];
    calculateAllPrime(sum + 1);

    // out.println(sum);

    // for (int i = 1; i <= sum; i++) {
    //   out.println(i + " " + isPrime[i]);
    // }

    int prefix = 0;
    for (int i = 0; i < n; i++) {
      if (isPrime[prefix + 1] && ones > 0) {
        prefix++;
        ones--;
        out.print(1 + " ");
      } else if (isPrime[prefix + 2] && twos > 0) {
        prefix += 2;
        twos--;
        out.print(2 + " ");
      } else {
        if (twos > 0) {
          twos--;
          out.print(2 + " ");
        } else if (ones > 0) {
          ones--;
          out.print(1 + " ");
        }
      }
    }

    in.close();
    out.close();
  }
}