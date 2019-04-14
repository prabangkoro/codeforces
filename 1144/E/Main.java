import java.io.*;
import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static int[] getBase26 (String s) {
        int ans[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ans[i] = s.charAt(i) - 'a';
        }
        return ans;
    }
    
    static int[] sumBase64 (int[] a, int[] b) {
        int ans[] = new int[a.length + 1];
        for (int i = a.length - 1; i >= 0; i--) {
            ans[i + 1] += (a[i] + b[i]);
            if (ans[i + 1] < 26) continue;
            ans[i] = 1;
            ans[i + 1] %= 26;
        }
        return ans;
    }

    static int[] medianBase64 (int[] a) {
        int ans[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int dividen = (ans[i] + a[i]) >> 1;
            int remainder = (ans[i] + a[i]) - (dividen << 1);
            ans[i] = dividen;
            // out.println("a: " + a[i] + " d: " + dividen + " r: " + remainder);
            if (remainder == 0) continue;
            if (i == a.length - 1) continue;
            ans[i + 1] += (remainder * 26);
        }
        return ans;
    }

    public static void main(String[] args) {
        int k = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        String t = in.nextLine();

        int[] left = getBase26(s);
        int[] right = getBase26(t);

        int[] sum = sumBase64(left, right);
        int[] ans = medianBase64(sum);
        for (int i = 1; i < k + 1; i++) {
            out.print((char)(ans[i] + 'a'));
        }

        in.close();
        out.close();
    }
}