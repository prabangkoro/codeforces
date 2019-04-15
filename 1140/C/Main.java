import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  static class Song {
    int time, beauty;
    Song (int time, int beauty) {
      this.time = time;
      this.beauty = beauty;
    }
  }
  public static void main(String[] args) {
    int n = in.nextInt();
    int k = in.nextInt();

    Song songList[] = new Song[n];
    for (int i = 0; i < n; i++) {
      songList[i] = new Song(in.nextInt(), in.nextInt());
    }
    Arrays.sort(songList, (a, b) -> b.beauty - a.beauty);

    long maxPleasure = 0;
    long sumSongDuration = 0;
    PriorityQueue<Integer> songBundle = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      sumSongDuration += songList[i].time;
      songBundle.add(songList[i].time);
      while (songBundle.size() > k) {
        sumSongDuration -= songBundle.poll();
      }
      maxPleasure = Math.max(maxPleasure, sumSongDuration * songList[i].beauty);
    }

    out.println(maxPleasure);

    in.close();
    out.close();
  }
}