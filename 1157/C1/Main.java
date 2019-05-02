import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();

    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = in.nextInt();
    }

    int l_counter = 0;
    int r_counter = n - 1;
    int prev = 0;
    LinkedList<Character> sequence = new LinkedList<>();
    while (l_counter <= r_counter) {
      if (prev > numbers[l_counter] && prev > numbers[r_counter]) {
        break;
      }
      if (prev > numbers[l_counter] && prev < numbers[r_counter]) {
        prev = numbers[r_counter];
        r_counter--;
        sequence.add('R');
        continue;
      }
      if (prev > numbers[r_counter] && prev < numbers[l_counter]) {
        prev = numbers[l_counter];
        l_counter++;
        sequence.add('L');
        continue;
      }
      if (numbers[l_counter] < numbers[r_counter]) {
        prev = numbers[l_counter];
        l_counter++;
        sequence.add('L');
      } else {
        prev = numbers[r_counter];
        r_counter--;
        sequence.add('R');
      }
    }

    out.println(sequence.size());
    for (Character seq : sequence) {
      out.print(seq);
    }

    in.close();
    out.close();
  }
}