public class Photo {
  private boolean isHorizontal;
  private String[] tags;
  private int ID;

  public Photo(String horizontal, String[] tags, int ID) {
    isHorizontal = (horizontal.equals("H"));
    this.tags = tags;
    this.ID = ID;
  }

  public boolean isHorizontal() {
    return isHorizontal;
  }

  public String[] getTags() {
    return tags;
  }

  public int getID() {
    return ID;
  }
}
