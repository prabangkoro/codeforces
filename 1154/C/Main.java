import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    // monday, tuesday, wednesday, thursday, friday, saturday, sunday
    // fish: monday, thursday, sunday
    // rabbit: tuesday, saturday
    // chicken: wednesday, friday
    // a - b - c - a - c - b -a
    int maxWeekA = a / 3;
    int maxWeekB = b / 2;
    int maxWeekC = c / 2;
    int maxWeek = Math.min(maxWeekA, Math.min(maxWeekB, maxWeekC));
    // out.println("max week: " + maxWeek);
    a -= (maxWeek * 3);
    b -= (maxWeek * 2);
    c -= (maxWeek * 2);
    // out.println("a: " + a + " b: " + b + " c: " + c);

    int totalDays = maxWeek * 7;
    int remainingDays = 0;
    char[] gourmetSchedule = {'a', 'b', 'c', 'a', 'c', 'b', 'a'};

    for (int i = 0; i < 7; i++) {
      int filledDays = 0;
      int copyA = a;
      int copyB = b;
      int copyC = c;
      // out.println("filling i: " + i);
      for (int j = 0; j < 7; j++) {
        int day = (i + j) % 7;
        // out.println("day: " + day);
        // out.println("gourmet schedule: " + gourmetSchedule[day]);
        // out.println("a: " + a);
        // out.println("b: " + b);
        // out.println("c: " + c);
        if (gourmetSchedule[day] == 'a') {
          if (copyA > 0) {
            copyA--;
            filledDays++;
            remainingDays = Math.max(filledDays, remainingDays);
          } else {
            break;
          }
        } else if (gourmetSchedule[day] == 'b') {
          if (copyB > 0) {
            copyB--;
            filledDays++;
            remainingDays = Math.max(filledDays, remainingDays);
          } else {
            break;
          }
        } else if (gourmetSchedule[day] == 'c') {
          if (copyC > 0) {
            copyC--;
            filledDays++;
            remainingDays = Math.max(filledDays, remainingDays);
          } else {
            break;
          }
        }
      }
      out.println();
    }

    // out.println("total days: " + (totalDays));
    // out.println("remaining days: " + remainingDays);
    out.println((totalDays + remainingDays));

    in.close();
    out.close();
  }
}