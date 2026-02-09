import org.code.theater.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // List of images read from text file, names match in assets
    String[] images = FileReader.toStringArray("imageNames.txt");

    String[] random = {"a", "b", "c"};
    
    // Create scene objects
    LastYear scene = new LastYear(images);
    ThisYear thisYear = new ThisYear();

    // Call top level methods
    scene.drawScene();
    thisYear.drawScene();

    // Play scenes in theater
    Theater.playScenes(scene,thisYear);
    
  }
}