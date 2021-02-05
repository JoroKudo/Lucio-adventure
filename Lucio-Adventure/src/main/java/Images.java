import javafx.scene.image.Image;

public class Images {

    public final static Image MARIO = getImage("MarioLeft.png");
    public final static Image GROUND = getImage("Wall.png");
    public final static Image GAME_BACKGROUND = getImage("gambbg.png");

    private static Image getImage(String imagePath) {
        return new Image("/" + imagePath);
    }
}
