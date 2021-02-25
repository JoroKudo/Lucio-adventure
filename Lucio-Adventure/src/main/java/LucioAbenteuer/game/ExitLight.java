package LucioAbenteuer.game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ExitLight {
    public double x;
    public double y;
    public ExitLight(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Image image = Images.LIGHTOFF;
    public void draw(GraphicsContext gc) {
        gc.drawImage(image, x, y);
    }
}

