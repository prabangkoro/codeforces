import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        LinkedList<Integer> a = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            a.push(in.nextInt());
        }

        long sum = a.pop();
        long min = sum;
        while (a.peek() != null && min > 0) {
            int ai = a.pop();
            min = Math.min(min - 1, ai);
            // out.println("ai: " + ai);
            sum += min;
        }

        out.println(sum);
        
        out.close();
    }
}