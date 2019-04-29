import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static HashSet<Integer> savedNumber = new HashSet<>();

  static int removeTrailingZeros (int a) {
    if (a % 10 == 0) {
      return removeTrailingZeros(a / 10);
    } else {
      return a;
    }
  }

  static int func (int a) {
    a++;
    return removeTrailingZeros(a);
  }

  static void countAllPossibility (int z) {
    while (!savedNumber.contains(z)) {
      savedNumber.add(z);
      countAllPossibility(func(z));
    }
  }
  
  public static void main(String[] args) {
    int n = in.nextInt();

    countAllPossibility(n);
    out.println(savedNumber.size());

    in.close();
    out.close();
  }
}