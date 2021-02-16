import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class Const {

   // public static final int BLOCK_SIZE = 45;
   // public static final int CANVAS_WIDTH = 180;
   // public static final int CANVAS_HEIGHT = 700;
   public static Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

    public static final   double BLOCK_SIZE = (int)  screenBounds.getWidth()/30; // Length of level row
    public static final  double CANVAS_WIDTH = (int)  screenBounds.getWidth();
    public static final double CANVAS_HEIGHT = (int) screenBounds.getHeight();

}
