import java.util.Scanner;
import java.util.Arrays;

public class Main {
  int safeCount = 0;
  public static void main(String[] args){
    new Main();
  }

  public Main(){
    readData();
  }

  public void readData() {
    Scanner scan = new Scanner(System.in);
    String line;
    while (scan.hasNext()) {
      line = scan.nextLine();
      String[] splitLine = line.split("\\s");
      checkData(splitLine);
    }
    System.out.println("Count: " + safeCount);
  }

  public String[] deleteIndex(String[] array, int index){
    String[] newArray = new String[array.length - 1];
    int newIndex = 0;
    for (int i = 0; i < array.length; i++) {
      if (i != index) {
        newArray[newIndex] = array[i];
        newIndex++;
      }
    }
    return newArray;
  }

  public boolean checkSmallerArray(String[] array){
    boolean increase = false;
    boolean decrease = false;
    for (int i = 0; i < array.length - 1; i++) {
      if (Integer.parseInt(array[i]) == Integer.parseInt(array[i + 1])) {
        return false;
      }
      if (i == 0 && Integer.parseInt(array[0]) > Integer.parseInt(array[1])) {
        decrease = true;
      } else {
        if (Integer.parseInt(array[0]) < Integer.parseInt(array[1])) {
          increase = true;
        }
      }
      if (Math.abs(Integer.parseInt(array[i]) - Integer.parseInt(array[i + 1])) > 3) {
        return false;
      }
      if (increase) {
        if (Integer.parseInt(array[i]) > Integer.parseInt(array[i + 1])) {
          return false;
        }
      } else {
        if (decrease) {
          if (Integer.parseInt(array[i]) < Integer.parseInt(array[i + 1])) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public boolean checkData(String[] array){
    boolean increase = false;
    boolean decrease = false;
    for (int i = 0; i < array.length - 1; i++) {
      if (checkSmallerArray(deleteIndex(array, i))) {
        safeCount++;
        return false;
      }
      if (Integer.parseInt(array[i]) == Integer.parseInt(array[i + 1])) {
        if (checkSmallerArray(deleteIndex(array, i + 1))) {
          safeCount++;
        }
        return false;
      }
      if (i == 0 && Integer.parseInt(array[0]) > Integer.parseInt(array[1])) {
        decrease = true;
      } else {
        if (Integer.parseInt(array[0]) < Integer.parseInt(array[1])) {
          increase = true;
        }
      }
      if (Math.abs(Integer.parseInt(array[i]) - Integer.parseInt(array[i + 1])) > 3) {
        if (checkSmallerArray(deleteIndex(array, i + 1))) {
          safeCount++;
        }
        return false;
      }
      if (increase) {
        if (Integer.parseInt(array[i]) > Integer.parseInt(array[i + 1])) {
          if (checkSmallerArray(deleteIndex(array, i + 1))) {
            safeCount++;
          }
          return false;
        }
      } else {
        if (decrease) {
          if (Integer.parseInt(array[i]) < Integer.parseInt(array[i + 1])) {
            if (checkSmallerArray(deleteIndex(array, i + 1))) {
              safeCount++;
            }
            return false;
          }
        }
      }
    }
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
    safeCount++;
    return true;
  }
}
