import java.util.Set;

public class Photo {
  private boolean isHorizontal;
  private Set<String> tags;
  private int ID;

  public Photo(String horizontal, Set<String> tags, int ID) {
    isHorizontal = (horizontal.equals("H"));
    this.tags = tags;
    this.ID = ID;
  }

  public boolean isHorizontal() {
    return isHorizontal;
  }

  public Set<String> getTags() {
    return tags;
  }

  public int getID() {
    return ID;
  }
}
