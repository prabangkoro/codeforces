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

    // take right
    int l_counter = 0;
    int r_counter = n - 1;
    int prev = 0;
    LinkedList<Character> sequenceRightPriority = new LinkedList<>();
    while (l_counter <= r_counter) {
      if (prev >= numbers[l_counter] && prev >= numbers[r_counter]) {
        break;
      }
      if (prev >= numbers[l_counter] && prev < numbers[r_counter]) {
        prev = numbers[r_counter];
        r_counter--;
        sequenceRightPriority.add('R');
        continue;
      }
      if (prev >= numbers[r_counter] && prev < numbers[l_counter]) {
        prev = numbers[l_counter];
        l_counter++;
        sequenceRightPriority.add('L');
        continue;
      }
      if (numbers[l_counter] < numbers[r_counter]) {
        prev = numbers[l_counter];
        l_counter++;
        sequenceRightPriority.add('L');
      } else {
        prev = numbers[r_counter];
        r_counter--;
        sequenceRightPriority.add('R');
      }
    }
    // take left
    l_counter = 0;
    r_counter = n - 1;
    prev = 0;
    LinkedList<Character> sequenceLeftPriority = new LinkedList<>();
    while (l_counter <= r_counter) {
      if (prev >= numbers[l_counter] && prev >= numbers[r_counter]) {
        break;
      }
      if (prev >= numbers[l_counter] && prev < numbers[r_counter]) {
        prev = numbers[r_counter];
        r_counter--;
        sequenceLeftPriority.add('R');
        continue;
      }
      if (prev >= numbers[r_counter] && prev < numbers[l_counter]) {
        prev = numbers[l_counter];
        l_counter++;
        sequenceLeftPriority.add('L');
        continue;
      }
      if (numbers[l_counter] > numbers[r_counter]) {
        prev = numbers[r_counter];
        r_counter--;
        sequenceLeftPriority.add('R');
      } else {
        prev = numbers[l_counter];
        l_counter++;
        sequenceLeftPriority.add('L');
      }
    }

    if (sequenceLeftPriority.size() > sequenceRightPriority.size()) {
      out.println(sequenceLeftPriority.size());
      for (Character seq : sequenceLeftPriority) {
        out.print(seq);
      }
    } else {
      out.println(sequenceRightPriority.size());
      for (Character seq : sequenceRightPriority) {
        out.print(seq);
      }
    }

    in.close();
    out.close();
  }
}