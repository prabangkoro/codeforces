import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long H = in.nextLong();
        int n = in.nextInt();
        int[] d = new int[n];

        long minRoundHChange = 0;
        long totalRoundHChange = 0;

        for (int i = 0; i < n; i++) {
            d[i] = in.nextInt();
            totalRoundHChange += d[i];
            minRoundHChange = Math.min(minRoundHChange, totalRoundHChange);
        }

        // out.println("min round: " + minRoundHChange);
        // out.println("total round: " + totalRoundHChange);

        if (Math.abs(minRoundHChange) < H && totalRoundHChange >= 0) {
            out.println(-1);
        } else {
            long minutes = 0;
            long rounds = 0;
            if (Math.abs(minRoundHChange) < H) {
                rounds = Math.max((H + minRoundHChange) / -totalRoundHChange, 1);
                H += rounds * totalRoundHChange;
            }
            if ((H + minRoundHChange) > 0) {
                rounds++;
                H += totalRoundHChange;
            }
            minutes = rounds * n;
            // out.println("minutes: " + minutes);
            // out.println("H left: " + H);
            // out.println("rounds: " + rounds);
            
            int counter = 0;
            while (H > 0 && counter < n) {
                H += d[counter];
                counter++;
            }
            minutes += counter;

            out.println(minutes);
        }

        out.close();
    }
}