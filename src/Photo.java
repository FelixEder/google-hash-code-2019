public class Photo {
  private boolean isHorizontal;
  private String[] tags;

  public Photo(String horizontal, String[] tags) {
    isHorizontal = (horizontal.equals("H"));
    this.tags = tags;
  }

  public boolean isHorizontal() {
    return isHorizontal;
  }

  public String[] getTags() {
    return tags;
  }
}
