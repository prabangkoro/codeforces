import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] vertices;
    static long mod = (long) 1e9 + 7;
    static boolean[] visited;
    static int counter = 0;

    static void dfs (int i) {
        visited[i]= true;
        counter++;
        for (int j : vertices[i]) {
            if (!visited[j]) {
                dfs(j);
            }
        }
    }

    static long fast_pow (long base, long exponent) {
        if (exponent == 0) {
            return 1L;
        }

        long mid = fast_pow(base, exponent / 2);

        if (exponent % 2 == 0) {
            return mid * mid % mod;
        } else {
            return mid * mid % mod * base % mod;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int k = in.nextInt();

        vertices = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            int color = in.nextInt();
            if (color == 0) {
                vertices[u].add(v);
                vertices[v].add(u);
            }
        }

        long sum = fast_pow(n, k);
        long inversCases = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                counter = 0;
                dfs(i);
                inversCases += fast_pow(counter, k);
            }
        }

        inversCases %= mod;
        sum = (sum - inversCases + mod) % mod;

        out.println(sum);
        
        out.close();
    }
}