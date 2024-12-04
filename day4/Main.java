import java.util.Scanner;
import java.io.*;

public class Main {

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
      BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
      y = 0;
      String line;
      while ((line = reader.readLine()) != null) {
        for (int i = 0; i < line.length(); i++) {
          array[y][i] = line.charAt(i) + "";
          System.out.print(array[y][i]);
        }
        System.out.println();
        y++;
      }
    } catch (Exception e){
      e.printStackTrace();
    }

    //Check array nach XMAS
    //HORIZONTAL - VON LINKS NACH RECHTS - DONE
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        if (j < array[i].length && array[i][j].equals("X")) {
          if (j + 1 < array[i].length && array[i][j + 1].equals("M")) {
            if (j + 2 < array[i].length && array[i][j + 2].equals("A")) {
              if (j +  3 < array[i].length && array[i][j + 3].equals("S")) {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("NACH L->R Count: " + count);

    //HORIZONTAL - VON RECHTS NACH LINKS - DONE
    for (int i = 0; i < array.length; i++) {
      for (int j = array[i].length - 1; j > 0; j--) {
        if (j > 0 && array[i][j].equals("X")) {
          if (j - 1 > 0 && array[i][j - 1].equals("M")) {
            if (j - 2 > 0 && array[i][j - 2].equals("A")) {
              if (j - 3 > 0 && array[i][j - 3].equals("S")) {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("NACH R->L Count: " + count);

    //VERTIKAL - VON OBEN NACH UNTEN
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        if (i < array.length - 3 && array[i][j].equals("X")) {
          if (i < array.length - 3 && array[i + 1][j].equals("M")) {
            if (i < array.length - 3 && array[i + 2][j].equals("A")) {
              if (i < array.length - 3 && array[i + 3][j].equals("S")) {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("NACH O->U Count: " + count);

    //VERTIKAL - VON UNTEN NACH OBEN
    for (int i = array.length - 1; i > 0; i--) {
      for (int j = 0; j < array[i].length; j++) {
        if (i > 2 && array[i][j].equals("X")) {
          if (i > 2 && array[i - 1][j].equals("M")) {
            if (i > 2 && array[i - 2][j].equals("A")) {
              if (i > 2 && array[i - 3][j].equals("S")) {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("NACH U->O Count: " + count);

    //DIAGONAL - VON OBEN LINKS NACH UNTEN RECHTS
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        if (i < array.length - 3 && j < array[i].length - 3 && array[i][j].equals("X")) {
          if (i < array.length - 3 && j < array[i].length - 3 && array[i + 1][j + 1].equals("M")) {
            if (i < array.length - 3 && j < array[i].length - 3 && array[i + 2][j + 2].equals("A")) {
              if (i < array.length - 3 && j < array[i].length - 3 && array[i + 3][j + 3].equals("S")) {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("NACH OL->UR Count: " + count);

    //DIAGONAL - VON UNTEN RECHTS NACH OBEN LINKS
    for (int i = array.length - 1; i > 0; i--) {
      for (int j = array.length - 1; j > 0; j--) {
        if (i - 3 >= 0  && j - 3 >= 0 && array[i][j].equals("X")) {
          if (array[i - 1][j - 1].equals("M")) {
            if (array[i - 2][j - 2].equals("A")) {
              if (array[i - 3][j - 3].equals("S")) {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("NACH UR->OL Count: " + count);

    //DIAGONAL - VON OBEN RECHTS NACH UNTEN LINKS
    for (int i = 0; i < array.length; i++) {
      for (int j = array.length - 1; j > 0; j--) {
        if (i + 3 <= array.length - 1  && j - 3 >= 0 && array[i][j].equals("X")) {
          if (array[i + 1][j - 1].equals("M")) {
            if (array[i + 2][j - 2].equals("A")) {
              if (array[i + 3][j - 3].equals("S")) {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("NACH OR->UL Count: " + count);

    //DIAGONAL - VON UNTEN LINKS NACH OBEN RECHTS
    for (int i = array.length - 1; i > 0; i--) {
      for (int j = 0; j < array.length; j++) {
        if (i >= array.length - 3  && j + 3 < array.length - 1 && array[i][j].equals("X")) {
          if (array[i - 1][j + 1].equals("M")) {
            if (array[i - 2][j + 2].equals("A")) {
              if (array[i - 3][j + 3].equals("S")) {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("NACH UL->OR Count: " + count);
  }
}
