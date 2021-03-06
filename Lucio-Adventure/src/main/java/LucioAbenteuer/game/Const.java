package LucioAbenteuer.game;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class Const {

    public static Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    public static final double CANVAS_WIDTH = (int) screenBounds.getWidth();
    public static final double CANVAS_HEIGHT = (int) screenBounds.getHeight();
    public static final double BLOCK_SIZE = CANVAS_WIDTH / 30; // Length of level row


}
