import java.util.*;
import java.io.*;

public class Main{

  ArrayList<Integer> leftArray = new ArrayList<>();
  ArrayList<Integer> rightArray = new ArrayList<>();
  int diff = 0;
  public static void main(String[] args){
    new Main();
  }

  public Main(){
    readData();
    Collections.sort(leftArray);
    Collections.sort(rightArray);
    for (int i = 0; i < Math.min(leftArray.size(), rightArray.size()); i++) {
      int counter = 0;
      for (int j = 0; j < rightArray.size(); j++) {
        if (leftArray.get(i).equals(rightArray.get(j))) {
          counter++;
        }
      }
      diff += (leftArray.get(i) * counter);
    }
    System.out.println("Diff: " + diff);
  }

  public void readData(){
    try {
      BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] splitLine = line.split("\\s");
        leftArray.add(Integer.parseInt(splitLine[0]));
        rightArray.add(Integer.parseInt(splitLine[3]));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
