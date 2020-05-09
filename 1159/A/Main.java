import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    in.nextLine();
    String sequence = in.nextLine();

    int current_pile = 0;
    for (int i = 0; i < n; i++) {
      char action = sequence.charAt(i);
      if (action == '-') {
        if (current_pile > 0) current_pile--; 
      } else {
        current_pile++;
      }
    }

    out.println(current_pile);

    in.close();
    out.close();
  }
}