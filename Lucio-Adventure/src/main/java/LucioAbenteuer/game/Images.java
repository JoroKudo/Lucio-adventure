package LucioAbenteuer.game;
import javafx.scene.image.Image;

public class Images {
    public final static Image MAINMENU = getImageSize("LucioMainMenu.png");
    public final static Image MARIORIGHT = getImageSize("LucioRight.png");
    public final static Image MARIOLEFT = getImageSize("LucioLeft.png");
    public final static Image LUCIO_JUMP_LEFT = getImageSize("Lucio_Jump_Left.png");
    public final static Image LUCIO_JUMP_RIGHT = getImageSize("Lucio_Jump_Right.png");
    public final static Image LUCIO_WALK_LEFT = getImageSize("LucioWalkL.gif");
    public final static Image LUCIO_WALK_RIGHT = getImageSize("LucioWalkR.gif");
    public final static Image FLOOR = getImageSize("Floor.png");
    public final static Image COIN = getImageSize("coin.gif");
    public final static Image KEY = getImageSize("Key.png");
    public final static Image LVL1 = getImageSize("Chamb1.png");
    public final static Image LVL2 = getImageSize("Chamb2.png");
    public final static Image LVL3 = getImageSize("Chamb3.png");
    public final static Image LVL4 = getImageSize("Chamb4.png");
    public final static Image WIN = getImageSize("win.png");
    public final static Image BLOCK = getImageSize("Block.png");
    public final static Image WALL = getImageSize("Wall.png");
    public final static Image DOOR = getImageSize("Door.png");
    public final static Image HEART = getImageSize("Heart.png");
    public final static Image COMPANIAN = getImageSize("companianCube.png");
    public final static Image BUTTON = getImageSize("Buttonn.png");
    public final static Image LIGHTOFF = getImageSize("LightOff.png");
    public final static Image LIGHTON = getImageSize("LightOn.png");
    public final static Image LOWHP = getImageSize("LowHP.png");
    public final static Image MIDHP = getImageSize("MidHP.png");
    public final static Image FULLHP = getImageSize("FullHP.png");
    public final static Image LASER_BEAM = getImageSize("LaserBeam.png");
    public final static Image RED_LASER = getImageSize("laserobstacle.png");
    public final static Image GAMEOVER = getImageSize("GameOver.png");
    public final static Image SPIKES = getImageSize("Spikes.png");
    public final static Image SPIKES_SMOLL = getImageSize("SpikesSmall.png");
    public final static Image SPIKES_SMOLR = getImageSize("SpikesSmalr.png");
    public final static Image LASERBUTTTON = getImageSize("ActivButton.png");
    public final static Image LASER = getImageSize("Laser.png");

    public static Image bgp = Images.LVL1;

    private static Image getImage(String imagePath, double height, double width) {
        try {
            return new Image("/Images/" + imagePath, width, height, false, false);
        } catch (Exception ex) {
            throw new RuntimeException("File not found: " + imagePath);
        }
    }
    private static Image getImageSize(String imagePath) {
        try {
            Image wimg = new Image("/Images/" + imagePath);
            double h = wimg.getHeight() * (Const.BLOCK_SIZE / 50);
            double w = wimg.getWidth() * (Const.BLOCK_SIZE / 50);
            return getImage(imagePath, h, w);
        } catch (Exception ex) {
            throw new RuntimeException("File not found: " + imagePath);
        }
    }
}
