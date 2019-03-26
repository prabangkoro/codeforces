import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int minimumStep = n * 3;
        if (k > 1 && k < n) {
            minimumStep += Math.min((k - 1), (n - k));
        }
        System.out.println(minimumStep);
    }
}