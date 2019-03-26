import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();

        Integer[][] dishes = new Integer[n][3];
        Integer[][] people = new Integer[m][2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                dishes[j][i] = in.nextInt();
            }
        }
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < m; j++) {
                people[j][i] = in.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int pi = dishes[j][0];
                int si = dishes[j][1];
                int bi = dishes[j][2];
                int inci = people[i][0];
                int prefi = people[i][1];
                if (inci >= pi && inci <= si &&
                    Math.abs(bi - prefi) <= (inci - pi)) {
                    sum++;
                }
            }
            out.print(sum + " ");
        }

        out.close();
    }
}