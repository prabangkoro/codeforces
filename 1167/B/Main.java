import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) {
    HashSet<Integer> specials = new HashSet<>();
    specials.add(4);
    specials.add(8);
    specials.add(15);
    specials.add(16);
    specials.add(23);
    specials.add(42);

    int[] ans = new int[4];
    for (int i = 0; i < 4; i++) {
      out.println("? " + (i + 1) + " " + (i + 2));
      out.flush();
      ans[i] = in.nextInt();
    }

    int[] a = new int[6];
    Iterator<Integer> it = specials.iterator();
    while (it.hasNext()) {
      int special = it.next();
      if (specials.contains(ans[0] / special) && specials.contains(ans[1] / special)) {
        a[0] = ans[0] / special;
        a[1] = special;
        a[2] = ans[1] / special;
        break;
      }
    }
    a[3] = ans[2] / a[2];
    a[4] = ans[3] / a[3];
    for (int i = 0; i < 5; i++) {
      specials.remove(a[i]);
    }
    it = specials.iterator();
    if (it.hasNext()) a[5] = it.next();
    

    out.print("!");
    for (int i = 0; i < 6; i++) {
      out.print(" " + a[i]);
    }
    out.println();
    out.flush();

    in.close();
    out.close();
  }
}