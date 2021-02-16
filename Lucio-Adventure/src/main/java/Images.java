import javafx.scene.image.Image;

public class Images {

    public final static Image MARIORIGHT = getImageSize("LucioRight.png");
    public final static Image MARIOLEFT = getImageSize("LucioLeft.png");
    public final static Image LUCIO_JUMP_LEFT = getImageSize("Lucio_Jump_Left.png");
    public final static Image LUCIO_JUMP_RIGHT = getImageSize("Lucio_Jump_Right.png");
    public final static Image FLOOR = getImageSize("Floor.png");
    public final static Image COIN = getImageSize("coin.gif");
    public final static Image GAME_BACKGROUND = getImageSize("Game_Background_Lvl1.png");
    public final static Image BLOCK = getImageSize("Block.png");
    public final static Image DOOR = getImageSize("Door.png");
    public final static Image COMPANIAN = getImageSize("companianCube.png");

    private static Image getImage(String imagePath,double height, double width) {
        try {
            return new Image("/" + imagePath,width,height,false,false);
        } catch (Exception ex){
            throw new RuntimeException("File not found: " + imagePath);
        }
    }
    private static Image getImageSize(String imagePath) {
        try {
            Image wimg =new Image("/" + imagePath);
            double h =wimg.getHeight()*(Const.BLOCK_SIZE/50);
            double w=wimg.getWidth()*(Const.BLOCK_SIZE/50);

            return getImage(imagePath,h,w);
        } catch (Exception ex){
            throw new RuntimeException("File not found: " + imagePath);
        }
    }



}
