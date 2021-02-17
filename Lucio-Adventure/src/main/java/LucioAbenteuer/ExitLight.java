package LucioAbenteuer;

import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Affine;
import org.dyn4j.geometry.Polygon;
import org.dyn4j.geometry.Rectangle;

public class ExitLight {
    public static int e = -70;

    public Image image = Images.LIGHTOFF;





    public void draw(GraphicsContext gc) {


        gc.drawImage(image, Const.CANVAS_WIDTH / 2 + e, 130);

    }
}

