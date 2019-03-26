import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        in.nextLine();
        String leftBoots = in.nextLine();
        String rightBoots = in.nextLine();

        ArrayList<LinkedList<Integer>> leftBootGroups = new ArrayList<LinkedList<Integer>>();
        ArrayList<LinkedList<Integer>> rightBootGroups = new ArrayList<LinkedList<Integer>>();
        LinkedList<String> answer = new LinkedList<>();

        for (int i = 0; i < 27; i++) {
            leftBootGroups.add(new LinkedList<Integer>());
            rightBootGroups.add(new LinkedList<Integer>());
        }


        // grouping boots
        for (int i = 0; i < n; i++) {
            Character left = leftBoots.charAt(i);
            if (left.equals('?')) {
                leftBootGroups.get(26).add(i + 1);
            } else {
                leftBootGroups.get(left - 'a').add(i + 1);
            }

            Character right = rightBoots.charAt(i);
            if (right.equals('?')) {
                rightBootGroups.get(26).add(i + 1);
            } else {
                rightBootGroups.get(right - 'a').add(i + 1);
            }
        }
        
        // matching letter pairs
        for (int i = 0; i < 26; i++) {
            LinkedList<Integer> left = leftBootGroups.get(i);
            LinkedList<Integer> right = rightBootGroups.get(i);
            while (left.peek() != null && right.peek() != null) {
                answer.add(left.pop() + " " + right.pop());
            }
        }

        // matching ? with the rest of arrays
        for (int i = 0; i < 26; i++) {
            LinkedList<Integer> left = leftBootGroups.get(26);
            LinkedList<Integer> right = rightBootGroups.get(i);
            while (left.peek() != null && right.peek() != null) {
                answer.add(left.pop() + " " + right.pop());
            }

            left = leftBootGroups.get(i);
            right = rightBootGroups.get(26);
            while (left.peek() != null && right.peek() != null) {
                answer.add(left.pop() + " " + right.pop());
            }
        }

        // matching ? with ?
        LinkedList<Integer> leftQuestion = leftBootGroups.get(26);
        LinkedList<Integer> rightQuestion = rightBootGroups.get(26);
        while (leftQuestion.peek() != null && rightQuestion.peek() != null) {
            answer.add(leftQuestion.pop() + " " + rightQuestion.pop());
        }

        out.println(answer.size());
        while (answer.peek() != null) {
            out.println(answer.pop());
        }

        out.flush();
    }
}