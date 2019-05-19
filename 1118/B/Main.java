import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();

    int[] a = new int[n + 1];
    int[] evenPreSum = new int[n / 2 + 2];
    int even = 0;
    int[] oddPreSum = new int[n / 2 + 2];
    int odd = 0;
    for (int i = 0; i < n; i++) {
      int input = in.nextInt();
      a[i] = input;
      if (i % 2 == 0) {
        even += input;
        evenPreSum[i / 2 + 1] = even;
      } else {
        odd += input;
        oddPreSum[i / 2 + 1] = odd;
      }
    }

    // for (int i = 0; i < n / 2 + 2; i++) {
    //   out.println("i: " + i + " odd: " + oddPreSum[i] + " even: " + evenPreSum[i]);
    // }
    // out.println("odd sum: " + odd + " even sum: " + even);
    int ans = 0;
    for (int i = 0; i < n; i++) {
      int sumEven = 0;
      int sumOdd = 0;
      if (i % 2 == 0) {
        sumEven = (evenPreSum[i / 2] - evenPreSum[0]) + (odd - oddPreSum[i / 2]);
        sumOdd = (oddPreSum[i / 2] - oddPreSum[0]) + (even - evenPreSum[i / 2 + 1]);
      } else {
        sumEven = (evenPreSum[i / 2 + 1]) + (odd - oddPreSum[i / 2 + 1]);
        sumOdd = (oddPreSum[i / 2] - oddPreSum[0]) + (even - evenPreSum[i / 2 + 1]);
      }
      // out.println("i: " + i + " a: " + a[i]);
      // out.println("sum odd: " + sumOdd + " sum even: " + sumEven);
      if (sumEven == sumOdd) ans++;
    }

    out.println(ans);

    in.close();
    out.close();
  }
}