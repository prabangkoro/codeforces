import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int[] modCollection = new int[100];
    public static void main(String[] args) {
        
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int result = solution(n, k);
        System.out.println(result);
    }

    static int solution(int n, int k) {
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            modCollection[d%k]++;
        }
        int sum = modCollection[0]/2;
        for (int i = 1; i <= (k-i); i++) {
            if (i==(k-i)) {
                sum += modCollection[i]/2;
                continue;
            }
            sum += Math.min(modCollection[i], modCollection[k-i]);
        }
        return sum * 2;
    }
}