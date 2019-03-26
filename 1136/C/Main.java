import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int row = scanner.nextInt(); // row
        int col = scanner.nextInt(); // column
        Integer N = row + col - 1;
        int[][] diagonalA = new int[N][row];
        int[][] diagonalB = new int[N][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Integer in = scanner.nextInt();
                diagonalA[(i + j) % N][i] = in;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Integer in = scanner.nextInt();
                diagonalB[(i + j) % N][i] = in;
            }
        }

        boolean ok = true;
        for (int i = 0; i < N && ok; i++) {
            Arrays.sort(diagonalA[i]);
            Arrays.sort(diagonalB[i]);
            for (int j = row - 1; j >= 0 && ok; j--) {
                if (diagonalA[i][j] != diagonalB[i][j]) {
                    ok  = false;
                }
            }
        }
        
        out.println(ok ? "YES" : "NO");
        out.flush();
    }
}