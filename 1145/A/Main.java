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
    if (sorted(arr)) {
      return len;
    }
    int firstHalf[] = new int[len >> 1];
    int secondHalf[] = new int[len >> 1];
    for (int i = 0; i < len; i++) {
      if (i % 2 == 0) {
        firstHalf[i >> 1] = arr[i];
      } else {
        secondHalf[(i - 1) >> 1] = arr[i];
      }
    }
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