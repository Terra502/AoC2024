import java.util.Scanner;
import java.io.*;

public class Part2 {
  public static void main(String[] args){
    String[][] array;
    int count = 0;
    Scanner scan = new Scanner(System.in);
    int x = 0, y = 0;
    while (scan.hasNext()) {
      String line = scan.nextLine();
      y++;
      x = line.length();
    }
    array = new String[y][x];
    try {
      BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
      y = 0;
      String line;
      while ((line = reader.readLine()) != null) {
        for (int i = 0; i < line.length(); i++) {
          array[y][i] = line.charAt(i) + "";
        }
        System.out.println();
        y++;
      }
    } catch (Exception e){
      e.printStackTrace();
    }

    for (int i = 1; i < array.length - 1; i++) {
      for (int j = 1; j < array[i].length - 1; j++) {
        if (array[i][j].equals("A")) {
          if ((array[i - 1][j - 1].equals("M") && array[i + 1][j + 1].equals("S")) || (array[i - 1][j - 1].equals("S") && array[i + 1][j + 1].equals("M"))) {
            if ((array[i + 1][j - 1].equals("S") && array[i - 1][j + 1].equals("M")) || (array[i + 1][j - 1].equals("M") && array[i - 1][j + 1].equals("S"))) {
              count++;
            }
          }
        }
      }
    }
    System.err.println("Count: " + count);
  }
}
