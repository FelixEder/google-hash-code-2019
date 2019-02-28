import java.util.*;

public class Main {
  private int collectionSize;
  private ArrayList<Photo> collection;
  private ArrayList<Slide> slideShow;

  public static void main(String[] args) {
    new Main();
  }

  public Main() {
      getInput();

      slideShow = new ArrayList<>();

      Random random = new Random();
      int photoIndex = random.nextInt(collection.size());
      Photo firstPhoto = collection.get(photoIndex);
      collection.remove(photoIndex);
      boolean currentOrientation = firstPhoto.isHorizontal();

      if (currentOrientation) {
          slideShow.add(new Slide(firstPhoto, null));
      }else {
          for(int i=0; i<collection.size(); i++){
              Photo currPhoto = collection.get(i);
              if (!currPhoto.isHorizontal()) {
                  slideShow.add(new Slide(firstPhoto, currPhoto));
                  break;
              }
          }
      }

      for(int i=0; i<collection.size(); i++){
          Slide currentSlide = slideShow.get(slideShow.size() - 1);
          Photo nextPhoto = collection.get(i);
          if (nextPhoto.isHorizontal()) {
              Slide newSlide = new Slide(nextPhoto, null);
              if (getTransitionScore(currentSlide, newSlide) >= 1) {
                  slideShow.add(newSlide);
              }
          }else {
              for (int j = i; j < collection.size(); j++) {
                  Photo maybeVertical = collection.get(j);
                  if (!maybeVertical.isHorizontal()){
                    Slide newSlide = new Slide(nextPhoto, maybeVertical);
                    if (getTransitionScore(currentSlide, newSlide) >= 1) {
                        slideShow.add(newSlide);
                        break;
                    }
                  }
              }
          }
      }
      printOutput();
  }

  public void getInput() {
    Scanner scanner = new Scanner(System.in);
    collectionSize = Integer.parseInt(scanner.nextLine());
    collection = new ArrayList<>();
    int iteration = 0;
    while(scanner.hasNextLine()) {
      String[] photo = scanner.nextLine().split("\\s+");
      int tagSize = Integer.parseInt(photo[1]);
      Set<String> tags = new HashSet<>();
      for(int i = 0; i < tagSize; i++) {
        tags.add(photo[i+2]);
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

  public int getTransitionScore(Slide slideOne, Slide slideTwo) {
    Set<String> slideOneTags;
    Set<String> slideTwoTags;

    if(slideOne.hasSingleHorizontal()) {
      slideOneTags = slideOne.getFirstPhoto().getTags();
    } else {
      slideOneTags = slideOne.getFirstPhoto().getTags();
      slideOneTags.addAll(slideOne.getSecondPhoto().getTags());
    }

    if(slideTwo.hasSingleHorizontal()) {
      slideTwoTags = slideTwo.getFirstPhoto().getTags();
    } else {
      slideTwoTags = slideTwo.getFirstPhoto().getTags();
      slideTwoTags.addAll(slideTwo.getSecondPhoto().getTags());
    }

    int commonTags = 0;
    int tagsInOne = 0;
    int tagsInTwo = 0;

    for(String tag: slideOneTags) {
      if(slideTwoTags.contains(tag)) {
        commonTags++;
      } else {
        tagsInOne++;
      }
    }

    for(String tag: slideTwoTags) {
      if(!slideTwoTags.contains(tag))
        tagsInTwo++;
    }

    return Math.min(Math.min(commonTags, tagsInOne), tagsInTwo);
  }
}
