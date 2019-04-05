import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static int len;
  static int digits[];

  static int getNineMultiplication (int k) {
    for (int i = 1; i <= k; i++) {
      if (digits[len - i] < 9) {
        digits[len - i] = 9;
        digits[len - i - 1]--;
      }
    }

    for (int i = len - 1; i > 0; i--) {
      if (digits[i] < 0) {
        digits[i] = 9;
        digits[i - 1]--;
      }
    }

    int multiplication = 1;
    for (int i = 0; i < len; i++) {
      if (i == 0 && digits[i] == 0) continue;
      multiplication *= digits[i];
      // out.print(digits[i]);
    }
    // out.println();

    return multiplication;
  }
  
  public static void main(String[] args) {
    String input = in.nextLine();
    len = input.length();
    digits = new int[len];

    for (int i = 0; i < len; i++) {
      digits[i] = input.charAt(i) - '0';
    }

    int max = 1;
    for (int i = 0; i < len; i++) {
      max = Math.max(max, getNineMultiplication(i));
    }

    out.println(max);

    in.close();
    out.close();
  }
}