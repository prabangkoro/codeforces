import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String time1 = scanner.nextLine();
        String[] lineVector = time1.split(":");
        int hh1 = Integer.parseInt(lineVector[0]);
        int mm1 = Integer.parseInt(lineVector[1]);
        
        String time2 = scanner.nextLine();
        lineVector = time2.split(":");
        int hh2 = Integer.parseInt(lineVector[0]);
        int mm2 = Integer.parseInt(lineVector[1]);
        
        String result = calculateMiddleTime(hh1, mm1, hh2, mm2);
        System.out.println(result);
    }

    static String calculateMiddleTime(int hh1, int mm1, int hh2, int mm2) {
        int minute1 = convertToMinute(hh1, mm1);
        int minute2 = convertToMinute(hh2, mm2);
        int middleTime = minute1 + (minute2 - minute1) / 2;

        return minuteToString(middleTime);
    }

    static int convertToMinute(int h, int m) {
        return h * 60 + m;
    }

    static String minuteToString(int minute) {
        int h = minute / 60;
        int m = minute % 60;
        String hh = h < 10 ? prependZero(Integer.toString(h)) : Integer.toString(h);
        String mm = m < 10 ? prependZero(Integer.toString(m)) : Integer.toString(m);
        return hh + ":" + mm;
    }

    static String prependZero(String x) {
        return "0" + x;
    }
}