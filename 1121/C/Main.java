import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int k = in.nextInt();

    int[] submissions_length = new int[n];
    for (int i = 0; i < n; i++) {
      submissions_length[i] = in.nextInt();
    }

    int time_end = 0;
    int current_time = 1;
    int[] remaining_test = new int[k];
    int[] current_test = new int[k];
    int next_job = 0;
    for (int i = 0; i < Math.min(n, k); i++) {
      remaining_test[i] = submissions_length[i];
      time_end = Math.max(time_end, remaining_test[i]);
      current_test[i] = i;
      next_job++;
    }
    int finished_job = 0;
    int interesting_submission = 0;
    HashSet<Integer> interesting_submission_list = new HashSet<>();
    while (current_time <= 150 * n) {
      // update each process
      for (int i = 0; i < k; i++) {
        // out.println("remaining test: " + remaining_test[i]);
        if (remaining_test[i] == -1) continue;
        if (remaining_test[i] >= 0) remaining_test[i]--;
        // finished submission
        if (remaining_test[i] == -1) {
          // out.println("finished job: " + (current_test[i] + 1) + " k: " + (i + 1));
          finished_job++;
          if (next_job < n) {
            current_test[i] = next_job;
            remaining_test[i] = submissions_length[next_job] - 1;
            time_end = Math.max(time_end, current_time + submissions_length[next_job]);
            next_job++;
          }
        }
      }
      // calculate interest
      long d = Math.round((double) (100 * finished_job) / (double) n);
      for (int i = 0; i < k; i++) {
        // already interesting!!!
        if (interesting_submission_list.contains(current_test[i])) continue;
        // already end
        if (remaining_test[i] == -1) continue;
        // out.println("time: " + current_time + " machine: " + (i + 1) + " %: " + d + " submission: " + (submissions_length[current_test[i]] - remaining_test[i]));
        if ((submissions_length[current_test[i]] - remaining_test[i]) == d) {
          // out.println("interesting !!!");
          interesting_submission++;
          interesting_submission_list.add(current_test[i]);
        }
      }
      current_time++;
    }

    out.println(interesting_submission);

    in.close();
    out.close();
  }
}