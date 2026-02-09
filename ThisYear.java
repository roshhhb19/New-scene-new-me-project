import org.code.theater.*;
import org.code.media.*;

public class ThisYear extends Scene {

  // Instance variable
  private String[] images;

  // Constructors
  public ThisYear(String[] images) {
    this.images = images;
  }

  public ThisYear() {
    this.images = FileReader.toStringArray("thisYearImages.txt");
  }

  /**
   * Top level drawScene method
   */
  public void drawScene() {
    drawTitleScreen();
    pause(1);
    clear("white");
    drawImage("IMG_2504.jpeg", 0, 0, 400, 400, 0);
    drawTiles(3, true);
  }

  /**
   * Creates a tile arrangement of the images
   */
  public void drawTiles(int size, boolean staggered) {

    if (size <= 0 || size > 4) {
      System.out.println("Only use size 1, 2, 3, or 4");
      return;
    }

    int tileSize = getTileSize(size);
    int imageIndex = 0;

    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {

        if (imageIndex < images.length) {
          drawImage(images[imageIndex],
                    col * tileSize,
                    row * tileSize,
                    tileSize);
          imageIndex++;
        }

        if (staggered) {
          pause(0.5);
        }
      }
    }
  }

  /**
   * Determines the tile size
   */
  public int getTileSize(int size) {
    if (size == 1) {
      return 400;
    } else if (size == 2) {
      return 200;
    } else if (size == 3) {
      return 133;
    } else {
      return 100;
    }
  }

  // Title screen methods
  public void drawTitleScreen() {
    setTitleScreenStyle();
    clear("white");
    drawText("Goals", 100, 175);
    drawText("For", 140, 225);
    drawText("This Year", 100, 275);
  }

  public void setTitleScreenStyle() {
    setTextHeight(50);
    setTextColor("pink");
    setTextStyle(Font.SANS, FontStyle.ITALIC);
  }
}
