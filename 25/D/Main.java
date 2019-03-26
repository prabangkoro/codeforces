import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

import javafx.util.Pair;

public class Main {

    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int root[];
    static ArrayList<Pair<Integer, Integer>> unUsedRoute = new ArrayList<>();
    static Random rand = new Random();

    static void makeSet(int u) {
        root[u] = u;
    }

    static int getRoot(int u) {
        if (u == root[u]) {
            return u;
        }
        root[u] = getRoot(root[u]);
        return root[u];
    }

    static void mergeUnion(int u, int v) {
        int rootU = getRoot(u);
        int rootV = getRoot(v);
        if (rootU != rootV)
            if (rand.nextInt(2) % 2 == 0)
                root[rootV] = rootU;
            else
                root[rootU] = rootV;
        else
            unUsedRoute.add(new Pair<>(u + 1, v + 1));
    }
    public static void main(String[] args) {
        int n = in.nextInt();
        root = new int[n];
        for (int i = 0; i < n; i++) {
            makeSet(i);
        }

        for (int i = 0; i < n - 1; i++) {
            Integer u = in.nextInt() - 1;
            Integer v = in.nextInt() - 1;
            mergeUnion(u, v);
        }

        TreeSet<Integer> disjointUnion = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            disjointUnion.add((getRoot(i) + 1));
        }
            
        Object disjointUnionList[] = disjointUnion.toArray();
        out.println(unUsedRoute.size());
        int index = 0;
        for (Pair<Integer, Integer> entry : unUsedRoute) {
            out.println(entry.getKey() + " " + entry.getValue() + " " + disjointUnionList[index] + " " + disjointUnionList[index + 1]);
            index++;
        }

        in.close();
        out.close();
    }
}