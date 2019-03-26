import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        ArrayList<ArrayList<Integer>> fencePainters = new ArrayList<ArrayList<Integer>>(n);
        int[] fencePainterAmount = new int[n];

        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            for (int j = l - 1; j < r; j++) {
                fencePainterAmount[j]++;
                fencePainters.get(j).add(i);
            }
        }

        int maxPainted = n;
        out.println("max painted: ");
        for (int i = 0; i < n; i++) {
            out.println(fencePainterAmount[i]);
            if (fencePainterAmount[i] == 0) {
                maxPainted--;
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(i + " : ");
            ArrayList singleFencePainter = fencePainters.get(i);
            for (int j = 0; j < singleFencePainter.size(); j++) {
                out.print(singleFencePainter.get(j) + " ");
            }
            out.println();
        }

        out.println(maxPainted);
        out.flush();
    }
}