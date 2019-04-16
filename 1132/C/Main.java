import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  static int getMinRes (int[] l, int[] r) {
    int[] painterCountChange = new int[n + 1];
    for (int i = 0; i < q; i++) {
      painterCountChange[l[i]]++;
      painterCountChange[r[i]]--;
    }

    int[] painterCountList = new int[n];
    int painterCount = 0;
    for (int i = 0; i < n; i++) {
      painterCount += painterCountChange[i];
      painterCountList[i] = painterCount;
    }

    int[] d = new int[n];
    for (int i = 0; i < n; i++) {
      if (painterCountList[i] != 1) continue;
      d[i] = 1;
    }
    
    int sum = 0;
    int[] prefixSum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      sum += d[i];
      prefixSum[i + 1] = sum;
    }
    
    int minRes = n + 1;
    int qWithMinRes = -1;
    for (int i = 0; i < q; i++) {
      int res = prefixSum[r[i]] - prefixSum[l[i]];
      if (minRes > res) {
        qWithMinRes = i;
      }
      minRes = Math.min(res, minRes);
    }
    return 0;
  }
  public static void main(String[] args) {
    int n = in.nextInt();
    int q = in.nextInt();

    int[] l = new int[q];
    int[] r = new int[q];
    int[] painterCountChange = new int[n + 1];
    for (int i = 0; i < q; i++) {
      l[i] = in.nextInt() - 1;
      r[i] = in.nextInt();
      painterCountChange[l[i]]++;
      painterCountChange[r[i]]--;
    }

    int[] painterCountList = new int[n];
    int painterCount = 0;
    for (int i = 0; i < n; i++) {
      painterCount += painterCountChange[i];
      painterCountList[i] = painterCount;
    }

    int[] d = new int[n];
    for (int i = 0; i < n; i++) {
      if (painterCountList[i] != 1) continue;
      d[i] = 1;
    }
    
    int sum = 0;
    int[] prefixSum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      sum += d[i];
      prefixSum[i + 1] = sum;
    }
    
    int minRes = n + 1;
    int qWithMinRes = -1;
    for (int i = 0; i < q; i++) {
      int res = prefixSum[r[i]] - prefixSum[l[i]];
      if (minRes > res) {
        qWithMinRes = i;
      }
      minRes = Math.min(res, minRes);
    }

    out.println("qWithMinRes : " + qWithMinRes);
    out.println("minRes : " + minRes);

    in.close();
    out.close();
  }
}