package LucioAbenteuer.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class HealthBar {
    public int life = 3;
    public Image image = Images.FULLHP;

    public void draw(GraphicsContext gc) {

        switch (life) {
            case 1 -> image = Images.LOWHP;
            case 2 -> image = Images.MIDHP;
            case 3 -> image = Images.FULLHP;
        }
        gc.drawImage(image, Const.CANVAS_WIDTH / 2 - 70, 25);
    }
}

