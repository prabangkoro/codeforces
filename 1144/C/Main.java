import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class Main {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int sequenceCounter[] = new int[200001];
    
    public static void main(String[] args) {
        int n = in.nextInt();
        boolean splittable = true;
        int sequence[] = new int[n];

        for (int i = 0; i < n; i++) {
            int inputSeq = in.nextInt();
            sequence[i] = inputSeq;
            sequenceCounter[inputSeq]++;
            if (sequenceCounter[inputSeq] > 2) {
                splittable = false;
            }
        }

        if (splittable) {
            Arrays.sort(sequence);
            LinkedList<Integer> increasing = new LinkedList<>();
            LinkedList<Integer> decreasing = new LinkedList<>();
            for (int i = 0; i < sequence.length; i++) {
                if (i == (sequence.length - 1)) {
                    increasing.add(sequence[i]);
                }
                else if (sequence[i] == sequence[i + 1]) {
                    decreasing.push(sequence[i]);
                } else {
                    increasing.add(sequence[i]);
                }
            }
            out.println("YES");
            out.println(increasing.size());
            Iterator<Integer> iterator = increasing.iterator();
            while (iterator.hasNext()) {
                out.print(iterator.next() + " ");
            }
            out.println();
            out.println(decreasing.size());
            iterator = decreasing.iterator();
            while (iterator.hasNext()) {
                out.print(iterator.next() + " ");
            }
            
        } else {
            out.println("NO");
        }

        in.close();
        out.close();
    }
}