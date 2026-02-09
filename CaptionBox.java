import org.code.theater.*;
import org.code.media.*;

public class CaptionBox extends Scene {

  private String[] lines = {
    "Memories",
    "From Last Year",
    "Growth"
  };

  public void drawCaptionBox(int xPos, int yPos, int width, int height) {
    setFillColor("black");
    drawRectangle(xPos + 5, yPos + 5, width, height);

    setFillColor("white");
    drawRectangle(xPos, yPos, width, height);

    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("black");
    setTextHeight(24);

    int yLinePos = yPos + 30;
    for (String line : lines) {
      drawText(line, xPos + 10, yLinePos);
      yLinePos += 28;
    }
  }
}
