import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int seqCounter[] = new int[200001];
    
    public static void main(String[] args) {
        int n = in.nextInt();
        int input = 0;
        int sequence[] = new int[n];
        for (int i = 0; i < n; i++) {
            input = in.nextInt();
            sequence[i] = input;
            seqCounter[input]++;
        }

        if (seqCounter[input] == n) {
            out.println(0);
        } else {
            int maxCount = 0;
            int maxNumberSequence = 0;
            for (int i = 0; i < seqCounter.length; i++) {
                if (seqCounter[i] == 0) continue;
                if (maxCount < seqCounter[i]) {
                    maxCount = seqCounter[i];
                    maxNumberSequence = i;
                }
            }
            // out.println("max number: "+ maxNumberSequence);
            ArrayList<Integer> nonMaxSequence = new ArrayList<>();
            int counter = 0;
            while (counter < n) {
                if (sequence[counter] != maxNumberSequence) {
                    nonMaxSequence.add(counter);
                    while (counter < n && sequence[counter] != maxNumberSequence) {
                        counter++;
                    }
                    nonMaxSequence.add(counter - 1);
                } else {
                    while (counter < n && sequence[counter] == maxNumberSequence) {
                        counter++;
                    }
                }
            }

            ArrayList<String> ans = new ArrayList<>();
            for (int i = 0; i < nonMaxSequence.size(); i += 2) {
                int start = nonMaxSequence.get(i);
                int end = nonMaxSequence.get(i + 1);
                // out.println("start: " + start + " end: " + end);
                if (start == 0) {
                    for (int j = end; j >= start; j--) {
                        if (sequence[j] > maxNumberSequence) {
                            ans.add(2 + " " + (j + 1) + " " + (j + 2));
                        } else {
                            ans.add(1 + " " + (j + 1) + " " + (j + 2));
                        }
                    }
                } else {
                    for (int j = start; j <= end; j++) {
                        if (sequence[j] > maxNumberSequence) {
                            ans.add(2 + " " + (j + 1) + " " + (j));
                        } else {
                            ans.add(1 + " " + (j + 1) + " " + (j));
                        }
                    }
                }
            }
            out.println(ans.size());
            for (String answer : ans) {
                out.println(answer);
            }
        }

        in.close();
        out.close();
    }
}