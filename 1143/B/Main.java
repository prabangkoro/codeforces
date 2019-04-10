import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    String number = in.nextLine();
    int digits[] = new int[number.length()];

    for (int i = 0; i < number.length(); i++) {
      digits[i] = number.charAt(i) - '0';
    }

    int answer = 1;
    if (digits.length > 2) {
      int nines = digits.length - 2;
      while (nines > 0) {
        answer *= 9;
        nines--;
      }
      int currentMax = digits[0] * digits[1];
      int beforeMax = 1;
      if (digits[1] != 9) {
        beforeMax *= (9 * Math.max(digits[0] - 1, 1));
      }
      answer *= Math.max(currentMax, beforeMax);
    } else if (digits.length == 2) {
      int currentMax = digits[0] * digits[1];
      int beforeMax = 1;
      if (digits[1] != 9) {
        beforeMax *= (9 * Math.max(digits[0] - 1, 1));
      }
      answer = Math.max(currentMax, beforeMax);
    } else {
      answer = digits[0];
    }

    // for (int i = digits.length - 1; i > 0; i--) {
    //   if (digits[i] == 0 || digits[i] == -1) {
    //     digits[i] = 9;
    //     digits[i - 1]--;
    //   } else if (i > 1 && digits[i] < 9) {
    //     digits[i] = 9;
    //     digits[i - 1]--;
    //   }
    // }

    // for (int digit : digits) {
    //   if (digit == 0) continue;
    //   answer *= digit;
    //   out.print(digit + " ");
    // }

    // out.println();
    out.println(answer);

    in.close();
    out.close();
  }
}