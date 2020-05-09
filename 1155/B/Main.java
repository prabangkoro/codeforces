import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    in.nextLine();
    String s = in.nextLine();
    int turn1 = (n - 11) / 2;
    int turn2 = (n - 11) / 2;

    LinkedList<Integer> result = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      int digit = s.charAt(i) - '0';
      if (digit == 8) {
        // petya
        if (turn2 > 0) turn2--;
        else result.add(digit);
      } else {
        // vasha
        if (turn1 > 0) turn1--;
        else result.add(digit);
      }
    }

    if (result.getFirst() == 8) out.println("YES");
    else out.println("NO");

    in.close();
    out.close();
  }
}