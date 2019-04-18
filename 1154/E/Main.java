import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int k = in.nextInt();

    LinkedList<Integer> students = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      students.add(in.nextInt());
    }

    int maxSkill = 0;
    int maxSkillIndex = 0;
    int index = 0;
    Iterator<Integer> iterator = students.iterator();
    while (iterator.hasNext()) {
      int skill = iterator.next();
      if (skill > maxSkill) {
        maxSkillIndex = index;
        maxSkill = skill;
      }
      index++;
    }

    in.close();
    out.close();
  }
}