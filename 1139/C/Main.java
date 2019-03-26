import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int parent[];
    static int size[];
    static long MOD = (long) 1e9 + 7;
    static Random rand = new Random();

    static void makeSet (int u) {
        parent[u] = u;
        size[u] = 1;
    }

    static int findSet (int u) {
        if (u == parent[u]) return u;
        parent[u] = findSet(parent[u]);
        return parent[u];
    }

    static void unionSet (int u, int v) {
        int parentU = findSet(u);
        int parentV = findSet(v);
        if (parentU != parentV) {
            if (size[parentU] < size[parentV]) {
                parent[parentU] = parentV;
                size[parentV] += size[parentU];
            } else {
                parent[parentV] = parentU;
                size[parentU] += size[parentV];
            }
        }
    }

    static long fast_pow (long base, long exponent) {
        if (exponent == 0) {
            return 1;
        }
        long mid = fast_pow(base, exponent / 2);
        if (exponent % 2 == 0) {
            return mid * mid % MOD;
        } else {
            return mid * mid % MOD * base % MOD;
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int k = in.nextInt();

        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            makeSet(i);
        }

        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            int color = in.nextInt();
            if (color == 0) {
                unionSet(u, v);
            }
        }

        // get unique parent
        TreeSet<Integer> uniqueParent = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            uniqueParent.add(findSet(i));
        }

        Object uniqueParentList[] = uniqueParent.toArray();
        // count inverse graph
        long inverseGraph = 0;
        for (Object uParent : uniqueParentList) {
            inverseGraph = (inverseGraph + fast_pow(size[(Integer)uParent], k)) % MOD;
            // out.println("unique Parent: " + ((Integer)uParent + 1));
        }

        // for (int i = 0; i < n; i++) {
        //     out.println("i: " + (i + 1) + " parent: " + (findSet(i) + 1) + " size: " + size[i]);
        // }

        long sum = fast_pow(n, k);
        sum = (sum - inverseGraph + MOD) % MOD;

        out.println(sum);

        in.close();
        out.close();
    }
}