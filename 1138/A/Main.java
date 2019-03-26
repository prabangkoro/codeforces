import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = scanner.nextInt();
        ArrayList<Integer> consecutives = new ArrayList<>();
        int consecutiveIdx = -1;
        int prevSushi = 0;
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            if (t != prevSushi) {
                consecutives.add(1);
                consecutiveIdx++;
            } else {
                int currentConsecutive = consecutives.get(consecutiveIdx);
                consecutives.set(consecutiveIdx, currentConsecutive + 1);
            }
            prevSushi = t;
        }

        int longest = 1;
        for (int i = 0; i < consecutives.size() - 1; i++) {
            int conA = consecutives.get(i);
            int conB = consecutives.get(i + 1);
            longest = Math.max(longest, Math.min(conA, conB));
        }

        out.println(longest * 2);
        out.flush();
    }
}