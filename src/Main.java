import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private int collectionSize;
  private ArrayList<Photo> collection;

  public static void main(String[] args) {
    new Main();
  }

  public Main() {
    getInput();
  }

  public void getInput() {
    Scanner scanner = new Scanner(System.in);
    collectionSize = Integer.parseInt(scanner.nextLine());
    collection = new ArrayList<>();
    while(scanner.hasNextLine()) {
      String[] photo = scanner.nextLine().split("\\|",-1);
      int tagSize = Integer.parseInt(photo[1]);
      String[] tags = new String[tagSize];
      for(int i = 0; i < tagSize; i++) {
        tags[i] = photo[i+2];
      }
      collection.add(new Photo(photo[0], tags));
    }
  }

  public void printOutput() {

  }
}