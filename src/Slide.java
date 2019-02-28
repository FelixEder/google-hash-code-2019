public class Slide {
  private Photo firstPhoto;
  private Photo secondPhoto;

  public Slide(Photo firstPhoto, Photo secondPhoto) {
    this.firstPhoto = firstPhoto;
    this.secondPhoto = secondPhoto;
  }

  public Photo getFirstPhoto() {
    return firstPhoto;
  }

  public Photo getSecondPhoto() {
    return secondPhoto;
  }

  public boolean hasSingleHorizontal() {
    return (secondPhoto == null);
  }
}