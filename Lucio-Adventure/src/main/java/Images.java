import javafx.scene.image.Image;

public class Images {

    public final static Image MARIORIGHT = getImage("LucioRight.png");
    public final static Image MARIOLEFT = getImage("Lucioleft.png");
    public final static Image LUCIO_JUMP_LEFT = getImage("Lucio_Jump_Left.png");
    public final static Image LUCIO_JUMP_RIGHT = getImage("Lucio_Jump_Right.png");
    public final static Image FLOOR = getImage("Floor.png");
    public final static Image COIN = getImage("Coin.png");
    public final static Image GAME_BACKGROUND = getImage("Game_Background_Lvl1.png");
    public final static Image BLOCK = getImage("Block.png");
    public final static Image DOOR = getImage("Door.png");

    private static Image getImage(String imagePath) {
        try {
            return new Image("/" + imagePath);
        } catch (Exception ex){
            throw new RuntimeException("File not found: " + imagePath);
        }
    }
}
