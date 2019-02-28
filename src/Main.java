import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private int collectionSize;
  private ArrayList<Photo> collection;
  private ArrayList<Slide> slideShow;

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
    int iteration = 0;
    while(scanner.hasNextLine()) {
      String[] photo = scanner.nextLine().split("\\s+");
      int tagSize = Integer.parseInt(photo[1]);
      String[] tags = new String[tagSize];
      for(int i = 0; i < tagSize; i++) {
        tags[i] = photo[i+2];
      }
      collection.add(new Photo(photo[0], tags, iteration));
      iteration++;
    }
  }

  public void printOutput() {
    int slideShowSize = slideShow.size();
    System.out.println(slideShowSize);
    for(int i = 0; i < slideShowSize; i++) {
      Slide slide = slideShow.get(i);
      if(slide.hasSingleHorizontal()) {
        System.out.println(slide.getFirstPhoto().getID());
      } else
        System.out.println(slide.getFirstPhoto().getID() + " " + slide.getSecondPhoto().getID());
    }
  }
}