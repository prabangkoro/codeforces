import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    in.nextLine();
    String number = in.nextLine();
    int[] numbers = new int[n];
    int[] diff = new int[n];

    for (int i = 0; i < n; i++) {
      numbers[i] = number.charAt(i) - '0';
    }

    int[] func = new int[9];
    for (int i = 0; i < 9; i++) {
      func[i] = in.nextInt();
    }

    for (int i = 0; i < n; i++) {
      diff[i] = func[numbers[i] - 1] - numbers[i];
    }

    for (int i = 0; i < n; i++) {
      if (diff[i] > 0) {
        while (i < n && diff[i] >= 0) {
          numbers[i] = func[numbers[i] - 1];
          i++;
        }
        break;
      }
    }
    for (int i = 0; i < n; i++) {
      out.print(numbers[i]);
    }

    in.close();
    out.close();
  }
}