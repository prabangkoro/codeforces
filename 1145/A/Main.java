import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static boolean sorted (int arr[]) {
    boolean sorted = true;
    int len = arr.length;
    while (len > 1 && sorted) {
      if (arr[len - 1] < arr[len - 2]) {
        sorted = false;
      }
      len--;
    }
    return sorted;
  }

  static int thanosSort (int arr[]) {
    int len = arr.length;
    // out.println("len: " + len);
    // for (int i = 0; i < len; i++) {
    //   out.print(arr[i] + " ");
    // }
    // out.println();
    if (sorted(arr)) {
      return len;
    }
    int firstHalf[] = new int[len >> 1];
    int secondHalf[] = new int[len >> 1];
    for (int i = 0; i < len >> 1; i++) {
      firstHalf[i] = arr[i];
      secondHalf[i] = arr[(len >> 1) + i];
      // out.println("i first: " + i + " i second: " + ((len >> 1) + i));
    }

    // out.println("first half");
    // for (int i = 0; i < len >> 1; i++) {
    //   out.print(firstHalf[i] + " ");
    // }
    // out.println();
    // out.println("second half");
    // for (int i = 0; i < len >> 1; i++) {
    //   out.print(secondHalf[i] + " ");
    // }
    // out.println();

    return Math.max(thanosSort(firstHalf), thanosSort(secondHalf));
  }
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int numbers[] = new int[n];

    for (int i = 0; i < n; i++) {
      numbers[i] = in.nextInt();
    }

    int result = thanosSort(numbers);
    out.println(result);

    // if (sorted(numbers)) {
    //   out.println("Sorted...");
    // } else {
    //   out.println("not sorted ...");
    // }

    in.close();
    out.close();
  }
}