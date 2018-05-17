package mind.the.gap;

import java.io.*;
import java.util.*;


/**
 *
 * @author babang
 * Problem: Mind the Gap (http://codeforces.com/problemset/problem/967/A)
 */
public class MindTheGap {
    
    static Scanner in = new Scanner(System.in);
    static int n, s;
    public static void main(String[] args) throws IOException {
        n = in.nextInt(); s = in.nextInt();
        boolean found = false;
        int prevMMM = 0; int tt = 0;
        
        //first case
        int h = in.nextInt(); int m = in.nextInt(); int M = h*60+m;
        if (M > s) {
            found = true;
            tt = 0;
        }
        prevMMM = M;
        for (int qq = 1; qq < n; qq++) {
            int hh = in.nextInt(); int mm = in.nextInt();
            int mmm = hh*60 + mm;
            if (!found) {
                if ((mmm - prevMMM) >= (2*s+2)) {
                    found = true;
                    tt = prevMMM + s + 1;
                }
            }
            prevMMM = mmm;
        }
        if (!found) {
            tt = prevMMM + s + 1;
        }
        System.out.println(tt/60 + " " + tt%60);
    }
}
