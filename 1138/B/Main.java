import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = scanner.nextInt();
        scanner.nextLine();
        String Clowns = scanner.nextLine();
        String Acrobats = scanner.nextLine();

        ArrayList<Integer> A_Indexes = new ArrayList<>();
        ArrayList<Integer> B_Indexes = new ArrayList<>();
        ArrayList<Integer> C_Indexes = new ArrayList<>();
        ArrayList<Integer> D_Indexes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int Clown = Clowns.charAt(i);
            int Acrobat = Acrobats.charAt(i);
            if (Clown == '1') {
                if (Acrobat == '1') {
                    D_Indexes.add(i + 1);
                } else {
                    C_Indexes.add(i + 1);
                }
            } else {
                if (Acrobat == '1') {
                    B_Indexes.add(i + 1);
                } else {
                    A_Indexes.add(i + 1);
                }
            }
        }
        int n_2 = n / 2;
        int n_A = A_Indexes.size();
        int n_B = B_Indexes.size();
        int n_C = C_Indexes.size();
        int n_D = D_Indexes.size();

        // out.println("A: ");
        // for (int i = 0; i < n_A; i++) {
        //     out.println(A_Indexes.get(i));
        // }
        // out.println("B: ");
        // for (int i = 0; i < n_B; i++) {
        //     out.println(B_Indexes.get(i));
        // }
        // out.println("C: ");
        // for (int i = 0; i < n_C; i++) { 
        //     out.println(C_Indexes.get(i));
        // }
        // out.println("D: ");
        // for (int i = 0; i < n_D; i++) {
        //     out.println(D_Indexes.get(i));
        // }

        int qty_A = 0, qty_B = 0, qty_C = 0, qty_D = 0;

        boolean brute = true;
        
        for (int brute_D = 0; brute_D <= n_D && brute; brute_D++) {
            int guess_A = n_2 - n_B - n_D + brute_D;
            if (guess_A < 0 || guess_A > n_A) continue;
            for (int brute_C = 0; brute_C <= n_C && brute; brute_C++) {
                int guess_B = n_2 - guess_A - brute_D - brute_C;
                if (guess_B < 0 || guess_B > n_B) continue;
                qty_A = guess_A;
                qty_B = guess_B;
                qty_C = brute_C;
                qty_D = brute_D;
                brute = false;
            }
        }

        for (int i = 0; i < qty_A; i++) {
            out.print(A_Indexes.get(i) + " ");
        }

        for (int i = 0; i < qty_B; i++) {
            out.print(B_Indexes.get(i) + " ");
        }

        for (int i = 0; i < qty_C; i++) {
            out.print(C_Indexes.get(i) + " ");
        }

        for (int i = 0; i < qty_D; i++) {
            out.print(D_Indexes.get(i) + " ");
        }

        if (qty_A == 0 && qty_B == 0 && qty_C == 0 && qty_D == 0) {
            out.println(-1);
        }

        out.flush();
    }
}