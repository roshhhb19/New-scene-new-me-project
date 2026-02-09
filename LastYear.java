import org.code.theater.*;
import org.code.media.*;

public class LastYear extends Scene {

  private String[] images;
  

  public LastYear(String[] images) {
    this.images = images;
  }

    /**
   * Top level drawScene method
   */
  public void drawScene() {
    drawTitleScreen();
    pause(2);
    drawImage("IMG_2504.jpeg", 0, 0, 400, 400, 0);
    drawStack(true);
  }

  
  /**
   * Creates a "stacking" animations with random angle rotations
   * of the image.
   */
  public void drawStack(boolean hasBoarder) {
    int centerX = 200;  // center of the stack
    int centerY = 200;  // center of the stack
    int size = 250;
    
    for (String image : images) {
      // choose a random degree to rotate (0-45)
      int angle = (int) (Math.random() * 46);
      // if odd angle, rotate other direction
      if (angle % 2 == 1) {
        angle = (-1) * angle;
      }
      double dAngle = 0;
      
      // calculate position for center-based rotation
      // standard 2D rotation: 
      // newX = x * cos(angle) - y * sin(angle)
      // newY = x * sin(angle) + y * cos(angle)
      double radians = Math.toRadians(dAngle);
      double halfSize = size / 2.0;
      int adjustedX = (int)(centerX - (halfSize * Math.cos(radians) - halfSize * Math.sin(radians)));
      int adjustedY = (int)(centerY - (halfSize * Math.sin(radians) + halfSize * Math.cos(radians)));
      
      // black boarder - 5px offset all around
      if (hasBoarder) {
        double boarderHalfSize = (size + 10) / 2.0;
        int boarderX = (int)(centerX - (boarderHalfSize * Math.cos(radians) - boarderHalfSize * Math.sin(radians)));
        int boarderY = (int)(centerY - (boarderHalfSize * Math.sin(radians) + boarderHalfSize * Math.cos(radians)));
        
      }
      
      // image on top of black boarder (if drawn)
      drawImage(image, adjustedX, adjustedY, size, dAngle);
      pause(1);
    }
  }
  public void drawTitleScreen() {
    setTitleScreenStyle();
    clear("white");
    drawText("Pictures", 100, 175);
    drawText("From", 140, 225);
    drawText("Last Year", 100, 275);
  }

  
  public void setTitleScreenStyle() {
    setTextHeight(50);
    setTextColor("pink");
    setTextStyle(Font.SANS, FontStyle.ITALIC);
    }
  
}


