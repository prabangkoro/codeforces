import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] q = new int[n - 1];
        int[] newP = new int[n];
        newP[0] = 1;
        int min = 1;
        for (int i = 0; i < n - 1; i++) {
            q[i] = in.nextInt();
            newP[i + 1] = newP[i] + q[i];
            min = Math.min(min, newP[i + 1]);
        }

        int[] sortedP = new int[n];
        for (int i = 0; i < n; i++) {
            newP[i] -= min - 1;
            sortedP[i] = newP[i];
        }

        Arrays.sort(sortedP);

        boolean findSimilar = false;
        int counter = 0;
        while (counter < n - 1 && !findSimilar) {
            if (sortedP[counter] == sortedP[counter + 1]) {
                findSimilar = true;
            }
            counter++;
        }


        if (!findSimilar && (sortedP[n - 1] - sortedP[0]) == (n - 1)) {
            for (int i = 0; i < n; i++) {
                out.print(newP[i] + " ");
            }
        } else {
            out.println(-1);
        }

        out.flush();
    }
}