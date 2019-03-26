import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        // int[] bookFirstPageChapters = new int[n];
        int[] bookLastPageChapters = new int[n];

        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            // bookFirstPageChapters[i] = l;
            bookLastPageChapters[i] = r;
        }

        int k = scanner.nextInt();
        int doneChapter = 0;
        for (int i = 0; i < n ; i++) {
            if (bookLastPageChapters[i] < k) {
                doneChapter++;
            } else {
                break;
            }
        }

        System.out.println(n - doneChapter);
    }
}